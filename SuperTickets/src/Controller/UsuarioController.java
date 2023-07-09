package Controller;

import Entity.Comprador;
import Entity.Organizador;
import Entity.Usuario;
import Service.UsuarioService;

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
}
