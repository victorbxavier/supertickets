package Entity;

public class Comprador extends Usuario{
    int usuario_id_comprador;
    int cpf;

    //construtores
    public Comprador(){

    }

    public Comprador(int id, int cpf){
        this.usuario_id_comprador = id;
        this.cpf = cpf;
    }

    //setters
    public void setId(int id){
        this.usuario_id_comprador = id;
    }

    public void setCpf(int cpf){
        this.cpf = cpf;
    }

    //getters
    public int getId(){
        return this.usuario_id_comprador;
    }

    public int getCpf(){
        return this.cpf;
    }




}
