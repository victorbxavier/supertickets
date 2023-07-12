package Entity;

public class TipoTicket {
    private float valor;
    private float desconto;
    private String tipo;
    private int Evento_id_evento;

    public TipoTicket(float valor, float desconto, String tipo, int evento_id_evento) {
        this.valor = valor;
        this.desconto = desconto;
        this.tipo = tipo;
        Evento_id_evento = evento_id_evento;
    }

    public TipoTicket(){

    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEvento_id_evento() {
        return Evento_id_evento;
    }

    public void setEvento_id_evento(int evento_id_evento) {
        Evento_id_evento = evento_id_evento;
    }
    
}
