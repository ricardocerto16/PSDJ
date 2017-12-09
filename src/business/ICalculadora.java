package business;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface ICalculadora {

    int difDatas(LocalDate from, LocalDate to, String tipo);

    int tempoFalta(String tipo, LocalDateTime data);

    String diaSemana(LocalDate data);

    int comumBissexto(LocalDate data);

    int semanaCalendario(LocalDate data);

    int uteisEntreDatas(LocalDate from, LocalDate to);

    LocalDate uteisAposData(LocalDate data, int uteis);

    LocalDate uteisAntesData(LocalDate data, int uteis);

    LocalDate adicionaData(LocalDate data, int adddia, int addsemana, int addmes, int addano);

    LocalDate removeData(LocalDate data, int rmdia, int rmsemana, int rmmes, int rmano);

    LocalDate dataXDia(int dia, int ano);

    int xDiaData(LocalDate data);

    String semanaXDia(int dia, int ano);

    LocalDate primDiaMes(LocalDate data);

    LocalDate ultDiaMes(LocalDate data);

    int qntsDiasMes(LocalDate data);

    LocalDate primDiaAno(LocalDate data);

    LocalDate ultDiaAno(LocalDate data);

    String getSemana(String zone);

    String getDia(String zone);

    String getMes(String zone);

    String getAno(String zone);

    String getHora(String zone);

    String getMinuto(String zone);


}
