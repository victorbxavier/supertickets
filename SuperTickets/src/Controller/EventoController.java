package Controller;

import Entity.Comprador;
import Entity.Evento;
import Entity.Ticket;
import Service.EventoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EventoController {
    EventoService service = new EventoService();

    public Date stringToDate(String string){
        return service.stringToDate(string);
    }

    public boolean cadastrarEvento(Evento evento){
        return service.cadastrarEvento(evento);
    }

     public ArrayList<Evento> getAllEventosName(){
        return service.getAllEventos();
    }
}
