/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Modulos.TransCaixa;
import Modulos.Utilidades;

import Interfaces.ITestes;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;
/**
 *
 * @author Ricardo
 */
public class Teste1 implements ITestes {
    private List<TransCaixa> ltc;
    
    public Teste1(List<TransCaixa> ltc){
        this.ltc = ltc;
    }
    
    
    @Override
    public void execute(){
        
        /**
         *  DOUBLE ARRAY
         */
        double[] array = listToArray(ltc);
        
        //Ciclo for()
        Supplier<Double> supplier1 = () -> forArray(array);
        SimpleEntry<Double,Double> result1 = Utilidades.testeBoxGenW(supplier1);
        System.out.println("Tempo double[] for(): " + result1.getKey() + "\n" + 
                           "Resultado soma: " + result1.getValue());
        
        
        //Ciclo forEach()
        Supplier<Double> supplier2 = () -> forEachArray(array);
        SimpleEntry<Double,Double> result2 = Utilidades.testeBoxGenW(supplier2);
        System.out.println("Tempo double[] forEach(): " + result2.getKey() + "\n" + 
                           "Resultado soma: " + result2.getValue());
        
        
        
        /**
         * STREAM SEQUENCIAL
         */
        
        //DoubleStream
        Supplier<Double> supplier3 = () -> ltc.stream().mapToDouble(l->l.getValor()).sum();
        SimpleEntry<Double,Double> result3 = Utilidades.testeBoxGenW(supplier3);
        System.out.println("Tempo DoubleStream Sequencial: " + result3.getKey() + "\n"+
                           "Resultado soma: " + result3.getValue());
        
        //Stream<Double>
        //Supplier<Double> supplier3 = () -> ltc.stream().map(l->l.getValor()).
        
        /**
         * STREAM PARALELO
         */
        
        //DoubleStream
        
        //Stream<Double>
                
    }
   
    private double[] listToArray(List<TransCaixa> ltc){
        int i = 0;
        double[] transCaixa = new double[ltc.size()];
        
        for(TransCaixa t: ltc){
            transCaixa[i] = t.getValor();
            i++;
        }
        
        return transCaixa;
    }
    
    
    private double forArray(double[] array){
        int i;
        double total = 0;
    
        for(i=0;i<array.length;i++)
                total += array[i];
        
        return total;
    }
    
    
    private double forEachArray(double[] array){
        double total = 0;
        
        for(double d : array){
            total += d;
        }
        
        return total;
    }
}
