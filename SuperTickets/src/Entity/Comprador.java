package Entity;

public class Comprador extends Usuario{
    int usuario_id_comprador;
    String cpf;

    //construtores
    public Comprador(){

    }

    public Comprador(int id, String cpf){
        this.usuario_id_comprador = id;
        this.cpf = cpf;
    }

    //setters
    public void setId(int id){
        this.usuario_id_comprador = id;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    //getters
    public int getId(){
        return this.usuario_id_comprador;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void printComprador(){
        this.printUsuario();
        System.out.println("Cpf: " + this.cpf + "\n id: " + this.usuario_id_comprador);
    }




}
