package DAO;

import Entity.Evento;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoDAO {
    Connection con;
    DBDados dados = new DBDados();

    public EventoDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public PreparedStatement buildFullStatementSave(PreparedStatement pst, Evento evento) throws SQLException{
        pst.setString(1, evento.getNome());
        java.sql.Date dataEvento = new java.sql.Date(evento.getDataEvento().getTime());
        pst.setDate(2, dataEvento);
        java.sql.Date dataInscricao = new java.sql.Date(evento.getDataInscricao().getTime());
        pst.setDate(3, dataInscricao);
        pst.setInt(4, evento.getCapacidadeMaxima());
        pst.setInt(5, evento.getIdOrganizador());
        pst.setString(6, evento.getLocalEnd());

        return pst;
    }

    public boolean save(Evento evento) throws SQLException {
        String query = "ISERT INTO evento (nome, data_evento, data_inscricao, capacidade_maxima, id_organizador_criacao, id_localidade) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, evento);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
