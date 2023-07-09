package Entity;

public class Local {
    private String endereco;
    private String descricao;

    public Local(){}
    
    public Local(String endereco, String descricao) {
        this.endereco = endereco;
        this.descricao = descricao;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
