package business;

import interfaces.ICalculadora;

import java.time.*;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.*;
import java.time.temporal.Temporal;

public class Calculadora implements ICalculadora {

    //devolve os anos,meses ou dias entre duas datas
    public int difDatas(Temporal from, Temporal to, String tipo) {

        switch (tipo.toLowerCase()) {
            case "anos":
                return (int) ChronoUnit.YEARS.between(from,to);
            case "meses":
                return (int) ChronoUnit.MONTHS.between(from,to);
            case "dias":
                return (int) ChronoUnit.DAYS.between(from,to);
        }
        return 0;
    }

    //REVIEW
    //Devolve o número de ocorrências de um dia especifico(Sabado,Domingo...)
    public int numDiaEspecifico(Temporal from, Temporal to, DayOfWeek dia){
        int totalDias = difDatas(from,to,"dias");
        int dias = 0;
        LocalDate d1 = LocalDate.from(from);
        
        for(int i=0;i<totalDias;i++){
            d1 = d1.plusDays(i);
            if(d1.getDayOfWeek().equals(dias)){
                dias++;
            }
        }
        return dias;
    }   
    

    public int tempoFalta(String tipo, LocalDateTime data) {
        LocalDateTime now = LocalDateTime.now();
        long time[] = getTime(now, data);

        switch (tipo.toLowerCase()) {
            case "anos":
                return (int) ChronoUnit.YEARS.between(now, data);
            case "meses":
                return (int) ChronoUnit.MONTHS.between(now, data);
            case "dias":
                return (int) ChronoUnit.DAYS.between(now, data);
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


    //Calcula o número de dias úteis entre duas datas
    public int uteisEntreDatas(Temporal from, Temporal to) {
        int naoUteis = naoUteisEntreDatas(from,to);
        
        return (int) ChronoUnit.DAYS.between(from,to) + 1 - naoUteis;
    }
        /*
        int total_dias = difDatas(from, to, "dias");
        int dias_uteis = 0;

        for (int i = 0; i < total_dias; i++) {
            LocalDate tmp = from.plusDays(i);
            if (!(tmp.getDayOfWeek().equals(SATURDAY) || tmp.getDayOfWeek().equals(SUNDAY))){
                dias_uteis++;
            }
        }
        return dias_uteis;
        */
    
    //REVIEW
    //Calcula o número de fim de semanas entre duas datas
    public int numFimDeSemana(Temporal from, Temporal to){
        int totalDias = difDatas(from,to,"dias");
        LocalDate d1 = LocalDate.from(from);
        int numFDS = 0;
        
        for(int i=0;i<totalDias;i++){
            d1 = d1.plusDays(i);
            DayOfWeek dia = d1.getDayOfWeek();
            if(dia.equals(SATURDAY) || dia.equals(SUNDAY)){
                i++;
                numFDS++;
            }
        }
        
        return numFDS;
    }

    //REVIEW
    public int naoUteisEntreDatas(Temporal from,Temporal to){
        int sabado = numDiaEspecifico(from,to,DayOfWeek.SATURDAY);
        int domingo = numDiaEspecifico(from,to,DayOfWeek.SUNDAY);
        int feriados = numFeriados(from,to);
        
        return sabado+domingo+feriados;
    }
    
    //REVIEW
    public int numFeriados(Temporal from, Temporal to){
        int totalDias = difDatas(from,to,"dias");
        LocalDate d1 = LocalDate.from(from);
        int numF = 0;
        
        for(int i=0;i<totalDias;i++){
            d1.plusDays(i);
            if(isFeriado(d1)) numF++;
        }
        
        return numF;
    }
    
    //REVIEW
    //diz se uma data é um feriado (Portugal)
    public boolean isFeriado(LocalDate t){
        
        int ano = t.getYear();
        
        LocalDate f1 = LocalDate.of(ano, Month.JANUARY, 1);
        LocalDate f2 = LocalDate.of(ano, Month.MARCH,30);
        LocalDate f3 = LocalDate.of(ano, Month.APRIL,1);
        LocalDate f4 = LocalDate.of(ano, Month.APRIL,25);
        LocalDate f5 = LocalDate.of(ano, Month.MAY,1);
        LocalDate f6 = LocalDate.of(ano, Month.MAY,31);
        LocalDate f7 = LocalDate.of(ano, Month.JUNE,10);
        LocalDate f8 = LocalDate.of(ano, Month.AUGUST,15);
        LocalDate f9 = LocalDate.of(ano, Month.OCTOBER,5);
        LocalDate f10 = LocalDate.of(ano, Month.NOVEMBER,1);
        LocalDate f11 = LocalDate.of(ano, Month.DECEMBER,1);
        LocalDate f12 = LocalDate.of(ano, Month.DECEMBER,8);
        LocalDate f13 = LocalDate.of(ano, Month.DECEMBER, 25);
        
        return t.equals(f1) || t.equals(f2) ||
                t.equals(f3) || t.equals(f4) ||
                t.equals(f5) || t.equals(f6) ||
                t.equals(f7) || t.equals(f8) ||
                t.equals(f9) || t.equals(f10)||
                t.equals(f11)|| t.equals(f12)||
                t.equals(f13);
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




