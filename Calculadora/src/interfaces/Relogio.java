package interfaces;

import java.time.ZoneId;
import java.time.ZoneOffset;

public interface Relogio {


    public ZoneId getFuso();

    public ZoneOffset getOffSet(ZoneId f);
    
    public String getZoneAndOffset();
    
    public String getFormattedTime();
    
    public String getFormattedData(String dia);

}
