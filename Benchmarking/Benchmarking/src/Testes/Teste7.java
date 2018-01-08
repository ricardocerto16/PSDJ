/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Interfaces.ITestes;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.StreamSupport;

/**
 *
 * @author Bandolero
 */
public class Teste7 implements ITestes{
    private final List<TransCaixa> ltc;
    
    public Teste7(List<TransCaixa> ltc){
        this.ltc = ltc;
    }

    @Override
    public void execute() {
             
       /**
        * DATA SET INTEIRO
        */ 
       
        //LIST
        
        Supplier<Double> supplier1 = () -> forEach(ltc);
        SimpleEntry<Double,Double> result1 = Utilidades.testeBoxGenW(supplier1);
        
       
        //STREAM SEQUENCIAL 
        
        Supplier<Double> supplier2 = () -> ltc.stream().mapToDouble(l->l.getValor()).sum();
        SimpleEntry<Double,Double> result2 = Utilidades.testeBoxGenW(supplier2);
        System.out.println("Tempo Data Set Inteiro Stream Sequencial: " + result2.getKey() + "\n" +
                           "Resultado soma: " + result2.getValue() +"\n\n");
        
        //STREAM PARALELA
        
        Supplier<Double> supplier3 = () -> ltc.parallelStream().mapToDouble(l->l.getValor()).sum();
        SimpleEntry<Double,Double> result3 = Utilidades.testeBoxGenW(supplier3);
        System.out.println("Tempo Data Set Inteiro Stream Paralelo: " + result3.getKey() + "\n" +
                           "Resultado soma: " + result3.getValue() +"\n\n");
    
        
       /**
        * DATA SET PARTICIONADO 
        */  
        /**
         * SPLITERATOR
         */
        
        /* Possibilidade 1
        Spliterator.OfDouble splitr1 = DoubleStream.of(ltc.get(0).getValor());
        
        
        //STREAM SEQUENCIAL
        Double d1 = StreamSupport.doubleStream(splitr1, false);
       */
        
        //Possibilidade 2
        /*
        Spliterator<TransCaixa> splitr1=ltc.spliterator();
        Spliterator<TransCaixa> splitr2=splitr1.trySplit();
        Spliterator<TransCaixa> splitr3=splitr1.trySplit();
        Spliterator<TransCaixa> splitr4=splitr2.trySplit();
        
        List<TransCaixa> split1 = new ArrayList<>(); 
        splitr1.forEachRemaining(t-> split1.add(t));
        List<TransCaixa> split2 = new ArrayList<>(); 
        splitr2.forEachRemaining(t-> split2.add(t));
        List<TransCaixa> split3 = new ArrayList<>(); 
        splitr3.forEachRemaining(t-> split3.add(t));
        List<TransCaixa> split4 = new ArrayList<>(); 
        splitr4.forEachRemaining(t-> split4.add(t));
        */
        
        //LIST
        
       
        //STREAM SEQUENCIAL 
        
        //STREAM PARALELA
        
        
        
       
 
    }
    
    private double forEachJoin(List<TransCaixa> sp1, List<TransCaixa> sp2 , List<TransCaixa> sp3, List<TransCaixa> sp4){
        double doub = 0.0;
        
        for(TransCaixa t: sp1){
            doub+=t.getValor();
        }
        for(TransCaixa t: sp2){
            doub+=t.getValor();
        }
        for(TransCaixa t: sp3){
            doub+=t.getValor();
        }
        for(TransCaixa t: sp4){
            doub+=t.getValor();
        }
        
        return doub;
    }
    
    private double forEach(List<TransCaixa> list){
        double doub = 0.0;
        
        for(TransCaixa t: list){
            doub += t.getValor();
        }
 
        return doub;
    }
}
