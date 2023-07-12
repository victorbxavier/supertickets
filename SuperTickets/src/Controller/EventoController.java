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

    public ArrayList<Evento> getAllEventosCadastrados(int id){
        return service.getAllEventosCadastrados(id);
    }

    public Evento getEventoById(int id){
        Evento evento = new Evento();
        return evento;
    }

    public ArrayList<Evento> getEventosByNome(String nome){
        return service.getEventosByName(nome);
    }

}
