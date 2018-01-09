/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Interfaces.ITestes;
import Modulos.Caixa;
import static Modulos.Caixa.transPorData;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Bandolero
 */
public class Teste11 implements ITestes {
   private final List<TransCaixa> ltc;
    
    public Teste11(List<TransCaixa> ltc){
        this.ltc = ltc;
    }
    
    @Override
    public void execute() {
        
        System.out.println("JAVA 9");
        
        /**
         * TESTE 1
         */
        
        System.out.println("TESTE 1\n");
        
        //STREAM SEQUENCIAL
        Supplier<Double> supplier1 = () -> ltc.stream().mapToDouble(l->l.getValor()).sum();
        SimpleEntry<Double,Double> result1 = Utilidades.testeBoxGenW(supplier1);
        System.out.println("Tempo DoubleStream Sequencial: " + result1.getKey() + "\n" +
                           "Resultado soma: " + result1.getValue() +"\n\n");
        
        //STREAM PARALELO
        Supplier<Double> supplier2 = () -> ltc.parallelStream().mapToDouble(l->l.getValor()).sum();
        SimpleEntry<Double,Double> result2 = Utilidades.testeBoxGenW(supplier2);
        System.out.println("Tempo DoubleStream Paralelo: " + result2.getKey() + "\n" +
                           "Resultado soma: " + result2.getValue() +"\n\n");
        
        /**
         * TESTE 2
         */
        
        System.out.println("TESTE 2\n");
        
        List<TransCaixa> listaOrd = ltc.stream()
            .sorted(transPorData)
            .collect(toList());
    
        int vintep100 = ltc.size() / 5 ;
        
        // STREAM SEQUENCIAL
        Supplier<List<List<TransCaixa>>> listSup = () -> selec2listas(listaOrd, vintep100);
        SimpleEntry<Double,List<List<TransCaixa>>>  reslist = Utilidades.testeBoxGenW(listSup);
        System.out.println("Tempo List S.Sequencial : " + reslist.getKey() + "\n\n");
    
    
        // STREAM PARELELO
        Supplier<List<List<TransCaixa>>> listSuppar = () -> selec2listasparalelas(listaOrd, vintep100);
        SimpleEntry<Double,List<List<TransCaixa>>>  reslistpar = Utilidades.testeBoxGenW(listSuppar);
        System.out.println("Tempo List S.Paralela : " + reslistpar.getKey() + "\n\n");
    
        
        
        
        
        
        /**
         * TESTE 5
         */
        System.out.println("TESTE 5\n");
        
        
        
        Supplier<List<TransCaixa>> listcomp = () -> listaComparador(ltc);
        SimpleEntry<Double, List<TransCaixa>> simplist = Utilidades.testeBoxGenW(listcomp);
        System.out.println("Tempo List com Comparator : " + simplist.getKey()+"\n\n");
         
         
         
         
         /**
          * TESTE 8
          */
        System.out.println("TESTE 8\n");
         
         
        Supplier<String> sup = () -> ltc.stream().filter(t -> t.getData().getHour() > 15 && t.getData().getHour() < 21)
                                          .max((t1, t2) -> Double.compare(t1.getValor(), t2.getValor())).get().getTrans();
        SimpleEntry<Double,String> result = Utilidades.testeBoxGenW(sup);
        System.out.println("Tempo : " + result.getKey() + "  Código :  " + result.getValue());
        
        
        
        
    }
    
    
    
    private List<List<TransCaixa>> selec2listas(List<TransCaixa> listaOrd, int vintep100){
      List<TransCaixa> prim20 = listaOrd.stream()
              .limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
      List<TransCaixa> ult20 = listaOrd.stream()
              .sorted(Caixa.transPorData2).limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
     
      
      List<List<TransCaixa>> result = new ArrayList<>();
      result.add(prim20);
      result.add(ult20);
      
      return result;
    }
    
    private List<List<TransCaixa>> selec2listasparalelas(List<TransCaixa> listaOrd , int vintep100){
      List<TransCaixa> prim20 = listaOrd.parallelStream()
              .limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
      List<TransCaixa> ult20 = listaOrd.parallelStream()
              .sorted(Caixa.transPorData2).limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
      
      List<List<TransCaixa>> result = new ArrayList<>();
      result.add(prim20);
      result.add(ult20);
      
      return result; 
    }
    
    List<TransCaixa> listaComparador(List<TransCaixa> ltc){
        return ltc.stream()
                  .sorted(Caixa.transPorData).collect(toList());
    }
    
}
