package Service;

import DAO.CompradorDAO;
import DAO.OrganizadorDAO;
import DAO.UsuarioDAO;
import Entity.Comprador;
import Entity.Organizador;
import Entity.Usuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;

public class UsuarioService {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    CompradorDAO compradorDAO = new CompradorDAO();
    OrganizadorDAO organizadorDAO = new OrganizadorDAO();

    public boolean cadastrarUsuario(Usuario usuario){
        //criptografia
        String senha = usuario.getSenha();
        String salt = this.generateSalt();
        String senhaCriptografada = encryptPassword(senha, salt);
        usuario.setSenha(senhaCriptografada);

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

    public Comprador getCompradorByCpf(String cpf){
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

    public Organizador getOrganizadorByCnpj(String cnpj){
        Organizador organizador = new Organizador();

        try{
            organizador = organizadorDAO.getByCnpj(cnpj);
        }catch(SQLException e){
            System.out.println(e);
        }

        return organizador;
    }

    public String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return bytesToHex(saltBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String encryptPassword(String password, String salt) {
        String saltedPassword = salt + password;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());
            return bytesToHex(hashedBytes);
        }catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
        return "";

    }

}
