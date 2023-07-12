package Service;

import DAO.EventoDAO;
import Entity.Comprador;
import Entity.Evento;
import Entity.Ticket;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventoService {

    EventoDAO dao = new EventoDAO();
    public Date stringToDate(String string){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        try {
            data = dateFormat.parse(string);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido.");
        }

        return data;
    }

    public boolean cadastrarEvento(Evento evento){
        boolean success = false;

        try{
            success = dao.save(evento);
        }catch(SQLException e){
            System.out.println(e);
        }

        return success;
    }

    public ArrayList<Evento> getAllEventos(){
        ArrayList<Evento> eventos = new ArrayList<Evento>();

        try{
            eventos = dao.getAllEventos();
        }catch(SQLException e){
            System.out.println(e);
        }

        return eventos;
    }
}
