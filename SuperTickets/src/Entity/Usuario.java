package Entity;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int id_usuario;

    //construtores
    public Usuario(){

    }

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    //setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setId(int id){
        this.id_usuario = id;
    }

    //getters
    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSenha(){
        return this.senha;
    }

    public int getId(){
        return this.id_usuario;
    }

    public void printUsuario(){
        System.out.println("Nome: " + this.getNome() + "\nEmail: " + this.getEmail());
    }
}
