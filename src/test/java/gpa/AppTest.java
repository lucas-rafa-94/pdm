package gpa;

import com.google.gson.Gson;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main( String[] args ) throws Exception{

//        FileReader fileReader = new FileReader("/Users/lucasdossantos/Desktop/xml2.xml");
//        BufferedReader br = new BufferedReader(fileReader);
//
//
//        String linha = br.readLine();
//
//        String resultado = "";
//
//        while (linha != null) {
//            resultado += linha;
//            linha = br.readLine();
//        }
//
//        System.out.println(resultado);
//
//        System.out.println(resultado.substring(resultado.indexOf(":sub>"), resultado.indexOf("</", resultado.indexOf(":sub>")+1)).replace(":sub>",""));

        System.out.println(App.retornaEtiqueta(phdmodule(),pdmmodule(),"Descrição do Produto 35"));
       // System.out.println(truncaStrPara5("atuibuto"));
        //JSONObject xmlJSONObj = XML.toJSONObject(phdmodule().replace("xmlns=\"\"","").replace("xsi:nil=\"true\"", "")).getJSONObject("env:Envelope").getJSONObject("env:Body").getJSONObject("ns0:findItemResponse").getJSONObject("ns2:result").getJSONObject("ns0:Value").getJSONObject("ns1:ItemEffCategory");
        //System.out.println(xmlJSONObj.getJSONObject("ns6:GrupoPadariaIndustrializada"));

        //System.out.println(App.retornoValorAtributoComGrupoAtributo("nomePrincipalDoItem", "Cgpi", phdmodule()));

    }


    public static String pdmmodule () throws Exception{

        FileReader fileReader = new FileReader("/Users/lucasdossantos/Desktop/xml.xml");
        BufferedReader br = new BufferedReader(fileReader);

        String linha = br.readLine();

        String resultado = "";

        while (linha != null) {
            resultado += linha;
            linha = br.readLine();
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
        }
        return retorno;
    }
    public static String phdmodule () throws Exception{

        FileReader fileReader = new FileReader("/Users/lucasdossantos/Desktop/xml3.xml");
        BufferedReader br = new BufferedReader(fileReader);

        String linha = br.readLine();

        String resultado = "";

        while (linha != null) {
            resultado += linha;
            linha = br.readLine();
        }

        return resultado;
    }


}
