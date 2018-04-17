package gpa;

public class ListaValores {

    private String nomeAtributo;
    private String valorAtributo;
    private String labelAtributo;
    private int ignorado;

    public ListaValores(String nomeAtributo, String valorAtributo, String labelAtributo, int ignorado) {
        this.nomeAtributo = nomeAtributo;
        this.valorAtributo = valorAtributo;
        this.labelAtributo = labelAtributo;
        this.ignorado = ignorado;
    }

    public ListaValores() {
    }

    public String getNomeAtributo() {
        return nomeAtributo;
    }

    public void setNomeAtributo(String nomeAtributo) {
        this.nomeAtributo = nomeAtributo;
    }

    public String getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(String valorAtributo) {
        this.valorAtributo = valorAtributo;
    }

    public String getLabelAtributo() {
        return labelAtributo;
    }

    public void setLabelAtributo(String labelAtributo) {
        this.labelAtributo = labelAtributo;
    }

    public int getIgnorado() {
        return ignorado;
    }

    public void setIgnorado(int ignorado) {
        this.ignorado = ignorado;
    }
}
