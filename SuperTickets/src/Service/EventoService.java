package Service;

import DAO.EventoDAO;
import Entity.Evento;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
