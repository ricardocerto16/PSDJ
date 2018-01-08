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

/**
 *
 * @author Ricardo
 */
public class Teste1 implements ITestes {
    private final List<TransCaixa> ltc;
    
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
                           "Resultado soma: " + result1.getValue() +"\n\n");
        
        
        //Ciclo forEach()
        Supplier<Double> supplier2 = () -> forEachArray(array);
        SimpleEntry<Double,Double> result2 = Utilidades.testeBoxGenW(supplier2);
        System.out.println("Tempo double[] forEach(): " + result2.getKey() + "\n" + 
                           "Resultado soma: " + result2.getValue() +"\n\n");
        
        
        
        /**
         * STREAM SEQUENCIAL
         */
        
        //DoubleStream
        Supplier<Double> supplier3 = () -> ltc.stream().mapToDouble(l->l.getValor()).sum();
        SimpleEntry<Double,Double> result3 = Utilidades.testeBoxGenW(supplier3);
        System.out.println("Tempo DoubleStream Sequencial: " + result3.getKey() + "\n" +
                           "Resultado soma: " + result3.getValue() +"\n\n");
        
        //Stream<Double>
        Supplier<Double> supplier4 = () -> ltc.stream().map(l->l.getValor()).reduce(0.0,Double::sum);
        SimpleEntry<Double,Double> result4 = Utilidades.testeBoxGenW(supplier4);
        System.out.println("Tempo Stream<Double> Sequencial: " + result4.getKey() + "\n" +
                           "Resultado soma: " + result4.getValue() +"\n\n");
        
        /**
         * STREAM PARALELO
         */
        
        //DoubleStream
        Supplier<Double> supplier5 = () -> ltc.parallelStream().mapToDouble(l->l.getValor()).sum();
        SimpleEntry<Double,Double> result5 = Utilidades.testeBoxGenW(supplier5);
        System.out.println("Tempo DoubleStream Paralelo: " + result5.getKey() + "\n" +
                           "Resultado soma: " + result5.getValue() +"\n\n");
        
        //Stream<Double>
        Supplier<Double> supplier6 = () -> ltc.parallelStream().map(l->l.getValor()).reduce(0.0,Double::sum);
        SimpleEntry<Double,Double> result6 = Utilidades.testeBoxGenW(supplier6);
        System.out.println("Tempo Stream<Double> Paralelo: " + result6.getKey() + "\n" +
                           "Resultado soma: " + result6.getValue() +"\n\n");
    }
   
    /**
     * ´Transforma um List<TransCaixa> num array de double
     * @param ltc
     * @return 
     */
    private double[] listToArray(List<TransCaixa> ltc){
        int i = 0;
        double[] transCaixa = new double[ltc.size()];
        
        for(TransCaixa t: ltc){
            transCaixa[i] = t.getValor();
            i++;
        }
        
        return transCaixa;
    }
    
    /**
     * Faz o sumatório dos elementos de um 
     * array de double com um ciclo for
     * @param array
     * @return 
     */
    private double forArray(double[] array){
        int i;
        double total = 0;
    
        for(i=0;i<array.length;i++)
                total += array[i];
        
        return total;
    }
    
    /**
     * Faz o sumatório dos elementos de um
     * array de double com um ciclo forEach
     * @param array
     * @return 
     */
    private double forEachArray(double[] array){
        double total = 0;
        
        for(double d : array){
            total += d;
        }
        
        return total;
    }
}
