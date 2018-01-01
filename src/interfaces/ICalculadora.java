package interfaces;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;


public interface ICalculadora {

    // Calcula a diferença em dias, anos ou meses entre 2 datas
    int difDatas(Temporal from, Temporal to, String tipo);

    // Calcula o número de ocorrências de um dia especifico(Sabado,Domingo...)
    int tempoFalta(String tipo, LocalDateTime data);

    // Dia da semana
    String diaSemana(LocalDate data);

    // Verifica se um ano é comum ou bissexto
    int comumBissexto(LocalDate data);

    // Indica a semana do calandário de uma dada data
    int semanaCalendario(LocalDate data);

    //Número de dias úteis entre as datas
    int uteisEntreDatas(Temporal from, Temporal to);
    
    // Número de fim de semanas num dado intervalo
    int numFimDeSemana(Temporal from, Temporal to);
    
    // Número no ano de um dado dia
    int numDiaEspecifico(Temporal from, Temporal to, DayOfWeek dia);
    
    // Número de dias não úteis num intervalo de tempo
    int naoUteisEntreDatas(Temporal from,Temporal to);
    
    // Número de feriados num dado intervalo
    int numFeriados(Temporal from, Temporal to);
    
    // Verifica se o dia em questão é feriado ou não
    boolean isFeriado(LocalDate t);

    // Adiciona dias úteis à data atual
    LocalDate uteisAposData(LocalDate data, int uteis);

    // Remove dias úteis à data atual
    LocalDate uteisAntesData(LocalDate data, int uteis);

    // Adiciona dias, meses e/ou anos a uma data
    LocalDate adicionaData(LocalDate data, int adddia, int addsemana, int addmes, int addano);

    // Remove dias, meses e/ou anos a uma data
    LocalDate removeData(LocalDate data, int rmdia, int rmsemana, int rmmes, int rmano);

    // Dada um dia um número de dia calcula a sua respetiva data
    LocalDate dataXDia(int dia, int ano);

    // Dada uma data retorna o número do dia do ano
    int xDiaData(LocalDate data);

    //
    String semanaXDia(int dia, int ano);

    // primeiro dia do mês
    LocalDate primDiaMes(LocalDate data);

    // último dia do mês
    LocalDate ultDiaMes(LocalDate data);

    // número de dias de um mês
    int qntsDiasMes(LocalDate data);

    // primeiro dia do ano
    LocalDate primDiaAno(LocalDate data);

    // último dia do ano
    LocalDate ultDiaAno(LocalDate data);

    // obter dias da semana em função de zona
    String getSemana(String zone);

    // obter dias em função de uma zona
    String getDia(String zone);

    // obter os meses em função de uma zona
    String getMes(String zone);

    // obter o ano em função de uma zona
    String getAno(String zone);

    // obter a hora em função de uma zona
    String getHora(String zone);

    // obter o minuto em função de uma hora
    String getMinuto(String zone);


}
