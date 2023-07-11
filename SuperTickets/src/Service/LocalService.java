package Service;

import DAO.LocalDAO;
import Entity.Local;

import java.sql.SQLException;
import java.util.ArrayList;

public class LocalService {
    LocalDAO dao = new LocalDAO();
    public ArrayList<Local> getAllLocais(){
        ArrayList<Local> locais = new ArrayList<Local>();

        try{
            locais = dao.getAllLocais();
        }catch(SQLException e){
            System.out.println(e);
        }

        return locais;
    }

    public boolean cadastrarLocal(Local local){
        boolean success = false;

        try{
            success = dao.save(local);
        }catch(SQLException e){
            System.out.println(e);
        }

        return success;
    }
}
