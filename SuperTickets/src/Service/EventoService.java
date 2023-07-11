package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventoService {

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
}
