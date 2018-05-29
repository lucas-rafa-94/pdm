package gpa;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {

    public static String retornoValorAtributo (String atributo, String retornoPDH ) {
        String retorno = "";
            try{
                retorno = retornoPDH.substring(retornoPDH.indexOf(":"+atributo+">"), retornoPDH.indexOf("</", retornoPDH.indexOf(":"+atributo+">"))).replace(":"+atributo+">","");
                System.out.println(retorno);
            }catch (Exception e){
                log.error("atributo " + atributo +  " nao encontrado!!");
                e.printStackTrace();
            }
        return  retorno.replace("(", "").replace(")", "");
    }

    public static String retornoValorAtributoComGrupoAtributo (String atributo, String grupoAtributo, String retornoPDH ) {
        String resultado = "";
        JSONObject xmlJSONObj = XML.toJSONObject(retornoPDH.replace("xmlns=\"\"", "").replace("xsi:nil=\"true\"", "")).getJSONObject("ns0:findItemResponse").getJSONObject("ns2:result").getJSONObject("ns0:Value").getJSONObject("ns1:ItemEffCategory");
        try {
            resultado = xmlJSONObj.getJSONObject("ns6:" + grupoAtributo.trim()).getString("ns8:" + atributo.trim());
        }catch (JSONException e){
            resultado = String.valueOf(xmlJSONObj.getJSONObject("ns6:" + grupoAtributo.trim()).getInt("ns8:" + atributo.trim()));
        }catch (Exception e){
            log.error("atributo " + atributo +  " nao encontrado!!");
            e.printStackTrace();
        }
        return resultado;
    }

    private static final Log log = LogFactory.getFactory().getInstance(App.class);

    public static String retornaEtiqueta( String pdh, String pdm, String valor){
        String resultadoFinal = "";
        String medida_final = "";
        String medida_provisoria = "";
        boolean mPrincial = false;
        StringBuilder etiqueta = new StringBuilder();

        log.error(pdm);
        JSONObject xmlJSONObj = XML.toJSONObject(pdm.replace("xmlns=\"\"","").replace("xsi:nil=\"true\"", ""));
        log.error(xmlJSONObj);
        CampoCollection [] moduloPdm =  new Gson().fromJson(xmlJSONObj.getJSONObject("CampoCollection").getJSONArray("Campo").toString().replace("{\"xsi:nil\":true}", "\"\""), CampoCollection[].class);

        String me = Business.rn9(pdh);
        Arrays.asList(moduloPdm).sort(Comparator.comparingInt(CampoCollection::getOrdemCampo));

        for (int i = 0; i < moduloPdm.length ; i++) {
            if (!App.retornoValorAtributoComGrupoAtributo(moduloPdm[i].getIdNomeCampoPdh().getNomeCampoApiPdh(), moduloPdm[i].getIdGrupoAtributo().getNomeGrupoDeAtributoApiPdh(),pdh).equals("")) {
                if (moduloPdm[i].getMutavel() == 1 && moduloPdm[i].getTrataListaValor() == 0) {
                    if (moduloPdm[i].getMedidaPrincipal() == 1) {
                        mPrincial = true;
                        etiqueta.append("-");
                        while (moduloPdm[i].getMedidaPrincipal() == 1) {
                            //etiqueta.append(Business.rn2(moduloPdm[i]));
                            etiqueta.append(Business.rn4_rn6_rn5(moduloPdm[i], pdh, valor));
                            etiqueta.append(Business.rn7(moduloPdm[i]));
                           // etiqueta.append(Business.rn3(moduloPdm[i]));
                            etiqueta.append(":");
                            if (i == moduloPdm.length - 1) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        etiqueta.append("+");
                        if (i == moduloPdm.length - 1) {
                            break;
                        }
                    } else {
                        etiqueta.append(Business.rn2(moduloPdm[i]));
                        etiqueta.append(Business.rn4_rn6_rn5(moduloPdm[i], pdh, valor));
                        etiqueta.append(Business.rn7(moduloPdm[i]));
                        etiqueta.append(Business.rn3(moduloPdm[i]));
                    }
                } else if (moduloPdm[i].getTrataListaValor() == 1) {
                        if(!Business.rn7(moduloPdm[i]).equals("")){
                            etiqueta.append(Business.rn2(moduloPdm[i]));
                            etiqueta.append(Business.rn7(moduloPdm[i]));
                            etiqueta.append(Business.rn3(moduloPdm[i]));
                        }
                    }
            }
        }
        if(mPrincial){

            medida_provisoria = etiqueta.toString().substring(etiqueta.toString().indexOf("-"), etiqueta.toString().indexOf("+", etiqueta.toString().indexOf("-")) + 1);
            String [] medida_provisoria_list = medida_provisoria.replace("-","").replace("+","").split(":");

            for (int t = 0; t < medida_provisoria_list.length; t++){
                if (medida_provisoria_list[t].contains(me)){
                    medida_final = medida_provisoria_list[t] + medida_provisoria_list[t+1];
                    break;
                }
            }
            String medida_final_semUnidade = medida_final.replaceAll("[0-9]", "");

            try {

                String regexLevePague = "([L]+[0-9]+[" + medida_final_semUnidade + "]+[,]+[P]+[0-9]+[" + medida_final_semUnidade + "]+[" + " " + "])";
                Pattern pattern = Pattern.compile(regexLevePague);
                Matcher matcher = pattern.matcher(etiqueta.toString());

                if (matcher.find() == true) {
                    resultadoFinal = etiqueta.toString().replace(matcher.group(), matcher.group().replace(medida_final_semUnidade, ""));
                } else {
                    resultadoFinal = etiqueta.toString();
                }
            }catch (Exception e ){
                resultadoFinal = etiqueta.toString();
                e.printStackTrace();
            }
            //RN.10 - Trunca Descrição
            return Business.rn10(resultadoFinal.replace(medida_provisoria,medida_final), valor);
        }else{
            //RN.10 - Trunca Descrição
            return Business.rn10(etiqueta.toString(), valor);
        }
    }
}
