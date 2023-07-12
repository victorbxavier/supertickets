package Controller;

import Entity.Evento;
import Service.EventoService;

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

    public ArrayList<Evento> getAllEventos(){
        return service.getAllEventos();
    }

    public Evento getEventoById(int id){
        Evento evento = new Evento();
        return evento;
    }

}
