package gpa;

public class IdTpDescricao {
    private String tpDescricao;
    private int idTpDescricao;

    public IdTpDescricao(String tpDescricao, int idTpDescricao) {
        this.tpDescricao = tpDescricao;
        this.idTpDescricao = idTpDescricao;
    }

    public IdTpDescricao() { }

    public String getTpDescricao() {
        return tpDescricao;
    }

    public void setTpDescricao(String tpDescricao) {
        this.tpDescricao = tpDescricao;
    }

    public int getIdTpDescricao() {
        return idTpDescricao;
    }

    public void setIdTpDescricao(int idTpDescricao) {
        this.idTpDescricao = idTpDescricao;
    }
}
