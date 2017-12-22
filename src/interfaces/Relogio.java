package interfaces;

import java.time.ZoneId;
import java.time.ZoneOffset;

public interface Relogio {


    public ZoneId getFuso();

    public ZoneOffset getOffSet(ZoneId f);
    
    public String getZoneAndOffset();
    
    public String getFormattedTime();
    
    public String getFormattedData();

    /*
    public String getDiaSemana();

    public String getDia();

    public String getMes();

    public String getAno();

    public String getHora();

    public String getMinuto();
*/
}
