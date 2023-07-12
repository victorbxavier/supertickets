package DAO;

import Entity.Local;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalDAO {
    Connection con;
    DBDados dados = new DBDados();

    public LocalDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, Local local) throws SQLException{
        pst.setString(1, local.getEndereco());
        pst.setString(2, local.getDescricao());
        return pst;
    }

    public Local buildLocal(ResultSet rs) throws SQLException{
        Local local = new Local();
        local.setDescricao(rs.getString("descricao"));
        local.setEndereco(rs.getString("endereco"));

        return local;

    }

    public ArrayList<Local> getAllLocais() throws SQLException {
        String query = "SELECT * FROM local";
        ArrayList<Local> locais = new ArrayList<Local>();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            Local local = buildLocal(rs);
            locais.add(local);
        }

        return locais;
    }

    public boolean save(Local local) throws SQLException{
        String query = "INSERT INTO local (endereco, descricao) VALUES (?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, local);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
