package gpa;

public class IdNomeCampoPdh {

    private int idNomeapipdh;
    private String grupoDeAtributo, nomeCampoPdh, nomeCampoApiPdh;

    public IdNomeCampoPdh(int idNomeapipdh, String grupoDeAtributo, String nomeCampoPdh, String nomeCampoApiPdh) {
        this.idNomeapipdh = idNomeapipdh;
        this.grupoDeAtributo = grupoDeAtributo;
        this.nomeCampoPdh = nomeCampoPdh;
        this.nomeCampoApiPdh = nomeCampoApiPdh;
    }

    public IdNomeCampoPdh() {
    }

    public int getIdNomeapipdh() {
        return idNomeapipdh;
    }

    public void setIdNomeapipdh(int idNomeapipdh) {
        this.idNomeapipdh = idNomeapipdh;
    }

    public String getGrupoDeAtributo() {
        return grupoDeAtributo;
    }

    public void setGrupoDeAtributo(String grupoDeAtributo) {
        this.grupoDeAtributo = grupoDeAtributo;
    }

    public String getNomeCampoPdh() {
        return nomeCampoPdh;
    }

    public void setNomeCampoPdh(String nomeCampoPdh) {
        this.nomeCampoPdh = nomeCampoPdh;
    }

    public String getNomeCampoApiPdh() {
        return nomeCampoApiPdh;
    }

    public void setNomeCampoApiPdh(String nomeCampoApiPdh) {
        this.nomeCampoApiPdh = nomeCampoApiPdh;
    }
}
