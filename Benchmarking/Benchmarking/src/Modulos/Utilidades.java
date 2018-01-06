package Modulos;

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
import Modulos.Caixa;
import static java.lang.System.out;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;


public class Utilidades {
    
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
    
   
    public static List<TransCaixa> setup(String nomeFich) {
      List<TransCaixa> ltc = new ArrayList<>();
      
      try (Stream<String> sTrans = Files.lines(Paths.get(nomeFich))) {
            ltc = sTrans.map(linha -> Caixa.strToTransCaixa(linha)).collect(toList());
      } 
      catch(IOException exc) {
            out.println(exc.getMessage()); 
      }
      
      return ltc;
    }
    
    public static List<TransCaixa> setupN(String nomeFich) {
      List<String> lines = new ArrayList<>();
      try { 
          lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); 
      }
      catch(IOException exc) { 
          System.out.println(exc.getMessage()); 
      }
      
      List<TransCaixa> lTrans = new ArrayList<>();
      lines.forEach(line -> lTrans.add(Caixa.strToTransCaixa(line)));
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
        for(int i = 1 ; i <= 3; i++) 
            supplier.get();
        
        System.gc();
        Crono.start();
        R resultado = supplier.get();
        Double tempo = Crono.stop();
        return new SimpleEntry<Double,R>(tempo, resultado);
    }

} 
