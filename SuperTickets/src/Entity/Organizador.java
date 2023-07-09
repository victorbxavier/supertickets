package Entity;

public class Organizador extends Usuario{
    int usuario_id_organizador;
    int cnpj;

    //construtores
    public Organizador(){

    }

    public Organizador(int id, int cnpj){
        this.usuario_id_organizador = id;
        this.cnpj = cnpj;
    }

    //setters
    public void setId(int id){
        this.usuario_id_organizador = id;
    }

    public void setCnpj(int cnpj){
        this.cnpj = cnpj;
    }

    //getters
    public int getId(){
        return this.usuario_id_organizador;
    }

    public int getCnpj(){
        return this.cnpj;
    }

    public void printComprador(){
        this.printUsuario();
        System.out.println("Cnpj: " + this.cnpj + "\n id: " + this.usuario_id_organizador);
    }

}
