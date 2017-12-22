package business;


import interfaces.Relogio;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import static java.time.OffsetTime.now;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;




public class RelogioUser implements Relogio {

    public ZoneId getFuso() {
        return ZoneId.systemDefault();
    }

    public ZoneOffset getOffSet (ZoneId fuso) {
        OffsetTime off = now(fuso);
        ZoneOffset offset = off.getOffset();
        return offset;
    }
    
    public String getZoneAndOffset(){
        ZoneId fuso = getFuso();
        String offset = normalizarOffset(getOffSet(fuso));
        return fuso.toString() + offset;
    }
    
    public String normalizarOffset(ZoneOffset zot) {
        String str = zot.toString();
        if (str.length() == 1) {
            str = "(+00:00)";
        } else {
            str = "(" + str + ")";
        }

        return str;
    }
    
    public String getFormattedTime(){
        LocalTime hm = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        return hm.format(formatter);
    }
    
    public String getFormattedData(){
        LocalDate ld = LocalDate.now();
        String data = ld.format(ofPattern("dd MMMM yyyy"));
        String diasemana = normalizarSemana(ld.getDayOfWeek().toString());  
        return diasemana + ", " + data;
    }
    
    public String normalizarSemana(String str) {
        switch (str){
            case "MONDAY":
                str = "Segunda-Feira";
                break;

            case "TUESDAY":
                str = "Terça-Feira";
                break;

            case "WEDNESDAY":
                str = "Quarta-Feira";
                break;

            case "THURSDAY":
                str = "Quinta-Feira";
                break;

            case "FRIDAY":
                str = "Sexta-Feira";
                break;

            case "SATURDAY":
                str = "Sábado";
                break;

            case "SUNDAY":
                str = "Domingo";
                break;
        }
        return str;
    }
    
    /*
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
    */
}

