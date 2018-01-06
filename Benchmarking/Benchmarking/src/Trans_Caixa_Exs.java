/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ricardo
 */
/**
 *
 * @author asus
 */

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalQueries;
import static java.time.temporal.TemporalQueries.chronology;
import static java.time.temporal.TemporalQueries.localDate;
import static java.time.temporal.TemporalQueries.localTime;
import static java.time.temporal.TemporalQueries.offset;
import static java.time.temporal.TemporalQueries.precision;
import static java.time.temporal.TemporalQueries.zone; 
import static java.time.temporal.TemporalQueries.zoneId; 
import static java.time.temporal.ChronoUnit.NANOS;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import java.time.*;
import static java.lang.System.out;
import java.util.Random;
import java.util.stream.*;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.Collection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.counting;
import static java.util.Comparator.comparing;
import java.util.*;
import java.util.DoubleSummaryStatistics;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
import java.lang.System.*;
import java.nio.charset.StandardCharsets;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.*;


public class Trans_Caixa_Exs {
    
    public static void memoryUsage() {
		final int mByte = 1024*1024;
		// Parâmetros de RunTime
		Runtime runtime = Runtime.getRuntime();
		out.println("== Valores de Utilização da HEAP [MB] ==");
		out.println("Memória Máxima RT:" + runtime.maxMemory()/mByte);
		out.println("Total Memory:" + runtime.totalMemory()/mByte);
		out.println("Memória Livre:" + runtime.freeMemory()/mByte);
		out.println("Memoria Usada:" + (runtime.totalMemory() - runtime.freeMemory())/mByte);	
    }
    
    public static TransCaixa strToTransCaixa(String linha) {
       //
       double preco = 0.0; 
       int ano = 0; int mes = 0; int dia = 0; 
       int hora = 0; int min = 0; int seg = 0;
       String codTrans, codCaixa;
       // split()
       String[] campos = linha.split("/");
       codTrans = campos[0].trim();
       codCaixa = campos[1].trim();
       try {
             preco = Double.parseDouble(campos[2]); 
       }
       catch(InputMismatchException | NumberFormatException e) { return null; }        
       String[] diaMesAnoHMS = campos[3].split("T");
       String[] diaMesAno = diaMesAnoHMS[0].split(":");
       String[] horasMin = diaMesAnoHMS[1].split(":");
       try {
             dia = Integer.parseInt(diaMesAno[0]);
             mes = Integer.parseInt(diaMesAno[1]);
             ano = Integer.parseInt(diaMesAno[2]);
             hora = Integer.parseInt(horasMin[0]);
             min = Integer.parseInt(horasMin[1]);
       }
       catch(InputMismatchException | NumberFormatException e) { return null; }
       return TransCaixa.of(codTrans, codCaixa, preco, LocalDateTime.of(ano, mes, dia, hora, min, 0));    
    }
   
    public static List<TransCaixa> setup(String nomeFich) {
      List<TransCaixa> ltc = new ArrayList<>();
      try (Stream<String> sTrans = Files.lines(Paths.get(nomeFich))) {
               ltc = sTrans.map(linha -> strToTransCaixa(linha)).collect(toList());
      } 
      catch(IOException exc) { out.println(exc.getMessage()); } 
      return ltc;
    }
    
    public static List<TransCaixa> setup1(String nomeFich) {
      List<String> lines = new ArrayList<>();
      try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
      catch(IOException exc) { System.out.println(exc.getMessage()); }
      // List<String> -> List<TransCaixa>
      List<TransCaixa> lTrans = new ArrayList<>();
      lines.forEach(line -> lTrans.add(strToTransCaixa(line)));
      return lTrans;
    }
    
    public static <R> SimpleEntry<Double,R> testeBoxGen(Supplier<? extends R> supplier) {
        Crono.start();
        R resultado = supplier.get();
        Double tempo = Crono.stop();
        return new SimpleEntry<Double,R>(tempo, resultado);
    }
    
    public static <R> SimpleEntry<Double,R> testeBoxGenW(Supplier<? extends R> supplier) {
        // warmup
        for(int i = 1 ; i <= 3; i++) supplier.get();
        System.gc();
        Crono.start();
        R resultado = supplier.get();
        Double tempo = Crono.stop();
        return new SimpleEntry<Double,R>(tempo, resultado);
     }
    
    
    public static DayOfWeek diaDaSemana(TemporalAccessor tacs){
            try{
               LocalDate dataRef = LocalDate.from(tacs);
            }
            catch(DateTimeException e){
                   return null;
            }
          return DayOfWeek.of(tacs.get(DAY_OF_WEEK));
       }
     
