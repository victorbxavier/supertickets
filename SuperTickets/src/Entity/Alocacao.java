package Entity;

public class Alocacao {
    private int usuario_id_comprador;
    private int id_assento;
    private int id_evento;
    private int ticket_codigo;

    public Alocacao(int usuario_id_comprador, int id_evento, int ticket_codigo) {
        this.usuario_id_comprador = usuario_id_comprador;
        this.id_evento = id_evento;
        this.ticket_codigo = ticket_codigo;
    }

    public Alocacao(){
        
    }

    public int getUsuario_id_comprador() {
        return usuario_id_comprador;
    }

    public void setUsuario_id_comprador(int usuario_id_comprador) {
        this.usuario_id_comprador = usuario_id_comprador;
    }

    public int getId_assento() {
        return id_assento;
    }

    public void setId_assento(int id_assento) {
        this.id_assento = id_assento;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getTicket_codigo() {
        return ticket_codigo;
    }

    public void setTicket_codigo(int ticket_codigo) {
        this.ticket_codigo = ticket_codigo;
    }

}
