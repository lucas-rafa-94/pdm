package gpa;

public class IdGrupoAtributo {
    private int idGrupoAtributo;
    private String nomeGrupoDeAtributo, nomeGrupoDeAtributoApiPdh, subcategoria;

    public IdGrupoAtributo(int idGrupoAtributo, String nomeGrupoDeAtributo, String nomeGrupoDeAtributoApiPdh, String subcategoria) {
        this.idGrupoAtributo = idGrupoAtributo;
        this.nomeGrupoDeAtributo = nomeGrupoDeAtributo;
        this.nomeGrupoDeAtributoApiPdh = nomeGrupoDeAtributoApiPdh;
        this.subcategoria = subcategoria;
    }

    public IdGrupoAtributo() {
    }

    public int getIdGrupoAtributo() {
        return idGrupoAtributo;
    }

    public void setIdGrupoAtributo(int idGrupoAtributo) {
        this.idGrupoAtributo = idGrupoAtributo;
    }

    public String getNomeGrupoDeAtributo() {
        return nomeGrupoDeAtributo;
    }

    public void setNomeGrupoDeAtributo(String nomeGrupoDeAtributo) {
        this.nomeGrupoDeAtributo = nomeGrupoDeAtributo;
    }

    public String getNomeGrupoDeAtributoApiPdh() {
        return nomeGrupoDeAtributoApiPdh;
    }

    public void setNomeGrupoDeAtributoApiPdh(String nomeGrupoDeAtributoApiPdh) {
        this.nomeGrupoDeAtributoApiPdh = nomeGrupoDeAtributoApiPdh;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
}
