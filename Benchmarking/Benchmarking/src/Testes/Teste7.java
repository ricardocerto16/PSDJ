/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Interfaces.ITestes;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
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
        System.out.println("Tempo Data Set Inteiro Lista com forEach: " + result1.getKey() + "\n" +
                           "Resultado soma: " + result1.getValue()+"\n\n");
        
       
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
        * DATA SET PARTICIONADO (4 Partes)
        */  
       
        
       
        //STREAM SEQUENCIAL 
        Supplier<Double> supplier4 = () -> spliteratorSeq();
        SimpleEntry<Double,Double> result4 = Utilidades.testeBoxGenW(supplier4);
        System.out.println("Tempo Data Set Partido Stream Sequencial: " + result4.getKey() + "\n" +
                           "Resultado da Soma: " + result4.getValue());
       
        
        //STREAM PARALELA
        Supplier<Double> supplier5 = () -> spliteratorParalelo();
        SimpleEntry<Double,Double> result5 = Utilidades.testeBoxGenW(supplier5);
        System.out.println("Tempo Data Set Partido Stream Paralelo: " + result5.getKey() + "\n" +
                           "Resultado da Soma: " + result5.getValue());
       
        
 
    }
    
    private double forEach(List<TransCaixa> list){
        double doub = 0.0;
        
        for(TransCaixa t: list){
            doub += t.getValor();
        }
 
        return doub;
    }
    
    
    private double spliteratorSeq(){
        List<Stream<TransCaixa>> listaS = new ArrayList<>();
        double soma = 0.0;
        
        Spliterator<TransCaixa> splitr1 = ltc.spliterator();
        Spliterator<TransCaixa> splitr2 = splitr1.trySplit();
        Spliterator<TransCaixa> splitr3 = splitr1.trySplit();
        Spliterator<TransCaixa> splitr4 = splitr2.trySplit();
        
        listaS.add(StreamSupport.stream(splitr1, false));
        listaS.add(StreamSupport.stream(splitr2, false));
        listaS.add(StreamSupport.stream(splitr3, false));
        listaS.add(StreamSupport.stream(splitr4, false));
        
        for(Stream<TransCaixa> stream : listaS){
            soma += stream.mapToDouble(t->t.getValor()).sum();
        }
    
    
        return soma;
    }
    
    
     private double spliteratorParalelo(){
        List<Stream<TransCaixa>> listaP = new ArrayList<>();
        double soma = 0.0;
        
        Spliterator<TransCaixa> splitr1 = ltc.spliterator();
        Spliterator<TransCaixa> splitr2 = splitr1.trySplit();
        Spliterator<TransCaixa> splitr3 = splitr1.trySplit();
        Spliterator<TransCaixa> splitr4 = splitr2.trySplit();
        
        listaP.add(StreamSupport.stream(splitr1, true));
        listaP.add(StreamSupport.stream(splitr2, true));
        listaP.add(StreamSupport.stream(splitr3, true));
        listaP.add(StreamSupport.stream(splitr4, true));
        
        for(Stream<TransCaixa> stream : listaP){
            soma += stream.mapToDouble(t->t.getValor()).sum();
        }
    
    
        return soma;
    }
}
