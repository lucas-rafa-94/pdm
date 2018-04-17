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

        System.out.println(App.retornaEtiqueta(phdmodule(),pdmmodule(),35));


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

    public static String retornaEtiqueta( String pdh, String pdm, int valor){
        StringBuilder etiqueta = new StringBuilder();
        JSONObject xmlJSONObj = XML.toJSONObject(pdm);
        ModuloPdm [] moduloPdm =  new Gson().fromJson(xmlJSONObj.getJSONObject("ModuloPdmCollection").getJSONArray("ModuloPdm").toString().replace("{\"xsi:nil\":true}", "\"\""), ModuloPdm[].class);

        for (int i = 0; i < moduloPdm.length  ; i++){

            if(moduloPdm[i].getMutavel() == 1){
                etiqueta.append(moduloPdm[i].getDicionario().getAbr20());
            }else {
                try {
                    etiqueta.append(" " + App.retornoValorAtributo(moduloPdm[i].getAtributoPdh(), pdh));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return etiqueta.toString();
    }
}
