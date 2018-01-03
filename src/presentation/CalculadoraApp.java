package presentation;


import business.Cronometro;
import business.Resposta;
import business.RelogioUser;
import business.Fusos;

import java.time.*;
import static java.time.OffsetTime.now;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;


public class CalculadoraApp {

    private static Resposta principal;
    private static RelogioUser rel;
    private static Fusos fusos;
    private static Cronometro cron;
    private static Menu startMenu, cronometroMenu, duracaoMenu, calculadoraMenu, uteisMenu, adicionaRemoveMenu, diaXMenu, diamesMenu, diaanoMenu, fusoshMenu;


    private CalculadoraApp() {}

    public static void main (String [] args) {
        principal = new Resposta();
        rel = new RelogioUser();
        fusos = new Fusos();
        cron = new Cronometro();
        carregarMenus();
        printMenuPrincipal();
    }



    private static void carregarMenus() {
        
        String zona = rel.getZoneAndOffset();
        
        
        String time = rel.getFormattedTime();
        
        String diasemana = principal.normalizarSemana(LocalDate.now().getDayOfWeek().toString());  
        String dataF = rel.getFormattedData(diasemana);
       


        String [] start= {
                "                                       * *                                                  "+dataF+"        * *",
                "                                       * *     ______    _                                                                       * *",
                "                                       * *    /_  __/   (_)   ____ ___   ___                          "+time+"               * *",
                "                                       * *     / /     / /   / __ `__ \\ / _ \\                                                    * *",
                "                                       * *    / /     / /   / / / / / //  __/                    "+zona+"           * *",
                "                                       * *   /_/     /_/   /_/ /_/ /_/ \\___/                                                     * *",
                "                                       * *                                                                                       * *",
                "                                       * *     ______            __                   __           __                            * *",
                "                                       * *    / ____/  ____ _   / /  _____  __  __   / /  ____ _  / /_  ____    _____            * *",
                "                                       * *   / /      / __ `/  / /  / ___/ / / / /  / /  / __ `/ / __/ / __ \\  / ___/            * *",
                "                                       * *  / /___   / /_/ /  / /  / /__  / /_/ /  / /  / /_/ / / /_  / /_/ / / /                * *",
                "                                       * *  \\____/   \\__,_/  /_/   \\___/  \\__,_/  /_/   \\__,_/  \\__/  \\____/ /_/                 * *",
                "                                       * *                                                                                       * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
                "                                                 * *                    1 - CALCULADORA                                * *",
                "                                                 * *                    2 - DIA DO MÊS                                 * *",
                "                                                 * *                    3 - DIA DO ANO                                 * *",
                "                                                 * *                    4 - ADICIONAR/SUBTRAIR DE UMA DATA             * *",
                "                                                 * *                    5 - FUSOS HORÁRIOS                             * *",
                "                                                 * *                    6 - CRONOMETRO                                 * *",
                "                                                 * *                                                                   * *",

        };



        String [] calculadora = {
                "                                       * *                                                                                                   * *",
                "                                       * *                            1 - CALCULADORA ENTRE DUAS DATAS                                       * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            2 - CALCULADORA DOS DIAS DA SEMANA                                     * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            3 - CALCULADORA DA SEMANA DE CALENDÁRIO                                * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            4 - CALCULADORA DIAS ÚTEIS                                             * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            5 - CALCULADORA DO Xº DIA                                              * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            6 - CALCULADORA DE Nº VEZES DE UM DIA ESPECIFICO                       * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            7 - CALCULADORA DE FIM DE SEMANA                                       * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            8 - CALCULADORA DIAS NÃO ÚTEIS                                         * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            9 - CALCULADORA FERIADOS                                               * *",
                "                                       * *                                                                                                   * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                            * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };

        String [] duracao = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - DURAÇÃO ENTRE DUAS DATAS                               * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - TEMPO EM FALTA ATÉ DETERMINADA DATA                    * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };

        String [] uteis = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - DIAS ÚTEIS ENTRE DUAS DATAS                            * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - DETERMINAR DATA APÓS \"X\" DIAS ÚTEIS                    * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            3 - DETERMINAR DATA ANTES DE \"X\" DIAS ÚTEIS                * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };


        String [] xdia = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - DATA DO Xº DIA DO ANO                                  * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - SEMANA DO Xº DIA DO ANO                                * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            3 - Xº DIA DE UMA DATA                                     * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };


