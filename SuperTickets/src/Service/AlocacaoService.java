package Service;

import java.sql.SQLException;

import DAO.AlocacaoDAO;
import Entity.Alocacao;

public class AlocacaoService {
    AlocacaoDAO dao = new AlocacaoDAO();

    public boolean comprarTicket(Alocacao alocacao){
        boolean success = false;

        try{
            success = dao.save(alocacao);
        }catch(SQLException e){
            System.out.println(e);
        }

        return success;
    }
    
}
