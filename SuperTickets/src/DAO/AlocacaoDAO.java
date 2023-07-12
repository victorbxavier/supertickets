package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Alocacao;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

public class AlocacaoDAO {
    Connection con;
    DBDados dados = new DBDados();

    public AlocacaoDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, Alocacao alocacao) throws SQLException{
        pst.setInt(1, alocacao.getUsuario_id_comprador());
        pst.setInt(2, alocacao.getId_evento());
        pst.setInt(3, alocacao.getTicket_codigo());

        return pst;
    }

    public Alocacao buildTicket(ResultSet rs) throws SQLException{
        Alocacao alocacao = new Alocacao();
        alocacao.setUsuario_id_comprador(rs.getInt("usuario_id_comprador"));
        alocacao.setId_evento(rs.getInt("id_evento"));
        alocacao.setTicket_codigo(rs.getInt("ticket_codigo"));

        return alocacao;
    }

    public boolean save(Alocacao alocacao) throws SQLException {
        String query = "INSERT INTO alocacao (usuario_id_comprador, id_evento, ticket_codigo) VALUES (?, ?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, alocacao);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
