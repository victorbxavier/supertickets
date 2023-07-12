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
        compradores = this.getAllCompradores();
        ArrayList<Integer> ids = new ArrayList<Integer>();

        for(Comprador comprador: compradores){
            ids.add(comprador.getId());
        }

        return ids;
    }

    public ArrayList<Integer> getAllOrganizadoresIds(){
        ArrayList<Organizador> organizadores = new ArrayList<Organizador>();
        organizadores = this.getAllOrganizadores();
        ArrayList<Integer> ids = new ArrayList<Integer>();

        for(Organizador organizador : organizadores){
            ids.add(organizador.getId());
        }

        return ids;
    }

    public ArrayList<Organizador> getAllOrganizadores(){
        return service.getAllOrganizadores();
    }

    public ArrayList<Comprador> getAllCompradores(){
        return service.getAllCompradores();
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

    public ArrayList<Usuario> compradoresToUsuarios(ArrayList<Comprador> compradores){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        for(Comprador comprador : compradores){
            usuarios.add(this.compradorToUsuario(comprador));
        }

        return usuarios;
    }

    public ArrayList<Usuario> organizadoresToUsuarios(ArrayList<Organizador> organizadores){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        for(Organizador organizador : organizadores){
            usuarios.add(this.organizadorToUsuario(organizador));
        }

        return usuarios;
    }

    public Usuario compradorToUsuario(Comprador comprador){
        return service.getUsuarioById(comprador.getId());
    }

    public Usuario organizadorToUsuario(Organizador organizador){
        return service.getUsuarioById(organizador.getId());
    }

    public ArrayList<Usuario> getUsuariosByNome(String nome){
        return service.getUsuariosByNome(nome);
    }

    public ArrayList<Usuario> getOrganizadoresByNome(String nome){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Usuario> organizadores = new ArrayList<Usuario>();

        organizadores = this.getUsuariosByNome(nome);
        for(Usuario usuario : usuarios){
            if(isOrganizador(usuario.getId())){
                organizadores.add(usuario);
            }
        }

        return organizadores;
    }

}
