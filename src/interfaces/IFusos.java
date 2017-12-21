package interfaces;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public interface IFusos {

    public Duration duracaoViagem(LocalDateTime inicio , String zonainicial , LocalDateTime fim , String zonafinal);

    public ZonedDateTime tempoAtual(String local);


}
