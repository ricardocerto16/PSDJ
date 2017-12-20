package presentation;


import business.Resposta;
import business.RelogioUser;
import business.Fusos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Set;


public class CalculadoraApp {

    private static Resposta principal;
    private static RelogioUser rel;
    private static Fusos fusos;
    private static Menu startMenu, duracaoMenu, calculadoraMenu, uteisMenu, adicionaRemoveMenu, diaXMenu, diamesMenu, diaanoMenu, fusoshMenu;


    private CalculadoraApp() {}

    public static void main (String [] args) {
        principal = new Resposta();
        rel = new RelogioUser();
        fusos = new Fusos();
        carregarMenus();
        printMenuPrincipal();
    }



    private static void carregarMenus() {
        String fuso = rel.getFuso();
        String offset = principal.normalizarOffset(rel.getOffSet());
        String diasemana = principal.normalizarSemana(rel.getDiaSemana());
        String dia = principal.normalizarTempo(rel.getDia());
        String mes = principal.normalizarMes(rel.getMes());
        String ano = String.valueOf(rel.getAno());

        String hora = principal.normalizarTempo(rel.getHora());
        String minuto = principal.normalizarTempo(rel.getMinuto());

        String data = principal.normalizarData(diasemana+",  "+dia+"  "+mes+"  "+ano);
        String zona = principal.normalizarFuso(fuso+offset);





        // NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER NAO MEXER
        // TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO TA DIREITO
        String [] start= {
                "                                       * *                                                  "+data+" * *",
                "                                       * *     ______    _                                                                       * *",
                "                                       * *    /_  __/   (_)   ____ ___   ___                          "+hora+"H : "+minuto+"m                  * *",
                "                                       * *     / /     / /   / __ `__ \\ / _ \\                                                    * *",
                "                                       * *    / /     / /   / / / / / //  __/          "+zona+"    * *",
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
                "                                                 * *                    2 - DATA E HORA EM ...                         * *",
                "                                                 * *                    3 - DIA DO MÊS                                 * *",
                "                                                 * *                    4 - DIA DO ANO                                 * *",
                "                                                 * *                    5 - ADICIONAR/SUBTRAIR DE UMA DATA             * *",
                "                                                 * *                    6 - FUSOS HORÁRIOS                             * *",
                "                                                 * *                    7 - DURAÇÃO DE UMA VIAGEM                      * *",
                "                                                 * *                    8 - AJUDA !                                    * *",

        };



        String [] calculadora = {
                "                                       * *                                                                                       * *",
                "                                       * *                            1 - CALCULADORA ENTRE DUAS DATAS                           * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - CALCULADORA DOS DIAS DA SEMANA                         * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            3 - CALCULADORA DA SEMANA DE CALENDÁRIO                    * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            4 - CALCULADORA DIAS ÚTEIS                                 * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            5 - CALCULADORA DO Xº DIA                                  * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            0 - VOLTAR À PÁGINA INICIAL                                * *",
                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
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
                "                                       * *                            1 - TEMPO DE UMA VIAGEM                                    * *",
                "                                       * *                                                                                       * *",
                "                                       * *                            2 - TEMPO ATUAL NUMA ZONA                                  * *",
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

                    calculadoraDataHoraEm();
                    carregarMenus();

                    break;

                case 3:
                    clearScreen();
                    printDiaMesMenu();
                    break;

                case 4:
                    clearScreen();
                    printDiaAnoMenu();
                    break;

                case 5:
                    clearScreen();
                    printAdicionaRemoveMenu();
                    break;

                case 6:
                    clearScreen();
                    printFusosHorariosMenu();
                    break;

                case 7:
                    clearScreen();
                    //DURAÇÃO DE UMA VIAGEM sld 2-> 22++
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
                    //calculadoraPrimeiroDiaAno();
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
        //Remover a uma data, se não quiser remover um dos valores, meter 0;


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
        //dizer qual a data do xº dia do ano (1-> sld18);

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
        //dizer qual o xº dia do ano de uma dada data(1-> sld19);

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
        //dizer qual a semana do xº dia do ano (2-> sld6); ?fazer calculadora de todos os dias da semana, p exempl, listar as datas de todas as segundas feiras ?

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




    private static void calculadoraDataHoraEm() {
        //dado um pais, dizer a data e hora nesse país

        String resposta,pais, pais_resposta;
        Set<String>  zones = ZoneId.getAvailableZoneIds();



        clearScreen();
        System.out.println(                                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                                "                                       * *                                                                                       * *");

        pais = startMenu.readString(                  "                                       * *       Introduza o país para o qual deseja saber a data e hora locais:                 * *");

        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pais);
        java.util.regex.Matcher m = p.matcher(", ");
        ArrayList<String> als = new ArrayList<>();
        for(String s : zones)
        {
            m.reset(s);
            if(m.find()){
                als.add(s);
                System.out.println(s);
            }
        }
        while(als.isEmpty()){
            pais = startMenu.readString(              "                                       * *       Este País Não Existe, Insira Novamente:                                         * *");

            java.util.regex.Pattern pp = java.util.regex.Pattern.compile(pais);
            java.util.regex.Matcher mm = pp.matcher(", ");
            ArrayList<String> alsp = new ArrayList<>();
            for(String s : zones)
            {
                mm.reset(s);
                if(mm.find()){
                    alsp.add(s);
                    System.out.println(s);
                }
            }
            als = alsp;
        }


        pais_resposta = startMenu.readString(         "                                       * *       Entre Esta Lista de Países Apresentada, Escolha Um:                             * *");
        while(!als.contains(pais_resposta)){
            System.out.println("\n> O Valor Introduzido Não É Válido!\n");
            pais_resposta = startMenu.readString(     "                                       * *       Entre Esta Lista de Países Apresentada, Escolha Um:                             * *");
        }

        System.out.println("> Valor Introduzido!\n");
        System.out.println(                                "                                       * *                         O País Foi Introduzido Com Sucesso                            * *");
        System.out.println(                                "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                                "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");


        resposta = principal.dataHoraEm(pais_resposta);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }



    private static void calculadoraPrimeiroDiaMes() {
        //data do primeiro dia de um dado mes (2 -> sld 31); retornar também o dia da semana

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

        resposta = principal.primDiaMes(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraUltimoDiaMes() {
        //data do ultimo dia de um dado mes (2 -> sld 31); retornar também o dia da semana

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

        resposta = principal.ultDiaMes(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraQuantosDiaMes() {
        //quantos dias tem um dado mês ? ir ao UltimoDiaMes e ir buscar o valor do dia


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
        //data do primeiro dia de um dado ano (2 -> sld 31); retornar também o dia da semana

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

        resposta = principal.primDiaAno(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void calculadoraUltimoDiaAno() {
        //data do ultimo dia de um dado ano (2 -> sld 31); retornar também o dia da semana

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

        resposta = principal.ultDiaAno(d1);
        System.out.println(resposta);


        System.out.println("Pressione Enter Para Continuar");
        while (!startMenu.readString("").equals("")) {
            System.out.println("Pressione Enter Para Continuar");
        }
    }


    private static void fusoTempoAtual(){

        String local;
        clearScreen();
        ZonedDateTime zdt;
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                       * *                                                                                       * *");
        local = startMenu.readString(           "                                    * *       Introduza a Zona:                                                               * *");
        System.out.println("> Valor Introduzido!\n");
        System.out.println(                       "                                       * *                         A Zona Foi Introduzida Com Sucesso                             * *");
        System.out.println(                       "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(                       "                                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *              \n");

        System.out.println(local);

        zdt = fusos.tempoAtual(local);
        StringBuilder sb;
        sb = new StringBuilder();
        //sb.append("O tempo atual ").append(local).append(" é o seguinte  ").append(zdt);
        System.out.println(zdt);


    }


    private static void clearScreen(){
        for (int i=0;i<=20;i++){
            System.out.println("\n");
        }
    }




}
