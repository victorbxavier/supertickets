package DAO;

import Entity.Usuario;

import java.sql.SQLException;

public class UsuarioDAO {
        public boolean save(Usuario usuario) throws SQLException {
        return false;
    }
    public boolean update(Usuario usuario) throws SQLException{
        return false;
    }
    public Usuario getById(int id) throws SQLException{
        Usuario usuario = new Usuario();
        return usuario;
    }
    public Usuario getByEmail(String email) throws SQLException{
        Usuario usuario = new Usuario();
        return usuario;
    }

    public boolean delete(Usuario usuario) throws SQLException{
        return false;
    }

}
