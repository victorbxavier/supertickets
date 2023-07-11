package Controller;

import Entity.Local;

import java.util.ArrayList;

public class LocalController {
    public ArrayList<Local> getAllLocais(){
        ArrayList<Local> locais = new ArrayList<Local>();
        return locais;
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
}
