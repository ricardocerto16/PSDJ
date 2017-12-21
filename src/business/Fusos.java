package business;

import interfaces.IFusos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Fusos implements IFusos {


    public Fusos(){

    }


    public Duration duracaoViagem(LocalDateTime inicio , String zonainicial , LocalDateTime fim , String zonafinal){

        ZoneId id_inicio = ZoneId.of(zonainicial);
        ZoneId id_final = ZoneId.of(zonafinal);

        ZonedDateTime tempoinicio = ZonedDateTime.of(inicio,id_inicio);
        ZonedDateTime tempoiniciolocalfinal = tempoinicio.withZoneSameInstant(id_final);
        ZonedDateTime tempofinal = ZonedDateTime.of(fim, id_final);

        Duration duracao = Duration.between(tempoinicio,tempofinal);
        return duracao;
    }


    public ZonedDateTime tempoAtual(String local) {

        LocalDateTime agora = LocalDateTime.now();
        ZoneId id_local = ZoneId.of(local);
        ZonedDateTime local_dt = agora.atZone(id_local);
        return local_dt;
    }



    /*
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

    */

}