     public static Long parseSegundos(TemporalAccessor tacs) {
             LocalDateTime dataRef = null;
             try {
                 dataRef = LocalDateTime.from(tacs);
             } catch (DateTimeException e) {
                return null;}
        return dataRef.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
         }
    
    public static void main(String[] args) {
        
        String nomeFich = "transCaixa1M.txt";
        List<TransCaixa> ltc = new ArrayList<>();
        
        // LE O FICHEIRO DE TRANSACÇOES PARA List<TransCaixa> sem Streams 
        Crono.start();
        ltc = setup1(nomeFich);
        out.println("Setup com List<String>: " + Crono.stop()*1000 + " ms");
        out.println("Transacções lidas Lists: " + ltc.size());
        ltc.clear();
       
        // LE O FICHEIRO DE TRANSACÇOES PARA List<TransCaixa> com Streams
        Crono.start();
        ltc = setup(nomeFich);
        out.println("Setup com Streams: " + Crono.stop()*1000 + " ms");
        out.println("Transacções lidas (Streams): " + ltc.size());
        memoryUsage();
      
        // EXERCICIOS
        
        // Número de transações igual a 0?
        Crono.start();
        boolean nzeros = ltc.stream().anyMatch(t -> t.getValor() == 0.0);
        out.println("Teste X: " + Crono.stop()*1000 + " Boleano " + nzeros);
        
        //Número total de caixas que registam transações.Nº da 1 linha e
        //da última
        Crono.start();
        List<Integer> caixas1 = ltc.stream().map(t -> Integer.valueOf(t.getCaixa()))
                .distinct().sorted((i1,i2) -> i1.compareTo(i2))
                .collect(toList());
        out.println("Caixas size: " + caixas1.size());
        out.println("Caixas: " + caixas1.get(0) + " a " + caixas1.get(caixas1.size()-1));
    
    
        
        // Obter dados estatísticos sobre os valores das transações
        DoubleSummaryStatistics stats1 = ltc.stream()
                                        .mapToDouble(TransCaixa :: getValor)
                                        .summaryStatistics();
        
        DoubleSummaryStatistics stats2 = ltc.stream()
                                       .collect(summarizingDouble(TransCaixa :: getValor));
    
    
        // Número de transações de valor entre valMin e valMax([valMin,valMax])
        // Generalizar a soulução usando funções
        
        Function<Double, Predicate<TransCaixa>> valTransMaiorQue = val -> t -> t.getValor() >= val;
        Function<Double, Predicate<TransCaixa>> valTransMenorQue = val -> t-> t.getValor() <= val;
        BiFunction<Double, Double, Predicate<TransCaixa>> predValTransMaiorOuMenorQue = (val1, val2) -> valTransMaiorQue.apply(val1).and(valTransMenorQue.apply(val2));
        final double valMin = 13.5; final double valMax = 20.0;
        long numTrans = ltc.stream().filter(t->predValTransMaiorOuMenorQue.apply(valMin,valMax).test(t)).count();
        
        
        //Verficar se exsitem códigos de transações em duplicado
        Crono.start();
        List<String> codTrans1 = ltc.stream()
                            .map(TransCaixa :: getTrans)
                            .collect(toList());
      
        List<String> codTrans2 = ltc.stream().distinct().map(TransCaixa :: getTrans).collect(toList());
        out.println("Quantos códigos de transações duplicados existem: " + (codTrans1.size()-codTrans2.size()));
      
            
       Comparator<LocalDate> compMenorData = 
              (LocalDate ld1, LocalDate ld2) -> { if(ld1.equals(ld2)) return 0;
                                                  else if(ld1.isBefore(ld2)) return -1;
				               else return 1 ; 
                                                };
       Comparator<LocalTime> compMenorTime = 
              (LocalTime lt1, LocalTime lt2) -> { if(lt1.equals(lt2)) return 0;
                                                  else if(lt1.isBefore(lt2)) return -1; 
                                                       else return 1 ; 
                                                 };
          
        Comparator<TransCaixa> transPorData = 
             (TransCaixa tc1, TransCaixa tc2) -> { LocalDateTime ldt1 = tc1.getData();
                                                   LocalDateTime ldt2 = tc2.getData();
                                                   if(ldt1.equals(ldt2)) return 0;
                                                   else if(ldt1.isBefore(ldt2)) return -1; 
					       else return 1 ; 
                                                 };

            
            
         //Gama de valores Data/Tempo das transações, ou seja , a primeira e a última do ano
         Crono.start();
         SortedSet<TransCaixa> transOrdData = new TreeSet<>(transPorData);
         transOrdData.addAll(ltc);
         out.println(transOrdData.first() + " - " + transOrdData.last() + " Time Sorted " +Crono.stop()*1000);
         
         
         Crono.start();
         List<TransCaixa> transOrdData2 = 
                ltc.stream().sorted(transPorData)
                .collect(toList());
         out.println(transOrdData2.get(0) + " - " + transOrdData2.get(transOrdData2.size()-1) + " \n " + " Time Streams " + Crono.stop()*1000);
   
         
         
         Supplier<SortedSet<TransCaixa>> supplyTreeSetTcx = () -> new TreeSet<>(transPorData);
         Crono.start();
         SortedSet<TransCaixa> transOrdData3 = ltc.stream().collect(toCollection(supplyTreeSetTcx));
         out.println(transOrdData3.first() + " - " + transOrdData3.last() + "\n Time Supplier " + Crono.stop()*1000 );
         
         
         // Considerando apenas as primeiras 500 transações do ano, determinar a sua distribuição por caixas
         Crono.start();
         Map<String,List<TransCaixa>> primeiras500 = ltc.stream()
                                        .sorted(transPorData)
                                        .limit(500)
                                        .collect(groupingBy(TransCaixa :: getCaixa));
         out.println("primeiras 500 -> " + Crono.stop()* 1000);

         Crono.start();
         Map<String,Long> primeiras500contagem = ltc.stream()
                                                .sorted(transPorData)
                                                .limit(500)
                                                .collect(groupingBy(TransCaixa::getCaixa,TreeMap::new, counting()));
            //primeiras500contagem.forEach( (cx, nt) -> out.println("Caixa: " + cx + " --> " + nt));
        out.println("500 couting ->  " + Crono.stop()*1000);
        
        //total faturado
        Crono.start();
        Map<String,Double> tabCaixaValor = ltc.stream()
                        .collect(groupingBy(TransCaixa :: getCaixa,Collectors.summingDouble(TransCaixa :: getValor)));
        out.println("total faturado -> " + Crono.stop()*1000);
       
        
         //criar um conjunto de pares Caixa-Faturado
         Crono.start();
         Map<String,Double> tabCaixaFact = new HashMap<>();
         List<SimpleEntry<String,Double>> listaCaixaFact = 
                 ltc.stream().map(t -> new SimpleEntry<String,Double> (t.getCaixa(),t.getValor()))
                      .collect(toList());
         tabCaixaFact = listaCaixaFact.stream().collect(groupingBy(p -> p.getKey(), summingDouble(p -> p.getValue())));
         out.println("Time pares Caixa - Faturado ->   " + Crono.stop()*1000);
         
         
         // total faturado por dia da semana
    
    
         
         Map<DayOfWeek, Double> transPorDiaSemana = 
                 ltc.stream()
                  .collect(groupingBy(t -> diaDaSemana(t.getData().toLocalDate()),
                          summingDouble(TransCaixa :: getValor)));
         
         
        Function<TransCaixa, Long> txToSeconds = t -> {
           LocalDateTime lt = t.getData();
           return lt.query(Trans_Caixa_Exs::parseSegundos);
       };
         
    final String numCaixa = "14"; 
    List<Long> temposEmSecsCx = ltc.stream()
                .filter(t -> t.getCaixa().equals(numCaixa))
                .sorted(transPorData)
                .map(t -> txToSeconds.apply(t))
                .collect(toList());  
    }
    
    //List<Long> difsTempo = 
    //        IntStream.range(1,temposEmSecsCx.size())
    //        .mapToObj(i -> new SimpleEntry<Long,Long> (TemposEmSecsCx.get(i-1)))


} 
