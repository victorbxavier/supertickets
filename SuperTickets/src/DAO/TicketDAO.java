package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Evento;
import Entity.Ticket;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

public class TicketDAO {
    Connection con;
    DBDados dados = new DBDados();

    public TicketDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, Ticket ticket) throws SQLException{
        pst.setInt(1, ticket.getCodigo());
        pst.setString(2, ticket.getTipo());
        pst.setInt(3, ticket.getIdEvento());

        return pst;
    }

    public Ticket buildTicket(ResultSet rs) throws SQLException{
        Ticket ticket = new Ticket();
        ticket.setCodigo(rs.getInt("codigo"));
        ticket.setTipo(rs.getString("tipo_ticket_Evento_id_evento"));
        ticket.setIdEvento(rs.getInt("tipo_ticket_Evento_id_Evento"));

        return ticket;
    }

    public boolean save(Ticket ticket) throws SQLException {
        String query = "INSERT INTO ticket (codigo, tipo_ticket_Evento_id_evento, tipo_ticket_tipo) VALUES (?, ?, ?)";
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
