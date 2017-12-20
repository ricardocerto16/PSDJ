package business;

import interfaces.ICalculadora;
import interfaces.IFusos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Resposta {

    private ICalculadora calc;

    public Resposta(){
        calc = new Calculadora();
    }


    public String difDatas(LocalDate from, LocalDate to, String tipo) {
        StringBuilder sb = new StringBuilder();
        int res = calc.difDatas(from,to,tipo);

        sb.append(tipo).append(": ").append(res).append("\n");

        return sb.toString();
    }

    public String tempoFalta(String tipo, LocalDateTime data) {
        StringBuilder sb = new StringBuilder();
        int res = calc.tempoFalta(tipo,data);

        sb.append(tipo).append(": ").append(res).append("\n");

        return sb.toString();

    }

    public String diaSemana(LocalDate data){
        return calc.diaSemana(data);
    }



    public String comumBissexto(LocalDate data){
        StringBuilder sb = new StringBuilder();
        int res = calc.comumBissexto(data);

        if(res == 365){
                sb.append("O ano de introduzido corresponde a um ano Comum, com ").append(res).append(" dias");
            }
        else{
                sb.append("O ano de introduzido corresponde a um ano Bissexto, com ").append(res).append(" dias");
            }

        return sb.toString();
    }



    public String semanaCalendario(LocalDate data){
        StringBuilder sb = new StringBuilder();
        int res = calc.semanaCalendario(data);

        sb.append("Esta data pertence à ").append(res).append("º semana do ano introduzido");
        return sb.toString();
    }



    public String uteisEntreDatas(LocalDate d1,LocalDate d2){
        StringBuilder sb = new StringBuilder();
        int res = calc.uteisEntreDatas(d1,d2);

        sb.append("Entre as duas datas introduzidas, existem ").append(res).append(" dias úteis (contando com o dia da primeira data)");
        return sb.toString();
    }


    public String uteisAposData(LocalDate data, int uteis){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.uteisAposData(data,uteis);
        String diasemana_data = normalizarSemana(data.getDayOfWeek().toString());
        String diasemana_res = normalizarSemana(res.getDayOfWeek().toString());

        sb.append("A data de ").append(data).append("(").append(diasemana_data).append(")").append(" após ").append(uteis).append(" dias úteis, corresponde a ").append(res).append("(").append(diasemana_res).append(")");
        return sb.toString();
    }


    public String uteisAntesData(LocalDate data, int uteis){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.uteisAntesData(data,uteis);
        String diasemana_data = normalizarSemana(data.getDayOfWeek().toString());
        String diasemana_res = normalizarSemana(res.getDayOfWeek().toString());

        sb.append("A data de ").append(data).append("(").append(diasemana_data).append(")").append(", ").append(uteis).append(" dias úteis antes, corresponde a ").append(res).append("(").append(diasemana_res).append(")");
        return sb.toString();
    }


    public String adicionaData(LocalDate data, int adddia, int addsemana, int addmes, int addano){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.adicionaData(data,adddia,addsemana,addmes,addano);

        sb.append("A data de ").append(data).append(", adicionado os dias/semanas/meses/anos especificados, corresponde a ").append(res);
        return sb.toString();
    }


    public String removeData(LocalDate data, int rmdia, int rmsemana, int rmmes, int rmano){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.removeData(data,rmdia,rmsemana,rmmes,rmano);

        sb.append("A data de ").append(data).append(", removendo os dias/semanas/meses/anos especificados, corresponde a ").append(res);
        return sb.toString();
    }


    public String dataXDia(int dia, int ano){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.dataXDia(dia,ano);

        sb.append("O ").append(dia).append("º dia do ano de ").append(ano).append(", corresponde à data de ").append(res);
        return sb.toString();
    }


    public String xDiaData(LocalDate data){
        StringBuilder sb = new StringBuilder();
        int res = calc.xDiaData(data);

        sb.append("A data de ").append(data).append(" corresponde ao ").append(res).append("º dia do ano introduzido");
        return sb.toString();
    }


    public String semanaXDia(int dia, int ano){
        return calc.semanaXDia(dia,ano);
    }


    public String dataHoraEm(String zone){
        StringBuilder sb = new StringBuilder();

        String diasemana = normalizarSemana(calc.getSemana(zone));
        String dia = normalizarTempo(calc.getDia(zone));
        String mes = normalizarMes(calc.getMes(zone));
        String ano = calc.getAno(zone);
        String hora = normalizarTempo(calc.getHora(zone));
        String minuto = normalizarTempo(calc.getMinuto(zone));



        sb.append("Em ").append(zone).append(", são ").append(hora).append(" Horas e ").append(minuto).append(" minutos, do dia ").append(dia).append(" de ").append(mes).append(" de ").append(ano).append(", ").append(diasemana);
        return sb.toString();
    }



    public String primDiaMes(LocalDate data){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.primDiaMes(data);
        String dia_semana = normalizarSemana(calc.diaSemana(res));

        sb.append("O primeiro dia do mês, para a data inserida, corresponde a ").append(res).append(", ").append(dia_semana);
        return sb.toString();
    }


    public String ultDiaMes(LocalDate data){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.ultDiaMes(data);
        String dia_semana = normalizarSemana(calc.diaSemana(res));

        sb.append("O último dia do mês, para a data inserida, corresponde a ").append(res).append(", ").append(dia_semana);
        return sb.toString();
    }


    public String qntsDiasMes(LocalDate data){
        StringBuilder sb = new StringBuilder();
        int res = calc.qntsDiasMes(data);
        int res2 = calc.comumBissexto(data);

        if(res2 == 365) {
            sb.append("O mês introduzido tem ").append(res).append(" dias, sendo um ano Comum");
        }
        else{
            sb.append("O mês introduzido tem ").append(res).append(" dias, sendo um ano Bissexto");
        }
        return sb.toString();
    }

    public String primDiaAno(LocalDate data){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.primDiaAno(data);
        String dia_semana = normalizarSemana(calc.diaSemana(res));

        sb.append("O primeiro dia do ano, para a data inserida, corresponde a ").append(res).append(", ").append(dia_semana);
        return sb.toString();
    }

    public String ultDiaAno(LocalDate data){
        StringBuilder sb = new StringBuilder();
        LocalDate res = calc.ultDiaAno(data);
        String dia_semana = normalizarSemana(calc.diaSemana(res));

        sb.append("O último dia do ano, para a data inserida, corresponde a ").append(res).append(", ").append(dia_semana);
        return sb.toString();
    }





    ///////////////USER CLOCK/////////////

    //Normalizar horas e minutos || meses no menu principal
    public String normalizarTempo(String str) {
        if (str.length() == 1)
            str = "0" + str;

        return str;
    }

    //Normalizar data no menu principal
    public String normalizarData(String str) {
        if (str.length() < 36) {
            int dif = 36 - str.length();

            if (dif % 2 == 0) {

                for (int i = 1; i <= dif / 2; i++) {
                    str = " " + str + " ";
                }
            } else {

                for (int i = 1; i <= dif / 2; i++) {
                    str = " " + str + " ";

                }
                str = str + " ";
            }
        }
        return str;

    }

    //Normalizar offset no menu principal
    public String normalizarOffset(String str) {
        if (str.length() == 1) {
            str = "(+00:00)";
        } else {
            str = "(" + str + ")";
        }

        return str;
    }

    //Normalizar fuso horario no menu principal
    public String normalizarFuso(String str) {
        if (str.length() < 38) {
            int dif = 38 - str.length();

            if (dif % 2 == 0) {

                for (int i = 1; i <= dif / 2; i++) {
                    str = " " + str + " ";
                }
            } else {

                for (int i = 1; i <= dif / 2; i++) {
                    str = " " + str + " ";

                }
                str = str + " ";
            }
        }
        return str;
    }

    //Tradução dos dias da semana
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


    //Tradução dos meses
    public String normalizarMes(String str) {
        switch (str){
            case "JANUARY":
                str = "Janeiro";
                break;

            case "FEBRUARY":
                str = "Fevereiro";
                break;

            case "MARCH":
                str = "Março";
                break;

            case "APRIL":
                str = "Abril";
                break;

            case "MAY":
                str = "Maio";
                break;

            case "JUNE":
                str = "Junho";
                break;

            case "JULY":
                str = "Julho";
                break;

            case "AUGUST":
                str = "Agosto";
                break;

            case "SEPTEMBER":
                str = "Setembro";
                break;

            case "OCTOBER":
                str = "Outubro";
                break;

            case "NOVEMBER":
                str = "Novembro";
                break;

            case "DECEMBER":
                str = "Dezembro";
                break;
        }
        return str;
    }


}




