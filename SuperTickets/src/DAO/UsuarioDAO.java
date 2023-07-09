package DAO;

import Entity.Usuario;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Connection con;
    DBDados dados = new DBDados();

    public UsuarioDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, Usuario usuario) throws SQLException{
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getEmail());
        pst.setString(3, usuario.getSenha());
        return pst;
    }

    public Usuario buildUsuario(ResultSet rs) throws SQLException{
        Usuario usuario = new Usuario();
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setId(rs.getInt("id_usuario"));
        return usuario;
    }

    public boolean save(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, usuario);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
    public boolean update(Usuario usuario) throws SQLException{
        return false;
    }
    public Usuario getById(int id) throws SQLException{
        String query = "SELECT * FROM usuario";
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario usuario = buildUsuario(rs);
            if (usuario.getId() == id) {
                return usuario;
            }

        }
        return null;
    }
    public Usuario getByEmail(String email) throws SQLException{
        String query = "SELECT * FROM usuario";

        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario usuario = buildUsuario(rs);
            if (usuario.getEmail() == email) {
                return usuario;
            }

        }
        return null;

    }

    public boolean delete(Usuario usuario) throws SQLException{
        String string = "DELETE FROM usuario WHERE id_usuario = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(string);
            pst.setInt(1, usuario.getId());
            int res = pst.executeUpdate();
            if(res == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

}