        String [] adicionaRemove = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - ADICIONAR A UMA DATA                                   * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - REMOVER A UMA DATA                                     * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };

        String [] diames = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - PRIMEIRO DIA DO MÊS                                    * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - ÚLTIMO DIA DO MÊS                                      * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            3 - DETERMINAR NÚMERO DE DIAS DE UM MÊS                    * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };


        String [] diaano = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - PRIMEIRO DIA DO ANO                                    * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - ÚLTIMO DIA DO ANO                                      * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            3 - DETERMINAR SE O ANO É COMUM OU BISSEXTO                * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };


        String [] fusosh = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - DURAÇÃO DE UMA VIAGEM ENTRE 2 ZONAS                        * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - TEMPO ATUAL NUMA ZONA                                  * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };


        String [] cronometro = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - START                                                  * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - STOP                                                   * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
        };

        startMenu = new Menu(start);
        calculadoraMenu = new Menu(calculadora);
        duracaoMenu = new Menu(duracao);
        uteisMenu = new Menu(uteis);
        adicionaRemoveMenu = new Menu(adicionaRemove);
        diaXMenu = new Menu(xdia);
        diamesMenu = new Menu(diames);
        diaanoMenu = new Menu(diaano);
        fusoshMenu = new Menu(fusosh);
        cronometroMenu = new Menu(cronometro);
    }



    private static void printMenuPrincipal() {
        int op;

        do{
            op = startMenu.showMenu();
            switch (op){
                case 1:
                    clearScreen();
                    printCalculadoraMenu();
                    break;

                case 2:
                    clearScreen();
                    printDiaMesMenu();
                    break;

                case 3:
                    clearScreen();
                    printDiaAnoMenu();
                    break;

                case 4:
                    clearScreen();
                    printAdicionaRemoveMenu();
                    break;

                case 5:
                    clearScreen();
                    printFusosHorariosMenu();
                    break;

                case 6:
                    clearScreen();
                    printCronometroMenu();
                    break;

            }
        } while (op != 0);
    }

    private static void printCronometroMenu() {
        int op;
        String time = "Inicie o cronometro";
        String resp = " * *               O tempo do cronómetro é :  ";
        do {
            op = cronometroMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    cron.start();
                    System.out.println(" * *                CRONOMETRO INICIADO COM SUCESSO      * * \n");
                    break;

                case 2:
                    clearScreen();
                    time = cron.print();
                    System.out.println( resp + time + "  segundos      * *");
                    System.out.println("Pressione Enter Para Continuar");
                    while (!startMenu.readString("").equals("")) {
                        System.out.println("Pressione Enter Para Continuar");
                    }
                    break;
            }
        } while (op != 0);

    }

    private static void printCalculadoraMenu() {
        int op;
        do {
            op = calculadoraMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    printDuracaoMenu();
                    break;

                case 2:
                    clearScreen();
                    calculadoraDiasSemana();
                    break;

                case 3:
                    clearScreen();
                    calculadoraSemanaCalendario();
                    break;

                case 4:
                    clearScreen();
                    printDiasUteisMenu();
                    break;

                case 5:
                    clearScreen();
                    printdiaXMenu();
                    break;
                    
                case 6:
                    clearScreen();
                    calculadoraDiaEspecifico();
                    break;
                
                case 7:
                    clearScreen();
                    printFimDeSemana();
                    break;
                    
                case 8:
                    clearScreen();
                    printDiasNUteis();
                    break;
                
                case 9:
                    clearScreen();
                    printFeriados();
                    break;
            }
        } while (op != 0);
    }


    private static void printDuracaoMenu() {
        int op;
        do {
            op = duracaoMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraDuracao();
                    break;

                case 2:
                    clearScreen();
                    calculadoraTempoFalta();
                    break;
            }
        } while (op != 0);
    }




    private static void printDiasUteisMenu() {
        int op;
        do {
            op = uteisMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraDiasUteisEntreDatas();
                    break;

                case 2:
                    clearScreen();
                    calculadoraDiasUteisApos();
                    break;

                case 3:
                    clearScreen();
                    calculadoraDiasUteisAntes();
                    break;                
            }
        } while (op != 0);
    }


    private static void printAdicionaRemoveMenu() {
        int op;
        do {
            op = adicionaRemoveMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraAdiciona();
                    break;

                case 2:
                    clearScreen();
                    calculadoraRemove();
                    break;
            }
        } while (op != 0);
    }



    private static void printdiaXMenu() {
        int op;
        do {
            op = diaXMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraDataXDia();
                    break;

                case 2:
                    clearScreen();
                    calculadoraSemanaXDia();
                    break;

                case 3:
                    clearScreen();
                    calculadoraXDiaData();
                    break;
            }
        } while (op != 0);
    }



    private static void printDiaMesMenu() {
        int op;
        do {
            op = diamesMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraPrimeiroDiaMes();
                    break;

                case 2:
                    clearScreen();
                    calculadoraUltimoDiaMes();
                    break;

                case 3:
                    clearScreen();
                    calculadoraQuantosDiaMes();
                    break;
            }
        } while (op != 0);
    }


    private static void printDiaAnoMenu() {
        int op;
        do {
            op = diaanoMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraPrimeiroDiaAno();
                    break;

                case 2:
                    clearScreen();
                    calculadoraUltimoDiaAno();
                    break;

                case 3:
                    clearScreen();
                    calculadoraComumBissexto();
                    break;
            }
        } while (op != 0);
    }


    private static void printFusosHorariosMenu() {
        int op;
        do {
            op = fusoshMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    fusoDiferenca2Tempos();
                    break;

                case 2:
                    clearScreen();
                    fusoTempoAtual();
                    break;
            }
        } while (op != 0);
    }







    private static void calculadoraDuracao() {

        String tipo,resposta;
        Integer d1dia,d1mes,d1ano,d2dia,d2mes,d2ano;
        clearScreen();

        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        tipo = startMenu.readString(         "                                       * *       Calcular a duração em 'Anos', 'Meses' ou 'Dias'?                                * *");

        while(!tipo.equals("Eras") && !tipo.equals("Anos") && !tipo.equals("Meses") && !tipo.equals("Dias") && !tipo.equals("eras") && !tipo.equals("anos") && !tipo.equals("meses") && !tipo.equals("dias") && !tipo.equals("ERAS") && !tipo.equals("ANOS") && !tipo.equals("MESES") && !tipo.equals("DIAS") && !tipo.equals("e") && !tipo.equals("a") && !tipo.equals("m") && !tipo.equals("d")){
            System.out.println("> O Valor Introduzido Não É Válido!\n");
            tipo = startMenu.readString(     "                                       * *       Calcular a duração em 'Eras', 'Anos', 'Meses' ou 'Dias'?                        * *");
        }
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da primeira data:                                               * *");
        System.out.println(                       "\n                                                                 A Primeira Data Foi Introduzida Com Sucesso");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d2dia = startMenu.readInt(           "                                       * *       Introduza o dia da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2mes = startMenu.readInt(           "                                       * *       Introduza o mês da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2ano = startMenu.readInt(           "                                       * *       Introduza o ano da segunda data:                                                * *");
        System.out.println(                       "                                       * *                         A Segunda Data Foi Introduzida Com Sucesso                    * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *          \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        LocalDate d2 = LocalDate.of(d2ano,d2mes,d2dia);

        resposta = principal.difDatas(d1,d2,tipo);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }



    private static void calculadoraTempoFalta() {
        String tipo,resposta;
        Integer d1dia, d1mes, d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                                     * *");
        tipo = startMenu.readString(         "                                       * *       Calcular o tempo em falta em 'Anos', 'Meses', 'Dias', 'Horas', 'Minutos' ou 'Segundos'?       * *");

        while(!tipo.equals("Anos") && !tipo.equals("Meses") && !tipo.equals("Dias") && !tipo.equals("Horas") && !tipo.equals("Minutos") && !tipo.equals("Segundos") && !tipo.equals("anos") && !tipo.equals("meses") && !tipo.equals("dias") && !tipo.equals("horas") && !tipo.equals("minutos") && !tipo.equals("segundos") && !tipo.equals("ANOS") && !tipo.equals("MESES") && !tipo.equals("DIAS") && !tipo.equals("HORAS") && !tipo.equals("MINUTOS") && !tipo.equals("SEGUNDOS")){
            System.out.println("\n> O Valor Introduzido Não É Válido!\n");
            tipo = startMenu.readString(     "                                       * *       Calcular o tempo em falta em 'Anos', 'Meses' 'Dias', 'Horas', 'Minutos' ou 'Segundos'?        * *");
        }
        System.out.println(                       "                                       * *                                                                                                     * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da data:                                                                      * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                                      * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                                      * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                                          * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *             \n");

        LocalDateTime d1 = LocalDateTime.of(d1ano, d1mes, d1dia, 0, 0, 0);

        resposta = principal.tempoFalta(tipo,d1);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }

    }

    private static void calculadoraDiasSemana()  {
        //Em que dia da semana calhou uma dada data


        String resposta;
        Integer d1dia,d1mes,d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(
                "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                            A Data Foi Introduzida Com Sucesso                         * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        resposta = principal.normalizarSemana(principal.diaSemana(d1));
        System.out.println(resposta);



        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }

    private static void calculadoraComumBissexto(){
        //dizer se o ano introduzido era/será comum ou bissexto (meter também 365 ou 366)

        String resposta;
        Integer d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano a identificar:                                                  * *");
        System.out.println(                       "                                       * *                         O Ano Foi Introduzida Com Sucesso                             * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,1,1);
        resposta = principal.comumBissexto(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }

    private static void calculadoraSemanaCalendario() {
        // A que semana pertence uma determinada data

        String resposta;
        Integer d1dia,d1mes,d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");



        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        resposta = principal.semanaCalendario(d1);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }

    private static void calculadoraDiasUteisEntreDatas() {
        //conta os dias úteis entre duas datas,
        String resposta;
        Integer d1dia, d1mes, d1ano, d2dia, d2mes, d2ano;
        clearScreen();

        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da primeira data:                                               * *");
        System.out.println(                       "\n                                                                 A Primeira Data Foi Introduzida Com Sucesso");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d2dia = startMenu.readInt(           "                                       * *       Introduza o dia da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2mes = startMenu.readInt(           "                                       * *       Introduza o mês da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2ano = startMenu.readInt(           "                                       * *       Introduza o ano da segunda data:                                                * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                         A Segunda Data Foi Introduzida Com Sucesso                    * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        LocalDate d2 = LocalDate.of(d2ano,d2mes,d2dia);

        resposta = principal.uteisEntreDatas(d1,d2);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }
    private static void printDiasNUteis() {
        //conta os dias úteis entre duas datas,
        String resposta;
        Integer d1dia, d1mes, d1ano, d2dia, d2mes, d2ano;
        clearScreen();

        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da primeira data:                                               * *");
        System.out.println(                       "\n                                                                 A Primeira Data Foi Introduzida Com Sucesso");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d2dia = startMenu.readInt(           "                                       * *       Introduza o dia da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2mes = startMenu.readInt(           "                                       * *       Introduza o mês da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2ano = startMenu.readInt(           "                                       * *       Introduza o ano da segunda data:                                                * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                         A Segunda Data Foi Introduzida Com Sucesso                    * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        LocalDate d2 = LocalDate.of(d2ano,d2mes,d2dia);

        resposta = principal.nUteisEntreDatas(d1,d2);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }
    
    
    
    //REVIEW
    private static void printFimDeSemana() {
        
        String resposta;
        Integer d1dia, d1mes, d1ano, d2dia, d2mes, d2ano;
        clearScreen();

        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da primeira data:                                               * *");
        System.out.println(                       "\n                                                                 A Primeira Data Foi Introduzida Com Sucesso");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d2dia = startMenu.readInt(           "                                       * *       Introduza o dia da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2mes = startMenu.readInt(           "                                       * *       Introduza o mês da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2ano = startMenu.readInt(           "                                       * *       Introduza o ano da segunda data:                                                * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                         A Segunda Data Foi Introduzida Com Sucesso                    * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        LocalDate d2 = LocalDate.of(d2ano,d2mes,d2dia);

        resposta = principal.fimDeSemana(d1,d2);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }
    
    private static void printFeriados() {
        
        String resposta;
        Integer d1dia, d1mes, d1ano, d2dia, d2mes, d2ano;
        clearScreen();

        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da primeira data:                                               * *");
        System.out.println(                       "\n                                                                 A Primeira Data Foi Introduzida Com Sucesso");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d2dia = startMenu.readInt(           "                                       * *       Introduza o dia da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2mes = startMenu.readInt(           "                                       * *       Introduza o mês da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2ano = startMenu.readInt(           "                                       * *       Introduza o ano da segunda data:                                                * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                         A Segunda Data Foi Introduzida Com Sucesso                    * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        LocalDate d2 = LocalDate.of(d2ano,d2mes,d2dia);

        resposta = principal.feriados(d1,d2);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }
       
    
    //REVIEW
    private static void calculadoraDiaEspecifico(){
        
        String resposta,diaSemana;
        Integer d1dia, d1mes, d1ano, d2dia, d2mes, d2ano;
        clearScreen();

        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da primeira data:                                               * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da primeira data:                                               * *");
        System.out.println(                       "\n                                                                 A Primeira Data Foi Introduzida Com Sucesso");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d2dia = startMenu.readInt(           "                                       * *       Introduza o dia da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2mes = startMenu.readInt(           "                                       * *       Introduza o mês da segunda data:                                                * *");
        System.out.println("> Valor Introduzido!\n");
        d2ano = startMenu.readInt(           "                                       * *       Introduza o ano da segunda data:                                                * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * *                         A Segunda Data Foi Introduzida Com Sucesso                    * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        diaSemana = startMenu.readString(         "                                  * *       Introduza o dia da semana:                                                      * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        LocalDate d2 = LocalDate.of(d2ano,d2mes,d2dia);

        resposta = principal.diaEspecifico(d1,d2,diaSemana);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }

    private static void calculadoraDiasUteisApos() {
        //dada uma data de inicio e um número de dias uteis, diz que data será
        String resposta;
        Integer d1dia,d1mes,d1ano;
        Integer uteis;
        clearScreen();

        System.out.println(                        "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                        "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(            "                                       * *       Introduza o dia da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(            "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(            "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                        "\n                                                                      A Data Foi Introduzida Com Sucesso");
        System.out.println(                        "                                       * *                                                                                       * *");
        uteis = startMenu.readInt(            "                                       * *       Introduza quantos dias úteis deseja adicionar:                                  * *");
        System.out.println(                        "                                       * *                                                                                       * *");
        System.out.println(                        "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                        "                                                         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        resposta = principal.uteisAposData(d1,uteis);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraDiasUteisAntes() {
        //dada uma data de inicio e um número de dias uteis, diz que data foi
        String resposta;
        Integer d1dia,d1mes,d1ano;
        Integer uteis;
        clearScreen();

        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "\n                                                                     A Data Foi Introduzida Com Sucesso");
        System.out.println(                       "                                       * *                                                                                       * *");
        uteis = startMenu.readInt(           "                                       * *       Introduza quantos dias úteis deseja subtrair:                                   * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                          * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        resposta = principal.uteisAntesData(d1,uteis);
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }



    private static void calculadoraAdiciona() {
        //Adicionar a uma data, se não quiser adicionar um dos valores, meter 0;


        String resposta;
        Integer d1dia, d1mes, d1ano,adddia, addsemana,addmes, addano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        adddia = startMenu.readInt(          "                                       * *       Quantos dias deseja adicionar ?                                                 * *");
        System.out.println("> Valor Introduzido!\n");
        addsemana = startMenu.readInt(       "                                       * *       Quantas semanas deseja adicionar ?                                              * *");
        System.out.println("> Valor Introduzido!\n");
        addmes = startMenu.readInt(          "                                       * *       Quantos meses deseja adicionar ?                                                * *");
        System.out.println("> Valor Introduzido!\n");
        addano = startMenu.readInt(          "                                       * *       Quantos anos deseja adicionar ?                                                 * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        resposta = principal.adicionaData(d1,adddia,addsemana,addmes,addano);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }




    private static void calculadoraRemove() {



        String resposta;
        Integer d1dia, d1mes, d1ano,rmdia, rmsemana, rmmes, rmano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        rmdia = startMenu.readInt(           "                                       * *       Quantos dias deseja remover ?                                                   * *");
        System.out.println("> Valor Introduzido!\n");
        rmsemana = startMenu.readInt(        "                                       * *       Quantas semanas deseja remover ?                                                * *");
        System.out.println("> Valor Introduzido!\n");
        rmmes = startMenu.readInt(           "                                       * *       Quantos meses deseja remover ?                                                  * *");
        System.out.println("> Valor Introduzido!\n");
        rmano = startMenu.readInt(           "                                       * *       Quantos anos deseja remover ?                                                   * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        resposta = principal.removeData(d1,rmdia,rmsemana,rmmes,rmano);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraDataXDia() {


        String resposta;
        Integer dia,d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        dia = startMenu.readInt(             "                                       * *       Introduza o dia do ano para o qual deseja descobrir a data:                     * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano a identificar:                                                  * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        resposta = principal.dataXDia(dia,d1ano);
         System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
         System.out.println(                       "                                       * *                                                                                             * *");
         System.out.println(                       "                                       * *  " + resposta + "                                                                           * *");
         System.out.println(                       "                                       * *                                                                                             * *");
         System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

         System.out.println("Pressione Enter Para Continuar");
          while (!startMenu.readString("").equals("")) {
              System.out.println("Pressione Enter Para Continuar");
         }
        //clearScreen();

    }


    private static void calculadoraXDiaData(){


        String resposta;
        Integer d1dia, d1mes, d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1dia = startMenu.readInt(           "                                       * *       Introduza o dia da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        resposta = principal.xDiaData(d1);
        System.out.println(resposta);

        //System.out.println("Pressione Enter Para Continuar");
        //while (!startMenu.readString("").equals("")) {
        //    System.out.println("Pressione Enter Para Continuar");
        //}
    }


    private static void calculadoraSemanaXDia() {

        String resposta;
        Integer dia,d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        dia = startMenu.readInt(             "                                       * *       Introduza o dia do ano para o qual deseja descobrir a data:                     * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano a identificar:                                                  * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        resposta = principal.normalizarSemana(principal.semanaXDia(dia,d1ano));
        System.out.println(resposta);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }
    

    private static void calculadoraPrimeiroDiaMes() {


        String resposta;
        Integer d1dia,d1mes,d1ano;
        clearScreen();
        d1dia = 1;
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);

        resposta = principal.primDiaMes(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraUltimoDiaMes() {


        String resposta;
        Integer d1dia,d1mes,d1ano;
        d1dia = 1;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);
        LocalDate end = d1.withDayOfMonth(d1.lengthOfMonth());

        resposta = principal.ultDiaMes(end);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraQuantosDiaMes() {



        String resposta;
        Integer d1mes,d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1mes = startMenu.readInt(           "                                       * *       Introduza o mês da data:                                                        * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        LocalDate d1 = LocalDate.of(d1ano,d1mes,1);

        resposta = principal.qntsDiasMes(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }

    private static void calculadoraPrimeiroDiaAno() {


        String resposta;
        Integer d1dia,d1mes,d1ano;
        d1dia = 1;
        d1mes = 1;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);

        resposta = principal.primDiaAno(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraUltimoDiaAno() {


        String resposta;
        Integer d1dia=1,d1mes=1,d1ano;
        clearScreen();
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        d1ano = startMenu.readInt(           "                                       * *       Introduza o ano da data:                                                        * *");
        System.out.println(                       "                                       * *                         A Data Foi Introduzida Com Sucesso                            * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        LocalDate d1 = LocalDate.of(d1ano,d1mes,d1dia);

        resposta = principal.ultDiaAno(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void fusoTempoAtual() {
        // falta verificar se a  opção é válida
        String local;
        clearScreen();
        ZonedDateTime zdt;
        System.out.println("                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("                                       * *                                                                                       * *");
        local = startMenu.readString("                                       * *       Introduza a Zona:                                                               * *");
        System.out.println("                                       * *                                                                                       * *");
        System.out.println("                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        while (fusos.validTimeZone(local) == false) {
            System.out.println("  \n\n                                     * *          >>>>>          A zona inserida é inválida      <<<<<<                * *");
            local = startMenu.readString("                                     * *       Introduza uma Zona Válida:                                              * *");

        }

        System.out.println(local);
        System.out.println("> Valor Introduzido!\n");

        zdt = fusos.tempoAtual(local);
        System.out.println("O tempo atual é : " + zdt);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void fusoDiferenca2Tempos() {

        int d1dia, d1mes, d1ano, d2dia, d2mes, d2ano;
        int hora1 , segundos1 , minuto1 , hora2 , segundos2 , minuto2;
        String local1 , local2;

        d1dia = startMenu.readInt("                                       * *       Introduza o dia da data 1:                                         * *");
        System.out.println("> Valor Introduzido!\n");
        d1mes = startMenu.readInt("                                       * *       Introduza o mês da data 1:                                   * *");
        System.out.println("> Valor Introduzido!\n");
        d1ano = startMenu.readInt("                                       * *       Introduza o ano da data 1 :                                    * * ");

        hora1 = startMenu.readInt("                                       * *       Introduza as horas da hora 1:                                         * *");
        System.out.println("> Valor Introduzido!\n");
        minuto1 = startMenu.readInt("                                       * *       Introduza os minutos da data 1:                                         * *");
        System.out.println("> Valor Introduzido!\n");
        segundos1 = startMenu.readInt("                                       * *       Introduza os segundos da data 1:                                         * *");
        System.out.println("> Valor Introduzido!\n");

        System.out.println("\n\n");
        local1 = startMenu.readString("                                    * *       Introduza a Zona 1:                                                               * *");

        while (fusos.validTimeZone(local1) == false) {
            System.out.println("  \n\n                                     * *          >>>>>          A zona inserida é inválida      <<<<<<                * *");
            local1 = startMenu.readString("                                     * *       Introduza uma Zona Válida:                                              * *");

        }

        System.out.println("> Valor Introduzido!\n");
        System.out.println(">>>> DATA, HORA E ZONA 1 INTRODUZIDAS COM SUCESSO!\n");



        d2dia = startMenu.readInt("                                       * *       Introduza o dia da data 2:                                         * *");
        System.out.println("> Valor Introduzido!\n");
        d2mes = startMenu.readInt("                                       * *       Introduza o dia da data 2:                                         * *");
        System.out.println("> Valor Introduzido!\n");
        d2ano = startMenu.readInt("                                       * *       Introduza o dia da data 2:                                         * *");
        System.out.println("> Valor Introduzido!\n");

        hora2 = startMenu.readInt("                                       * *       Introduza as horas da hora 2:                                         * *");
        System.out.println("> Valor Introduzido!\n");
        minuto2 = startMenu.readInt("                                       * *       Introduza as minutos da hora 2:                                         * *");
        System.out.println("> Valor Introduzido!\n");
        segundos2 = startMenu.readInt("                                       * *       Introduza as segundos da hora 2:                                         * *");
        System.out.println("> Valor Introduzido!\n");


        System.out.println("\n\n");
        local2 = startMenu.readString("                                    * *       Introduza a Zona 2:                                                               * *");

        while (fusos.validTimeZone(local2) == false) {
            System.out.println("  \n\n                                     * *          >>>>>          A zona inserida é inválida      <<<<<<                * *");
            local2 = startMenu.readString("                                     * *       Introduza uma Zona Válida:                                              * *");

        }

        System.out.println("> Valor Introduzido!\n");
        System.out.println(">>>> DATA,HORA E ZONA 2 INTRODUZIDAS COM SUCESSO!\n\n\n");


        LocalDateTime date1 = LocalDateTime.of(d1ano,d1mes,d1dia,hora1,minuto1,segundos1);
        LocalDateTime date2 = LocalDateTime.of(d2ano,d2mes,d2dia,hora2,minuto2,segundos2);

        Duration dura = fusos.duracaoViagem(date1,local1,date2,local2);

        System.out.println("A duração de viagem é de :  " + dura);

        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }

    }





// função para limpar o ecra
    private static void clearScreen(){
        for (int i=0;i<=20;i++){
            System.out.println("\n");
        }
    }



}
