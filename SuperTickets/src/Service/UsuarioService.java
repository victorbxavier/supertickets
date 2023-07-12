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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UsuarioService {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    CompradorDAO compradorDAO = new CompradorDAO();
    OrganizadorDAO organizadorDAO = new OrganizadorDAO();

    private static final String SALT = "super_tickets_salt";

    public boolean cadastrarUsuario(Usuario usuario){
        this.criptografar(usuario);

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

    public ArrayList<Comprador> getAllCompradores(){
        ArrayList<Comprador> compradores = new ArrayList<Comprador>();

        try{
            compradores = compradorDAO.getAllCompradores();
        }catch(SQLException e){
            System.out.println(e);
        }

        return compradores;
    }

    public ArrayList<Organizador> getAllOrganizadores(){
        ArrayList<Organizador> organizadores = new ArrayList<Organizador>();

        try{
            organizadores = organizadorDAO.getAllOrganizadores();
        }catch(SQLException e){
            System.out.println(e);
        }

        return organizadores;
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

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String encryptPassword(String password) {
        String saltedPassword = SALT + password;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());
            return bytesToHex(hashedBytes);
        }catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
        return "";

    }

    public boolean verificarSenha(Usuario usuario){
        Usuario usuarioSalvo = this.getUsuarioByEmail(usuario.getEmail());
        return usuarioSalvo.getSenha().equals(usuario.getSenha());
    }

    public Usuario criptografar(Usuario usuario){
        String senha = usuario.getSenha();
        String senhaCriptografada = encryptPassword(senha);
        usuario.setSenha(senhaCriptografada);
        return usuario;
    }



    public boolean verificarEmail(String email){
        Usuario usuario = new Usuario();
        try{
            usuario = usuarioDAO.getByEmail(email);
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }

        if(usuario != null){
            return true;
        }
        else{
            System.out.println("Email não cadastrado!");
            return false;
        }



    }

    public boolean login(Usuario usuario){
        if(!verificarEmail(usuario.getEmail())) return false;

        this.criptografar(usuario);
        boolean senhaVerificada = this.verificarSenha(usuario);
        if(senhaVerificada) return true;

        System.out.println("Senha incorreta!");
        return false;

    }

}
