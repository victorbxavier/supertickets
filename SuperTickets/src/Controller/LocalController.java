package Controller;

import Entity.Local;
import Service.LocalService;

import java.util.ArrayList;

public class LocalController {
    LocalService service = new LocalService();
    public ArrayList<Local> getAllLocais(){
        return service.getAllLocais();
    }

    public ArrayList<String> getAllLocaisEnderecos(){
        ArrayList<Local> locais = new ArrayList<Local>();
        locais = this.getAllLocais();
        ArrayList<String> enderecos = new ArrayList<String>();

        for(Local local : locais){
            enderecos.add(local.getEndereco());
        }

        return enderecos;
    }

    public boolean cadastrarLocal(Local local){
        return service.cadastrarLocal(local);
    }
}
