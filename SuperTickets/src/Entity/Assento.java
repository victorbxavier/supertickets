package Entity;

public class Assento {
    private int idAssento;
    private String descricao;
    private String localEnd;

    public Assento(){
        
    }
    
    public Assento(int idAssento, String descricao, String localEnd) {
        this.idAssento = idAssento;
        this.descricao = descricao;
        this.localEnd = localEnd;
    }

    public int getIdAssento() {
        return idAssento;
    }
    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getLocalEnd() {
        return localEnd;
    }
    public void setLocalEnd(String localEnd) {
        this.localEnd = localEnd;
    }

    
}
