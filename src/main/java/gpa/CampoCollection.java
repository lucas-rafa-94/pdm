package gpa;

public class CampoCollection {

    private int idCampo;
    private String categoria;
    private String subcategoria;
    private String grupo;
    private String subgrupo;
    private String tpDescricao;
    private int ordemCampo;
    private String prefixo;
    private String sufixo;
    private int mutavel;
    private Dicionario dicionario;
    private ListaValores ListaValor;
    private IdGrupoAtributo idGrupoAtributo;
    private String etiqueta;
    private IdTpDescricao idTpDescricao;
    private int trataListaValor;
    private int medidaPrincipal;
    private IdNomeCampoPdh idNomeCampoPdh;

    public CampoCollection(int idCampo, String categoria, String subcategoria, String grupo, String subgrupo, String tpDescricao, int ordemCampo, String prefixo, String sufixo, int mutavel, Dicionario dicionario, ListaValores listaValor, IdGrupoAtributo idGrupoAtributo, String etiqueta, IdTpDescricao idTpDescricao, int trataListaValor, int medidaPrincipal, IdNomeCampoPdh idNomeCampoPdh) {
        this.idCampo = idCampo;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.tpDescricao = tpDescricao;
        this.ordemCampo = ordemCampo;
        this.prefixo = prefixo;
        this.sufixo = sufixo;
        this.mutavel = mutavel;
        this.dicionario = dicionario;
        ListaValor = listaValor;
        this.idGrupoAtributo = idGrupoAtributo;
        this.etiqueta = etiqueta;
        this.idTpDescricao = idTpDescricao;
        this.trataListaValor = trataListaValor;
        this.medidaPrincipal = medidaPrincipal;
        this.idNomeCampoPdh = idNomeCampoPdh;
    }

    public CampoCollection() { }

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getTpDescricao() {
        return tpDescricao;
    }

    public void setTpDescricao(String tpDescricao) {
        this.tpDescricao = tpDescricao;
    }

    public int getOrdemCampo() {
        return ordemCampo;
    }

    public void setOrdemCampo(int ordemCampo) {
        this.ordemCampo = ordemCampo;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getSufixo() {
        return sufixo;
    }

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    public int getMutavel() {
        return mutavel;
    }

    public void setMutavel(int mutavel) {
        this.mutavel = mutavel;
    }

    public Dicionario getDicionario() {
        return dicionario;
    }

    public void setDicionario(Dicionario dicionario) {
        this.dicionario = dicionario;
    }

    public ListaValores getListaValor() {
        return ListaValor;
    }

    public void setListaValor(ListaValores listaValor) {
        ListaValor = listaValor;
    }

    public IdGrupoAtributo getIdGrupoAtributo() {
        return idGrupoAtributo;
    }

    public void setIdGrupoAtributo(IdGrupoAtributo idGrupoAtributo) {
        this.idGrupoAtributo = idGrupoAtributo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public IdTpDescricao getIdTpDescricao() {
        return idTpDescricao;
    }

    public void setIdTpDescricao(IdTpDescricao idTpDescricao) {
        this.idTpDescricao = idTpDescricao;
    }

    public int getTrataListaValor() {
        return trataListaValor;
    }

    public void setTrataListaValor(int trataListaValor) {
        this.trataListaValor = trataListaValor;
    }

    public int getMedidaPrincipal() {
        return medidaPrincipal;
    }

    public void setMedidaPrincipal(int medidaPrincipal) {
        this.medidaPrincipal = medidaPrincipal;
    }

    public IdNomeCampoPdh getIdNomeCampoPdh() {
        return idNomeCampoPdh;
    }

    public void setIdNomeCampoPdh(IdNomeCampoPdh idNomeCampoPdh) {
        this.idNomeCampoPdh = idNomeCampoPdh;
    }
}
