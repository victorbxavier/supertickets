package Controller;

import Entity.Comprador;
import Entity.Organizador;
import Entity.Usuario;

public class UsuarioController {
    public boolean cadastrarUsuario(Usuario usuario){
        //cadastrar usuario
        return false;
    }

    public boolean cadastrarComprador(Comprador comprador){
        //cadastrar comprador
        return false;
    }

    public boolean cadastrarOrganizador(Organizador organizador){
        //cadastrar organizador
        return false;
    }

    public Usuario getUsuarioById(int id){
        Usuario usuario = new Usuario();
        return usuario;
    }

    public Usuario getUsuarioByEmail(String Email){
        Usuario usuario = new Usuario();
        return usuario;
    }

    public Comprador getCompradorById(int id){
        Comprador comprador = new Comprador();
        return comprador;
    }

    public Comprador getCompradorByEmail(String email){
        Comprador comprador = new Comprador();
        return comprador;
    }

    public Organizador getOrganizadorById(int id){
        Organizador organizador = new Organizador();
        return organizador;
    }

    public Organizador getOrganizadorByEmail(String email){
        Organizador organizador = new Organizador();
        return organizador;
    }
}
