package Controller;

import Entity.Comprador;
import Entity.Organizador;
import Entity.Usuario;
import Service.UsuarioService;

import java.util.ArrayList;

public class UsuarioController {

    UsuarioService service = new UsuarioService();
    public boolean cadastrarUsuario(Usuario usuario){
        return service.cadastrarUsuario(usuario);
    }

    public boolean cadastrarComprador(Comprador comprador){
        return service.cadastrarComprador(comprador);
    }

    public boolean cadastrarOrganizador(Organizador organizador){
        return service.cadastrarOrganizador(organizador);
    }

    public Usuario getUsuarioById(int id){
        return service.getUsuarioById(id);
    }

    public Usuario getUsuarioByEmail(String email){
        return service.getUsuarioByEmail(email);
    }

    public Comprador getCompradorById(int id){
        return service.getCompradorById(id);
    }

    public Comprador getCompradorByCpf(String cpf){
        return service.getCompradorByCpf(cpf);
    }

    public Organizador getOrganizadorById(int id){
        return service.getOrganizadorById(id);
    }

    public Organizador getOrganizadorByCnpj(String cnpj){
        return service.getOrganizadorByCnpj(cnpj);
    }

    public boolean login(Usuario usuario){
        return service.login(usuario);
    }

    public ArrayList<Integer> getAllCompradoresIds(){
        ArrayList<Comprador> compradores = new ArrayList<Comprador>();
        compradores = service.getAllCompradores();
        ArrayList<Integer> ids = new ArrayList<Integer>();

        for(Comprador comprador: compradores){
            ids.add(comprador.getId());
        }

        return ids;
    }

    public ArrayList<Integer> getAllOrganizadoresIds(){
        ArrayList<Organizador> organizadores = new ArrayList<Organizador>();
        organizadores = service.getAllOrganizadores();
        ArrayList<Integer> ids = new ArrayList<Integer>();

        for(Organizador organizador : organizadores){
            ids.add(organizador.getId());
        }

        return ids;
    }

    public boolean isComprador(int id){
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids = this.getAllCompradoresIds();
        return ids.contains(id);
    }

    public boolean isOrganizador(int id){
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids = this.getAllOrganizadoresIds();
        return ids.contains(id);
    }
}
