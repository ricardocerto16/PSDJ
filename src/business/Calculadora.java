package business;

import java.time.*;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.ChronoUnit.*;

public class Calculadora implements ICalculadora {

    public int difDatas(LocalDate from, LocalDate to, String tipo) {
        Period periodo = getPeriod(from, to);

        switch (tipo.toLowerCase()) {
            case "anos":
                return periodo.getYears();
            case "meses":
                return periodo.getMonths();
            case "dias":
                return periodo.getDays();
        }
        return 0;
    }

    private Period getPeriod(LocalDate d1, LocalDate d2) {
        return Period.between(d1, d2);
    }

    public int tempoFalta(String tipo, LocalDateTime data) {
        LocalDateTime now = LocalDateTime.now();
        Period periodo = getPeriod(now.toLocalDate(), data.toLocalDate());
        long time[] = getTime(now, data);

        switch (tipo.toLowerCase()) {
            case "anos":
                return periodo.getYears();
            case "meses":
                return periodo.getMonths();
            case "dias":
                return periodo.getDays();
            case "horas":
                return (int) time[0];
            case "minutos":
                return (int) time[1];
            case "segundos":
                return (int) time[2];

        }
        return 0;
    }


    private static long[] getTime(LocalDateTime from, LocalDateTime to) {
        Duration duration = Duration.between(from, to);
        long[] res = new long[3];

        long segundos = duration.getSeconds();
        res[0] = segundos / (60 * 60);
        res[1] = ((segundos % (60 * 60)) / 60);
        res[2] = (segundos % 60);

        return res;
    }


    public String diaSemana(LocalDate data) {

        return data.getDayOfWeek().toString();
    }


    public int comumBissexto(LocalDate data) {

        return data.lengthOfYear();
    }


    public int semanaCalendario(LocalDate data) {

        return data.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
    }


    public int uteisEntreDatas(LocalDate from, LocalDate to) {
        int total_dias = difDatas(from, to, "dias");
        int dias_uteis = 0;

        for (int i = 0; i < total_dias; i++) {
            LocalDate tmp = from.plusDays(i);
            if (!(tmp.getDayOfWeek().equals(SATURDAY) || tmp.getDayOfWeek().equals(SUNDAY))){
               // System.out.println(tmp+", "+tmp.getDayOfWeek());
                dias_uteis++;
            }
        }
        return dias_uteis;
    }

    public LocalDate uteisAposData(LocalDate data, int uteis) {
        int i = 0;
        while (i < uteis) {
            if (!(data.getDayOfWeek().equals(SATURDAY) || data.getDayOfWeek().equals(SUNDAY))) {
                i++;
            }
            data = data.plus(1, DAYS);
        }
        return data;
    }

    public LocalDate uteisAntesData(LocalDate data, int uteis) {
        while (uteis > 0) {
            if (!(data.getDayOfWeek().equals(SATURDAY) || data.getDayOfWeek().equals(SUNDAY))) {
                uteis--;
            }
            data = data.minus(1, DAYS);
        }
        return data;
    }



    public LocalDate adicionaData(LocalDate data, int adddia, int addsemana, int addmes, int addano) {

        if((adddia != 0) && (addsemana == 0) && (addmes == 0) && (addano == 0)){
            data = data.plus(adddia,DAYS);
        }

        if((adddia == 0) && (addsemana != 0) && (addmes != 0) && (addano != 0)){
            data = data.plusWeeks(addsemana).plusMonths(addmes).plusYears(addano);
        }

        if((adddia == 0) && (addsemana != 0) && (addmes == 0) && (addano == 0)){
            data = data.plus(addsemana,WEEKS);
        }

        if((adddia != 0) && (addsemana == 0) && (addmes != 0) && (addano != 0)){
            data = data.plusDays(adddia).plusMonths(addmes).plusYears(addano);
        }

        if((adddia == 0) && (addsemana == 0) && (addmes != 0) && (addano == 0)){
            data = data.plus(addmes,MONTHS);
        }

        if((adddia != 0) && (addsemana != 0) && (addmes == 0) && (addano != 0)){
            data = data.plusDays(adddia).plusWeeks(addsemana).plusYears(addano);
        }

        if((adddia == 0) && (addsemana == 0) && (addmes == 0) && (addano != 0)){
            data = data.plus(addano,YEARS);
        }

        if((adddia != 0) && (addsemana != 0) && (addmes != 0) && (addano == 0)){
            data = data.plusDays(adddia).plusWeeks(addsemana).plusMonths(addmes);
        }

        if((adddia != 0) && (addsemana != 0) && (addmes != 0) && (addano != 0)){
            data = data.plusDays(adddia).plusWeeks(addsemana).plusMonths(addmes).plusYears(addano);
        }

        if((adddia != 0) && (addsemana != 0) && (addmes == 0) && (addano == 0)){
            data = data.plusDays(adddia).plusWeeks(addsemana);
        }

        if((adddia != 0) && (addsemana == 0) && (addmes != 0) && (addano == 0)){
            data = data.plusDays(adddia).plusMonths(addmes);
        }

        if((adddia != 0) && (addsemana == 0) && (addmes == 0) && (addano != 0)){
            data = data.plusDays(adddia).plusYears(addano);
        }

        if((adddia == 0) && (addsemana != 0) && (addmes != 0) && (addano == 0)){
            data = data.plusWeeks(addsemana).plusMonths(addmes);
        }

        if((adddia == 0) && (addsemana != 0) && (addmes == 0) && (addano != 0)){
            data = data.plusWeeks(addsemana).plusYears(addano);
        }

        if((adddia == 0) && (addmes != 0) && (addano != 0)){
            data = data.plusMonths(addmes).plusYears(addano);
        }

        return data;
    }


