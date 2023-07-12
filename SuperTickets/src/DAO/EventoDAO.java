package DAO;

import Entity.Evento;
import Entity.Local;
import db.DBConnection;
import db.DBDados;
import db.DBDriver;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventoDAO {
    Connection con;
    DBDados dados = new DBDados();

    public EventoDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, dados.getSchema(), dados.getUser(), dados.getPassword());
        }
    }

    public Evento buildEvento(ResultSet rs) throws SQLException{
        Evento evento = new Evento();
        evento.setIdEvento(rs.getInt("id_evento"));
        evento.setNome(rs.getString("nome"));
        evento.setDataEvento(rs.getDate("data_evento"));
        evento.setDataInscricao(rs.getDate("data_inscricao"));
        evento.setCapacidadeMaxima(rs.getInt("capacidade_maxima"));
        evento.setIdOrganizador(rs.getInt("id_organizador_criacao"));
        evento.setLocalEnd(rs.getString("id_localidade"));
        return evento;
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
        String query = "INSERT INTO evento (nome, data_evento, data_inscricao, capacidade_maxima, id_organizador_criacao, id_localidade) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSave(pst, evento);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    public ArrayList<Evento> getAllEventos() throws SQLException{
        String query = "SELECT * FROM evento";
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            Evento evento = buildEvento(rs);
            eventos.add(evento);
        }

        return eventos;
    }
}
