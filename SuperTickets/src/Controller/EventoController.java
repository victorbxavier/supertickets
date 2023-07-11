package Controller;

import Entity.Evento;
import Service.EventoService;

import java.util.Date;

public class EventoController {
    EventoService service = new EventoService();

    public Date stringToDate(String string){
        return service.stringToDate(string);
    }

    public boolean cadastrarEvento(Evento evento){
        return false;
    }
}
