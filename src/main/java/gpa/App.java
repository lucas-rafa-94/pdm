package gpa;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.json.XML;

public class App {
    public static String retornoValorAtributo (String atributo, String retornoPDH ) throws Exception {
        return  retornoPDH.substring(retornoPDH.indexOf(":"+atributo+">"), retornoPDH.indexOf("</", retornoPDH.indexOf(":"+atributo+">"))).replace(":"+atributo+">","");
    }

    private static final Log log = LogFactory.getFactory().getInstance(App.class);

    public static String retornaEtiqueta( String pdh, String pdm, int valor){

        StringBuilder etiqueta = new StringBuilder();
        JSONObject xmlJSONObj = XML.toJSONObject(pdm.replace("xmlns=\"\"",""));
        CampoCollection [] moduloPdm =  new Gson().fromJson(xmlJSONObj.getJSONObject("CampoCollection").getJSONArray("Campo").toString().replace("{\"xsi:nil\":true}", "\"\""), CampoCollection[].class);

        //RN.1 – Ordem dos Campos
        for (int i = 0; i < moduloPdm.length ; i++){
            //RN.2 – Caracter de Prefixo
            etiqueta.append(Business.rn2(moduloPdm[i]));
            //RN.4 - Mutabilidade && RN.6 – Abreviação && RN.5 – Dicionário
            etiqueta.append(Business.rn4_rn6_rn5(moduloPdm[i],pdh, valor));
            //RN.7 – Regra de Lista de Valores
            etiqueta.append(Business.rn7(moduloPdm[i]));
            //RN.09 - Trunca Descrição
            etiqueta.append(Business.rn9(moduloPdm[i],pdh));
            //RN.3 – Caracter de Sufixo
            etiqueta.append(Business.rn3(moduloPdm[i]));
        }
        //RN.10 - Trunca Descrição
        return Business.rn10(etiqueta.toString(), valor);
    }
}
