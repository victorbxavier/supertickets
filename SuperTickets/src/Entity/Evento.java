package Entity;

import java.util.Date;

public class Evento {
    
    private int idEvento;
    private String nome;
    private Date dataEvento;
    private Date dataInscricao;
    private int capacidadeMaxima;
    private int idOrganizador;
    private String localEnd;

    public Evento(){
        
    }

    public Evento(int idEvento, String nome, Date dataEvento, Date dataInscricao, int capacidadeMaxima,
            int idOrganizador, String localEnd) {
        this.idEvento = idEvento;
        this.nome = nome;
        this.dataEvento = dataEvento;
        this.dataInscricao = dataInscricao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.idOrganizador = idOrganizador;
        this.localEnd = localEnd;
    }

    public Evento(String nome, Date dataEvento, Date dataInscricao, int capacidade, int idOrganizador){
        this.nome = nome;
        this.dataEvento = dataEvento;
        this.dataInscricao = dataInscricao;
        this.capacidadeMaxima = capacidade;
        this.idOrganizador = idOrganizador;
    }

    public int getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataEvento() {
        return dataEvento;
    }
    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
    public Date getDataInscricao() {
        return dataInscricao;
    }
    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
    public int getIdOrganizador() {
        return idOrganizador;
    }
    public void setIdOrganizador(int idOrganizador) {
        this.idOrganizador = idOrganizador;
    }
    public String getLocalEnd() {
        return localEnd;
    }
    public void setLocalEnd(String localEnd) {
        this.localEnd = localEnd;
    }

    public void printEvento(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("Data do Evento: " + this.dataEvento);
        System.out.println("Data de Inscrição: " + this.dataInscricao);
        System.out.println("Capacidade máxima: " + this.capacidadeMaxima);
        System.out.println("Endereço: " + this.localEnd);
    }


}
