package gpa;

public class Business {

    private final static String ETIQUETA_35 = "Descrição do Produto 35";
    private final static String ETIQUETA_20 = "Descrição do Produto 20";
    private final static String ETIQUETA_120 = "Descrição do Produto 120";
    private final static String NADA_SUFIXO_PREFIXO = "nada";
    private final static String ESPACO_SUFIXO_PREFIXO = "espaco";

    //RN.4 - Mutabilidade && RN.6 – Abreviação && RN.5 – Dicionário
    public static String rn4_rn6_rn5 (CampoCollection campoCollection, String pdh , String valor){
        String resultado = "";
        if(campoCollection.getMutavel() == 1) {
            if (valor.equals(ETIQUETA_20)) {
                    if (!campoCollection.getDicionario().getAbr20().equals("") && campoCollection.getDicionario() != null) {
                        resultado  = campoCollection.getDicionario().getAbr20();
                    }else {
                    try {
                        resultado = truncaStrPara5(App.retornoValorAtributoComGrupoAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), campoCollection.getIdGrupoAtributo().getNomeGrupoDeAtributoApiPdh() ,pdh));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (valor.equals(ETIQUETA_35)) {
                    if (!campoCollection.getDicionario().getAbr35().equals("")) {
                        resultado  =  campoCollection.getDicionario().getAbr35();
                    } else {
                    try {
                        resultado = truncaStrPara5(App.retornoValorAtributoComGrupoAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), campoCollection.getIdGrupoAtributo().getNomeGrupoDeAtributoApiPdh() ,pdh));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (valor.equals(ETIQUETA_120)) {
                    if(!campoCollection.getDicionario().getPalavra().equals("")){
                        resultado  =  campoCollection.getDicionario().getPalavra();
                    }else if (!campoCollection.getEtiqueta().equals("nada")){
                        resultado  =  campoCollection.getEtiqueta();
                    }else {
                        try {
                            resultado = App.retornoValorAtributoComGrupoAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), campoCollection.getIdGrupoAtributo().getNomeGrupoDeAtributoApiPdh() ,pdh);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            } else {
                    try {
                        resultado  =  App.retornoValorAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), pdh);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }else{
            try {
                resultado = App.retornoValorAtributoComGrupoAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), campoCollection.getIdGrupoAtributo().getNomeGrupoDeAtributoApiPdh() ,pdh);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return resultado;
    }


    //RN.2 – Caracter de Prefixo
    public static String rn2(CampoCollection campoCollection){
        String resultado = "";

        if(campoCollection.getPrefixo().equals(ESPACO_SUFIXO_PREFIXO)){
            resultado = " ";
        }else if(!campoCollection.getPrefixo().equals(NADA_SUFIXO_PREFIXO)){
            resultado = campoCollection.getPrefixo();
        }
        return resultado;
    }
    //RN.7 – Regra de Lista de Valores
    public static String rn7(CampoCollection campoCollection){
        String resultado = "";
        if (campoCollection.getTrataListaValor() == 1) {
            if(!campoCollection.getListaValor().getLabelAtributo().equals(""))
            resultado = campoCollection.getListaValor().getLabelAtributo();
        }
        return resultado;
    }

    //RN.3 – Caracter de Sufixo
    public static String rn3(CampoCollection campoCollection){
        String resultado = "";
        if(campoCollection.getSufixo().equals(ESPACO_SUFIXO_PREFIXO)){
            resultado = " ";
        }else if(!campoCollection.getSufixo().equals(NADA_SUFIXO_PREFIXO)){
            resultado = campoCollection.getSufixo();
        }
        return resultado;
    }

    //RN.10 - Trunca Descrição
    public static String rn10(String etiqueta , String valor){
        String resultado = "";
        int dimensao = 0;
        if(valor.equals(ETIQUETA_120)){
            dimensao = 120;
        }else if(valor.equals(ETIQUETA_20)){
            dimensao = 20;
        }else if(valor.equals(ETIQUETA_35)){
            dimensao = 35;
        }
        if(etiqueta.length() > 0){
            if (etiqueta.toString().length() > dimensao){
                resultado = "<ResponseEtiqueta><etiqueta>" + etiqueta.substring(0, dimensao - 1) + "</etiqueta><etiquetaNoTrunc> " + etiqueta+ "</etiquetaNoTrunc><trunc>1</trunc></ResponseEtiqueta>";
            }else{
                resultado = "<ResponseEtiqueta><etiqueta>" + etiqueta + "</etiqueta><trunc>0</trunc></ResponseEtiqueta>";;
            }
        }

        return resultado;
    }

    //RN.09
    public static String rn9(String pdh){
        String resultado = "";
        try {
                String medidaPrincipal = App.retornoValorAtributoComGrupoAtributo("medidaPrincipalDoProduto", "DimensoesDoProduto" ,pdh);
                if(medidaPrincipal.equals("Quantidade de unidades do produto")){
                    resultado = App.retornoValorAtributoComGrupoAtributo("quantidadeDeUnidades", "DimensoesDoProduto" ,pdh);
                } else if(medidaPrincipal.equals("Peso Líquido do Produto")){
                    resultado = App.retornoValorAtributoComGrupoAtributo("pesoLiquidoDoProduto", "DimensoesDoProduto" ,pdh);
                } else if(medidaPrincipal.equals("Metragem do produto")){
                    resultado = App.retornoValorAtributoComGrupoAtributo("metragemDoProduto", "DimensoesDoProduto" ,pdh);
                } else if(medidaPrincipal.equals("Conteúdo Líquido do Produto")){
                    resultado = App.retornoValorAtributoComGrupoAtributo("conteudoLiquido", "DimensoesDoProduto" ,pdh);
                }

        }catch (Exception e){
                e.printStackTrace();
        }
        return resultado;
    }

    public static String truncaStrPara5(String str){
        String retorno = "";
        if(str.length() >= 5){
            for(int i = 2; i <= 5; i++ ){
                if (!String.valueOf(str.charAt(i)).equals("a") && !String.valueOf(str.charAt(i)).equals("e")
                        && !String.valueOf(str.charAt(i)).equals("i") && !String.valueOf(str.charAt(i)).equals("o") && !String.valueOf(str.charAt(i)).equals("u")){
                    retorno = str.substring(0,i+1);
                    break;
                }
                retorno = str.substring(0,i);
            }
        }else{
            retorno = str;
        }
        return retorno;
    }
}
