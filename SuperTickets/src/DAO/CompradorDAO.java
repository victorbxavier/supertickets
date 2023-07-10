package DAO;


import Entity.Comprador;
import Entity.Usuario;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompradorDAO {

    Connection con;
    DBDados dados = new DBDados();

    public CompradorDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, Comprador comprador) throws SQLException{
        pst.setInt(1, comprador.getId());
        pst.setString(2, comprador.getCpf());
        return pst;
    }

    public Comprador buildUsuario(ResultSet rs) throws SQLException{
        Comprador comprador = new Comprador();
        comprador.setId(rs.getInt("usuario_id_comprador"));
        comprador.setCpf(rs.getString("cpf"));

        return comprador;
    }

    public boolean save(Comprador comprador) throws SQLException {
        String query = "INSERT INTO comprador (usuario_id_comprador, cpf) VALUES (?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, comprador);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    public boolean update(Comprador comprador) throws SQLException{
        return false;
    }
    public Comprador getById(int id) throws SQLException{
        String query = "SELECT * FROM comprador";
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Comprador comprador = buildUsuario(rs);
            System.out.println("comprador criado: ");
            comprador.printComprador();
            if (comprador.getId() == id) {
                return comprador;
            }

        }
        return null;
    }
    public Comprador getByCpf(String cpf) throws SQLException{
        String query = "SELECT * FROM comprador";
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Comprador comprador = buildUsuario(rs);
            if (comprador.getCpf().equals(cpf)) {
                return comprador;
            }

        }
        return null;
    }

    public ArrayList<Comprador> getAllCompradores() throws SQLException{
        String query = "SELECT * FROM comprador";
        ArrayList<Comprador> compradores = new ArrayList<Comprador>();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Comprador comprador = buildUsuario(rs);
            compradores.add(comprador);
        }

        return compradores;
    }

    public boolean delete(Comprador comprador) throws SQLException{
        String string = "DELETE FROM comprador WHERE id_usuario = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(string);
            pst.setInt(1, comprador.getId());
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
