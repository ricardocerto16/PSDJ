package business;


import interfaces.Relogio;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;




public class RelogioUser implements Relogio {

    public String getFuso() {
        String fuso = (ZoneId.systemDefault()).toString();
        return fuso;
    }

    public String getOffSet () {
        String offset = String.valueOf(ZonedDateTime.now(ZoneId.systemDefault()).getOffset());
        return offset;
    }

    public String getDiaSemana() {
        String diasemana = String.valueOf(LocalDateTime.now().getDayOfWeek());
        return diasemana;
    }

    public String getDia() {
        String diasemana = String.valueOf(LocalDateTime.now().getDayOfMonth());
        return diasemana;
    }

    public String getMes() {
        String diasemana = String.valueOf(LocalDateTime.now().getMonth());
        return diasemana;
    }

    public String getAno() {
        String ano = String.valueOf(LocalDateTime.now().getYear());
        return ano;
    }

    public String getHora() {
        String hora = String.valueOf(LocalDateTime.now().getHour());
        return hora;
    }

    public String getMinuto() {
        String minuto = String.valueOf(LocalDateTime.now().getMinute());
        return minuto;
    }
}

