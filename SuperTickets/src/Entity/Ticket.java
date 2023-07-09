package Entity;

public class Ticket {
    private int codigo;
    private String tipo;
    private int idEvento;

    public Ticket(){

    }

    public Ticket(int codigo, String tipo, int idEvento){
        this.codigo = codigo;
        this.tipo = tipo;
        this.idEvento = idEvento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    
}
