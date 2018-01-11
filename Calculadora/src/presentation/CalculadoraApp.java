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
    
    Resposta principal;
    RelogioUser rel;
    Fusos fusos;
    Cronometro cron;
    
    

    private Menu startMenu, cronometroMenu, 
            duracaoMenu, calculadoraMenu, 
            uteisMenu, adicionaRemoveMenu, 
            diaXMenu, diamesMenu, 
            diaanoMenu, fusoshMenu;


    public CalculadoraApp(Resposta principal, RelogioUser rel, Fusos fusos,Cronometro cron) {
        this.principal = principal;
        this.rel = rel;
        this.fusos = fusos;
        this.cron = cron;
        carregarMenus(principal,rel);
        printMenuPrincipal(principal,rel,fusos,cron);
    }
    



    private void carregarMenus(Resposta principal, RelogioUser rel) {
        
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



    private void printMenuPrincipal(Resposta principal, RelogioUser rel, Fusos fusos,Cronometro cron) {
        int op;

        do{
            op = startMenu.showMenu();
            switch (op){
                case 1:
                    clearScreen();
                    printCalculadoraMenu(principal);
                    break;

                case 2:
                    clearScreen();
                    printDiaMesMenu(principal);
                    break;

                case 3:
                    clearScreen();
                    printDiaAnoMenu(principal);
                    break;

                case 4:
                    clearScreen();
                    printAdicionaRemoveMenu(principal);
                    break;

                case 5:
                    clearScreen();
                    printFusosHorariosMenu(fusos);
                    break;

                case 6:
                    clearScreen();
                    printCronometroMenu(cron);
                    break;

            }
        } while (op != 0);
    }

    private void printCronometroMenu(Cronometro cron) {
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

    private void printCalculadoraMenu(Resposta principal) {
        int op;
        do {
            op = calculadoraMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    printDuracaoMenu(principal);
                    break;

                case 2:
                    clearScreen();
                    calculadoraDiasSemana(principal);
                    break;

                case 3:
                    clearScreen();
                    calculadoraSemanaCalendario(principal);
                    break;

                case 4:
                    clearScreen();
                    printDiasUteisMenu(principal);
                    break;

                case 5:
                    clearScreen();
                    printdiaXMenu(principal);
                    break;
                    
                case 6:
                    clearScreen();
                    calculadoraDiaEspecifico(principal);
                    break;
                
                case 7:
                    clearScreen();
                    printFimDeSemana(principal);
                    break;
                    
                case 8:
                    clearScreen();
                    printDiasNUteis(principal);
                    break;
                
                case 9:
                    clearScreen();
                    printFeriados(principal);
                    break;
            }
        } while (op != 0);
    }


    private void printDuracaoMenu(Resposta principal) {
        int op;
        do {
            op = duracaoMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraDuracao(principal);
                    break;

                case 2:
                    clearScreen();
                    calculadoraTempoFalta(principal);
                    break;
            }
        } while (op != 0);
    }




    private void printDiasUteisMenu(Resposta principal) {
        int op;
        do {
            op = uteisMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraDiasUteisEntreDatas(principal);
                    break;

                case 2:
                    clearScreen();
                    calculadoraDiasUteisApos(principal);
                    break;

                case 3:
                    clearScreen();
                    calculadoraDiasUteisAntes(principal);
                    break;                
            }
        } while (op != 0);
    }


    private void printAdicionaRemoveMenu(Resposta principal) {
        int op;
        do {
            op = adicionaRemoveMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraAdiciona(principal);
                    break;

                case 2:
                    clearScreen();
                    calculadoraRemove(principal);
                    break;
            }
        } while (op != 0);
    }



    private void printdiaXMenu(Resposta principal) {
        int op;
        do {
            op = diaXMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraDataXDia(principal);
                    break;

                case 2:
                    clearScreen();
                    calculadoraSemanaXDia(principal);
                    break;

                case 3:
                    clearScreen();
                    calculadoraXDiaData(principal);
                    break;
            }
        } while (op != 0);
    }



    private void printDiaMesMenu(Resposta principal) {
        int op;
        do {
            op = diamesMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraPrimeiroDiaMes(principal);
                    break;

                case 2:
                    clearScreen();
                    calculadoraUltimoDiaMes(principal);
                    break;

                case 3:
                    clearScreen();
                    calculadoraQuantosDiaMes(principal);
                    break;
            }
        } while (op != 0);
    }


    private void printDiaAnoMenu(Resposta principal) {
        int op;
        do {
            op = diaanoMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    calculadoraPrimeiroDiaAno(principal);
                    break;

                case 2:
                    clearScreen();
                    calculadoraUltimoDiaAno(principal);
                    break;

                case 3:
                    clearScreen();
                    calculadoraComumBissexto(principal);
                    break;
            }
        } while (op != 0);
    }


    private void printFusosHorariosMenu(Fusos fusos) {
        int op;
        do {
            op = fusoshMenu.showMenu();
            switch (op) {
                case 1:
                    clearScreen();
                    fusoDiferenca2Tempos(fusos);
                    break;

                case 2:
                    clearScreen();
                    fusoTempoAtual(fusos);
                    break;
            }
        } while (op != 0);
    }







    private void calculadoraDuracao(Resposta principal) {

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



    private void calculadoraTempoFalta(Resposta principal) {
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

    private void calculadoraDiasSemana(Resposta principal)  {
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

    private void calculadoraComumBissexto(Resposta principal){
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

    private void calculadoraSemanaCalendario(Resposta principal) {
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

    private void calculadoraDiasUteisEntreDatas(Resposta principal) {
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
    private void printDiasNUteis(Resposta principal) {
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
    
    
    
    
    private void printFimDeSemana(Resposta principal) {
        
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
    
    private void printFeriados(Resposta principal) {
        
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
    private void calculadoraDiaEspecifico(Resposta principal){
        
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

    private void calculadoraDiasUteisApos(Resposta principal) {
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


    private void calculadoraDiasUteisAntes(Resposta principal) {
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



    private void calculadoraAdiciona(Resposta principal) {
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




    private void calculadoraRemove(Resposta principal) {



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


    private void calculadoraDataXDia(Resposta principal) {


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


    private void calculadoraXDiaData(Resposta principal){


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


    private void calculadoraSemanaXDia(Resposta principal) {

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
    

    private void calculadoraPrimeiroDiaMes(Resposta principal) {


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


    private void calculadoraUltimoDiaMes(Resposta principal) {


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


    private void calculadoraQuantosDiaMes(Resposta principal) {

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

    private void calculadoraPrimeiroDiaAno(Resposta principal) {

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


    private void calculadoraUltimoDiaAno(Resposta principal) {


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


    private void fusoTempoAtual(Fusos fusos) {
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


    private void fusoDiferenca2Tempos(Fusos fusos) {

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
    private void clearScreen(){
        for (int i=0;i<=20;i++){
            System.out.println("\n");
        }
    }



}
