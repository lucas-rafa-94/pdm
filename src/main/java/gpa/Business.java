package gpa;

public class Business {
    //RN.4 - Mutabilidade && RN.6 – Abreviação && RN.5 – Dicionário
    public static String rn4_rn6_rn5 (CampoCollection campoCollection, String pdh , int valor){
        String resultado = "";
        if(campoCollection.getMutavel() == 1) {
            if (valor == 20) {
                if (!campoCollection.getDicionario().getAbr20().equals("")) {
                    resultado  = " " + campoCollection.getDicionario().getAbr20();
                } else {
                    try {
                        resultado = " " + App.retornoValorAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), pdh);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (valor == 35) {
                if (!campoCollection.getDicionario().getAbr35().equals("")) {
                    resultado  = " " + campoCollection.getDicionario().getAbr35();
                } else {
                    try {
                        resultado  = " " + App.retornoValorAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), pdh);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            try {
                resultado  = " " + App.retornoValorAtributo(campoCollection.getIdNomeCampoPdh().getNomeCampoApiPdh(), pdh);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
    //RN.2 – Caracter de Prefixo
    public static String rn2(CampoCollection campoCollection){
        String resultado = "";
        if(!campoCollection.getPrefixo().equals("")){
            resultado = campoCollection.getPrefixo();
        }
        return resultado;
    }
    //RN.7 – Regra de Lista de Valores
    public static String rn7(CampoCollection campoCollection){
        String resultado = "";
        if (campoCollection.getTrataListaValor() == 1) {
            resultado = " " + campoCollection.getListaValores().getLabelAtributo();
        }
        return resultado;
    }
    //RN.3 – Caracter de Sufixo
    public static String rn3(CampoCollection campoCollection){
        String resultado = "";
        if (!campoCollection.getSufixo().equals("")) {
            resultado = campoCollection.getPrefixo();
        }//
        return resultado;
    }
    //RN.10 - Trunca Descrição
    public static String rn10(String etiqueta , int valor){
        String resultado = "";
        if (etiqueta.toString().length() > valor){
            resultado = "<ResponseEtiqueta><etiqueta>" + etiqueta.substring(0, valor -1) + "</etiqueta><etiquetaNoTrunc> " + etiqueta+ "</etiquetaNoTrunc><trunc>1</trunc></ResponseEtiqueta>";
        }else{
            resultado = "<ResponseEtiqueta><etiqueta>" + etiqueta + "</etiqueta><trunc>0</trunc></ResponseEtiqueta>";;
        }
        return resultado;
    }
    //RN.09 - Trunca Descrição
    public static String rn9(CampoCollection campoCollection, String pdh){
        String resultado = "";
        if (campoCollection.getMedidaPrincipal() == 1 ){
            try {
                String medidaPrincipal = App.retornoValorAtributo("medidaPrincipalDoProduto", pdh);
                if(medidaPrincipal.equals("Quantidade de unidades do produto")){
                    resultado = App.retornoValorAtributo("quantidadeDeUnidades", pdh);
                } else if(medidaPrincipal.equals("Peso Líquido do Produto")){
                    resultado = App.retornoValorAtributo("pesoLiquidoDoProduto", pdh);
                } else if(medidaPrincipal.equals("Metragem do produto")){
                    resultado = App.retornoValorAtributo("metragemDoProduto", pdh);
                } else if(medidaPrincipal.equals("Conteúdo Líquido do Produto")){
                    resultado = App.retornoValorAtributo("conteudoLiquido", pdh);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultado;
    }


}
