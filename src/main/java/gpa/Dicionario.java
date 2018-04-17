package gpa;

public class Dicionario {

    private String palavra;
    private String abr35;
    private String abr20;

    public Dicionario(String palavra, String abr35, String abr20) {
        this.palavra = palavra;
        this.abr35 = abr35;
        this.abr20 = abr20;
    }

    public Dicionario() { }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getAbr35() {
        return abr35;
    }

    public void setAbr35(String abr35) {
        this.abr35 = abr35;
    }

    public String getAbr20() {
        return abr20;
    }

    public void setAbr20(String abr20) {
        this.abr20 = abr20;
    }
}