    public LocalDate removeData(LocalDate data, int rmdia, int rmsemana, int rmmes, int rmano) {

        if((rmdia != 0) && (rmsemana == 0) && (rmmes == 0) && (rmano == 0)){
            data = data.minus(rmdia,DAYS);
        }

        if((rmdia == 0) && (rmsemana != 0) && (rmmes != 0) && (rmano != 0)){
            data = data.minusWeeks(rmsemana).minusMonths(rmmes).minusYears(rmano);
        }

        if((rmdia == 0) && (rmsemana != 0) && (rmmes == 0) && (rmano == 0)){
            data = data.minus(rmsemana,WEEKS);
        }

        if((rmdia != 0) && (rmsemana == 0) && (rmmes != 0) && (rmano != 0)){
            data = data.minusDays(rmdia).minusMonths(rmmes).minusYears(rmano);
        }

        if((rmdia == 0) && (rmsemana == 0) && (rmmes != 0) && (rmano == 0)){
            data = data.minus(rmmes,MONTHS);
        }

        if((rmdia != 0) && (rmsemana != 0) && (rmmes == 0) && (rmano != 0)){
            data = data.minusDays(rmdia).minusWeeks(rmsemana).minusYears(rmano);
        }

        if((rmdia == 0) && (rmsemana == 0) && (rmmes == 0) && (rmano != 0)){
            data = data.minus(rmano,YEARS);
        }

        if((rmdia != 0) && (rmsemana != 0) && (rmmes != 0) && (rmano == 0)){
            data = data.minusDays(rmdia).minusWeeks(rmsemana).minusMonths(rmmes);
        }

        if((rmdia != 0) && (rmsemana != 0) && (rmmes != 0) && (rmano != 0)){
            data = data.minusDays(rmdia).minusWeeks(rmsemana).minusMonths(rmmes).minusYears(rmano);
        }

        if((rmdia != 0) && (rmsemana != 0) && (rmmes == 0) && (rmano == 0)){
            data = data.minusDays(rmdia).minusWeeks(rmsemana);
        }

        if((rmdia != 0) && (rmsemana == 0) && (rmmes != 0) && (rmano == 0)){
            data = data.minusDays(rmdia).minusMonths(rmmes);
        }

        if((rmdia != 0) && (rmsemana == 0) && (rmmes == 0) && (rmano != 0)){
            data = data.minusDays(rmdia).minusYears(rmano);
        }

        if((rmdia == 0) && (rmsemana != 0) && (rmmes != 0) && (rmano == 0)){
            data = data.minusWeeks(rmsemana).minusMonths(rmmes);
        }

        if((rmdia == 0) && (rmsemana != 0) && (rmmes == 0) && (rmano != 0)){
            data = data.minusWeeks(rmsemana).minusYears(rmano);
        }

        if((rmdia == 0) && (rmmes != 0) && (rmano != 0)){
            data = data.minusMonths(rmmes).minusYears(rmano);
        }

        return data;
    }



    public LocalDate dataXDia(int dia, int ano) {
        return LocalDate.ofYearDay(ano,dia);
    }


    public int xDiaData(LocalDate data){
        return data.getDayOfYear();
    }


    public String semanaXDia(int dia, int ano){
        Year yr = Year.of(ano);
        return yr.atDay(dia).getDayOfWeek().toString();
    }


    public LocalDate primDiaMes(LocalDate data){
        return data.with(TemporalAdjusters.firstDayOfMonth());
    }



    public LocalDate ultDiaMes(LocalDate data){
        return data.with(TemporalAdjusters.lastDayOfMonth());
    }


    public int qntsDiasMes(LocalDate data){
        return data.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }


    public LocalDate primDiaAno(LocalDate data){
        return data.with(TemporalAdjusters.firstDayOfYear());
    }


    public LocalDate ultDiaAno(LocalDate data){
        return data.with(TemporalAdjusters.lastDayOfYear());
    }



    public String getSemana(String zone){
         return String.valueOf(LocalDateTime.now(ZoneId.of(zone)).getDayOfWeek());
    }

    public String getDia(String zone){
        return String.valueOf(LocalDateTime.now(ZoneId.of(zone)).getDayOfMonth());
    }

    public String getMes(String zone){
        return LocalDateTime.now(ZoneId.of(zone)).getMonth().toString();
    }

    public String getAno(String zone){
        return String.valueOf(LocalDateTime.now(ZoneId.of(zone)).getYear());
    }

    public String getHora(String zone){
        return String.valueOf(LocalDateTime.now(ZoneId.of(zone)).getHour());
    }

    public String getMinuto(String zone){
        return String.valueOf(LocalDateTime.now(ZoneId.of(zone)).getMinute());
    }






}




