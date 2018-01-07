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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 *
 * @author Bandolero
 */
public class Teste4 implements ITestes {
       
 
    @Override
    public void execute() {
        BiFunction<Integer,Integer,Integer> divisao = (a,b)->a!=0&&b!=0 ? (a>b ? a/b : b/a) : 1; 
        int i;
        
        for(i=0;i<4;i++){
            
            int[] array = randomArray(i);
        
        /**
         * SEQUENCIAL
         */

        //MÉTODO STATIC DIV
        
        Supplier<Integer> supplier1 = () -> Arrays.stream(array.clone()).reduce(0, (a,b)->div(a,b));
        SimpleEntry<Double,Integer> result1 = Utilidades.testeBoxGenW(supplier1);
        
            
        //BIFUNCTION
        Supplier<Integer> supplier2 = () -> Arrays.stream(array.clone()).reduce(0,(a,b)->divisao.apply(a,b));
        SimpleEntry<Double,Integer> result2 = Utilidades.testeBoxGenW(supplier2);
        
        //EXPRESSÃO LAMBDA
        Supplier<Integer> supplier3 = () -> Arrays.stream(array.clone()).reduce(0,(a,b)-> a!=0&&b!=0 ? (a>b ? a/b : b/a) : 1);
        SimpleEntry<Double,Integer> result3 = Utilidades.testeBoxGenW(supplier3);
        
        /**
         * PARALELO
         */
        
        //MÉTODO STATIC DIV
       
        Supplier<Integer> supplier4 = () -> Arrays.stream(array.clone()).parallel().reduce(0,(a,b)->div(a,b));
        SimpleEntry<Double,Integer> result4 = Utilidades.testeBoxGenW(supplier4);
            
        
        //BIFUNCTION
        Supplier<Integer> supplier5 = () -> Arrays.stream(array.clone()).parallel().reduce(0,(a,b)->divisao.apply(a,b));
        SimpleEntry<Double,Integer> result5 = Utilidades.testeBoxGenW(supplier5);
        
        
        //EXPRESSÃO LAMBDA
        Supplier<Integer> supplier6 = () -> Arrays.stream(array.clone()).parallel().reduce(0,(a,b)->a!=0&&b!=0 ? (a>b ? a/b : b/a) : 1);
        SimpleEntry<Double,Integer> result6 = Utilidades.testeBoxGenW(supplier6);
        
        
        /**
         * IMPRESSÃO DE RESULTADOS
         */
        
        /**
         * STREAMS SEQUENCIAIS
         */
        System.out.println("Tempo do Método Static com Streams Sequenciais: " + result1.getKey() + 
                           "\n" + "Resultado da divisão: " + result1.getValue() +"\n\n");
       
        System.out.println("Tempo de BiFunction com Streams Sequenciais: " + result2.getKey() + "\n" + 
                           "Resultado da divisão: " + result2.getValue() +"\n\n");
       
        System.out.println("Tempo de Expressão Lambda com Streams Sequenciais: " + result3.getKey() + "\n" + 
                           "Resultado da divisão: " + result3.getValue() +"\n\n");
       
        /**
         *  STREAMS PARALELAS
         */
        
        
        System.out.println("Tempo do Método Static com Streams Paralelas: " + result4.getKey() + 
                           "\n" + "Resultado da divisão: " + result4.getValue() +"\n\n");
       
        System.out.println("Tempo de BiFunction com Streams Paralelas: " + result5.getKey() + "\n" + 
                           "Resultado da divisão: " + result5.getValue() +"\n\n");
       
        System.out.println("Tempo de Expressão Lambda com Streams Paralelas: " + result6.getKey() + "\n" + 
                           "Resultado da divisão: " + result6.getValue() +"\n\n");
       
        
        }
        
    }
    
    
    
    /**
     * Método static
     * @param a
     * @param b
     * @return 
     */
    private static int div(int a, int b){
        if(a!=0 && b!=0){
            if(a>b)
                return a/b;
            else
                return b/a;
        }
        return 1;
    }
    
    
    private int[] randomArray(int caso){
        Random r = new Random();
        int i;
        switch (caso) {           
            case 0:
                System.out.println("Array com 1 Milhão de inteiros");
                int[] lista = new int[1000000];
                for(i=0;i<1000000;i++){
                    lista[i] = r.nextInt(9999+1)+1;
                }
                return lista;
            case 1:
                System.out.println("Array com 2 Milhões de inteiros");
                int[] lista2 = new int[2000000];
                for(i=0;i<2000000;i++){
                    lista2[i] = r.nextInt(9999+1)+1;
                }
                return lista2;
            case 2:
                System.out.println("Array com 4 Milhões de inteiros");
                int[] lista3 = new int[4000000];
                for(i=0;i<4000000;i++){
                    lista3[i] = r.nextInt(9999+1)+1;
                }
                return lista3;
            case 3:    
                System.out.println("Array com 8 Milhões de inteiros");
                int[] lista4 = new int[8000000];
                for(i=0;i<8000000;i++){
                    lista4[i] = r.nextInt(9999+1)+1;
                }
                return lista4;
            default:
                break;
        }
        
        return null;
    }
    
    
}
