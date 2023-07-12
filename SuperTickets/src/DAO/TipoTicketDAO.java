package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.TipoTicket;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

public class TipoTicketDAO {
    Connection con;
    DBDados dados = new DBDados();

    public TipoTicketDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, TipoTicket tipoTicket) throws SQLException{
        pst.setFloat(1, tipoTicket.getValor());
        pst.setFloat(2, tipoTicket.getDesconto());
        pst.setString(3, tipoTicket.getTipo());
        pst.setInt(4, tipoTicket.getEvento_id_evento());
        return pst;
    }

    public TipoTicket buildTicket(ResultSet rs) throws SQLException{
        TipoTicket ticket = new TipoTicket();
        ticket.setValor(rs.getFloat("valor"));
        ticket.setDesconto(rs.getFloat("desconto"));
        ticket.setTipo(rs.getString("tipo"));
        ticket.setEvento_id_evento(rs.getInt("Evento_id_evento"));

        return ticket;
    }

    public boolean save(TipoTicket ticket) throws SQLException {
        String query = "INSERT INTO tipo_ticket (valor, desconto, tipo, Evento_id_evento) VALUES (?, ?, ?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, ticket);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
