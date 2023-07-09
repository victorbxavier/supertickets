package DAO;


import Entity.Comprador;
import Entity.Organizador;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizadorDAO {
    Connection con;
    DBDados dados = new DBDados();
    public OrganizadorDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, Organizador organizador) throws SQLException{
        pst.setInt(1, organizador.getId());
        pst.setInt(2, organizador.getCnpj());
        return pst;
    }

    public Organizador buildUsuario(ResultSet rs) throws SQLException{
        Organizador organizador = new Organizador();
        organizador.setId(rs.getInt("usuario_id_organizador"));
        organizador.setId(rs.getInt("cnpj"));

        return organizador;
    }
    public boolean save(Organizador organizador) throws SQLException {
        String query = "INSERT INTO organizador (usuario_id_organizador, cnpj) VALUES (?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, organizador);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
    public boolean update(Organizador organizador) throws SQLException{
        return false;
    }
    public Organizador getById(int id) throws SQLException{
        String query = "SELECT * FROM organizador";
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Organizador organizador = buildUsuario(rs);
            if (organizador.getId() == id) {
                return organizador;
            }

        }
        return null;
    }
    public Organizador getByCnpj(int cnpj) throws SQLException{
        String query = "SELECT * FROM organizador";
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Organizador organizador = buildUsuario(rs);
            if (organizador.getCnpj() == cnpj) {
                return organizador;
            }

        }
        return null;
    }

    public boolean delete(Organizador organizador) throws SQLException{
        String string = "DELETE FROM organizador WHERE id_usuario = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(string);
            pst.setInt(1, organizador.getId());
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
}
