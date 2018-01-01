package interfaces;

import java.time.ZoneId;
import java.time.ZoneOffset;

public interface Relogio {

    // obter a zona de um fuso
    public ZoneId getFuso();

    // obter a zona de um fuso
    public ZoneOffset getOffSet(ZoneId f);

    // obter zona e offset de um fuso
    public String getZoneAndOffset();

    // formatação do tempo
    public String getFormattedTime();

    // obter a data formatada
    public String getFormattedData(String dia);

}
