package interfaces;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public interface IFusos {

    // duracao de uma viagem
    public Duration duracaoViagem(LocalDateTime inicio , String zonainicial , LocalDateTime fim , String zonafinal);

    //tempo atual numa dada zona
    public ZonedDateTime tempoAtual(String local);

    // verifica se uma zona é válida
    public boolean validTimeZone(String id);
}
