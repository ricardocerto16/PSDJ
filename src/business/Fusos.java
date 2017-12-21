package business;

import interfaces.IFusos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Fusos implements IFusos {


    public Fusos(){

    }

    public Duration diferencaFusos(LocalDateTime inicio , String zonainicial , LocalDateTime fim , String zonafinal){

        ZoneId id_inicio = ZoneId.of(zonainicial);
        ZoneId id_final = ZoneId.of(zonafinal);
        ZonedDateTime tempoinicio = inicio.atZone(id_inicio);
        ZonedDateTime tempofinal = inicio.atZone(id_final);

        Duration duracao = Duration.between(tempoinicio,tempofinal);
        return duracao;
    }


    public ZonedDateTime tempoAtual(String local) {

        LocalDateTime agora = LocalDateTime.now();
        ZoneId id_local = ZoneId.of(local);
        ZonedDateTime local_dt = agora.atZone(id_local);
        return local_dt;
    }



}

