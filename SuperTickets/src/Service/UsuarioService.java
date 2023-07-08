package Service;

import DAO.CompradorDAO;
import DAO.OrganizadorDAO;
import DAO.UsuarioDAO;
import Entity.Comprador;
import Entity.Organizador;
import Entity.Usuario;

import java.sql.SQLException;

public class UsuarioService {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    CompradorDAO compradorDAO = new CompradorDAO();
    OrganizadorDAO organizadorDAO = new OrganizadorDAO();

    public boolean cadastrarUsuario(Usuario usuario){
        try{
            usuarioDAO.save(usuario);
        }catch(SQLException e){
            System.out.println(e);
        }

        return true;
    }

    public boolean cadastrarComprador(Comprador comprador){
        try{
            compradorDAO.save(comprador);
        }catch(SQLException e){
            System.out.println(e);
        }

        return true;
    }

    public boolean cadastrarOrganizador(Organizador organizador){
        try{
            organizadorDAO.save(organizador);
        }catch(SQLException e){
            System.out.println(e);
        }

        return true;
    }

    public Usuario getUsuarioById(int id){
        Usuario usuario = new Usuario();

        try{
            usuario = usuarioDAO.getById(id);
        }catch(SQLException e){
            System.out.println(e);
        }

        return usuario;
    }

    public Usuario getUsuarioByEmail(String email){
        Usuario usuario = new Usuario();

        try{
            usuario = usuarioDAO.getByEmail(email);
        }catch(SQLException e){
            System.out.println(e);
        }

        return usuario;
    }

    public Comprador getCompradorById(int id){
        Comprador comprador = new Comprador();

        try{
            comprador = compradorDAO.getById(id);
        }catch(SQLException e){
            System.out.println(e);
        }

        return comprador;
    }

    public Comprador getCompradorByCpf(int cpf){
        Comprador comprador = new Comprador();

        try{
            comprador = compradorDAO.getByCpf(cpf);
        }catch(SQLException e){
            System.out.println(e);
        }

        return comprador;
    }

    public Organizador getOrganizadorById(int id){
        Organizador organizador = new Organizador();

        try{
            organizadorDAO.getById(id);
        }catch(SQLException e){
            System.out.println(e);
        }

        return organizador;
    }

    public Organizador getOrganizadorByCnpj(int cnpj){
        Organizador organizador = new Organizador();

        try{
            organizador = organizadorDAO.getByCnpj(cnpj);
        }catch(SQLException e){
            System.out.println(e);
        }

        return organizador;
    }

}
