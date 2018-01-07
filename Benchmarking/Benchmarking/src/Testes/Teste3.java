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
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Supplier;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 *
 * @author Bandolero
 */
public class Teste3 implements ITestes {
    
    private final List<TransCaixa> ltc;
    
    public Teste3(List<TransCaixa> ltc){
        this.ltc = ltc;
 
    }
 
    @Override
    public void execute() {
        int i;
        
        do{
            Scanner in = new Scanner(System.in);
            System.out.println("Insira o número de Milhões que pretende usar neste teste (1 a 8)");
            i = in.nextInt();
            
            if(i>=1 && i<=8) break;
            else System.out.println("Número inválido!");
            
        }while(true);
        
        System.out.println("Sai");
        
        List<Integer> listaRand = randomList(i);
        int[] arrayRand = listToArray(listaRand);
        int tamanho = listaRand.size();
        
        
        //IntStream
        Supplier<IntStream> supplier1 = () -> listaRand.stream().mapToInt(l->l).distinct();
        SimpleEntry<Double, IntStream> result1 = Utilidades.testeBoxGenW(supplier1);
        System.out.println("Tempo IntStream a usar distinct() : " + result1.getKey() + "\n" + 
                           "Resultado da remoção: " + tamanho + 
                           "----->" + result1.getValue().count() +"\n\n");
        
        //IntArray
        Supplier<int[]> supplier2 = () -> removeRepetidos(arrayRand);
        SimpleEntry<Double,int[]> result2 = Utilidades.testeBoxGenW(supplier2);
        System.out.println("Tempo int[] a usar função removeRepetidos : " + result2.getKey() + "\n" + 
                           "Resultado da remoção: " + tamanho + 
                           "----->" + result2.getValue().length +"\n\n");
        
        //List<Integer>
        Supplier<List<Integer>> supplier3 = () -> listaRand.stream().distinct().collect(toList());
        SimpleEntry<Double,List<Integer>> result3 = Utilidades.testeBoxGenW(supplier3);
        System.out.println("Tempo List<Integer> a usar distinct() : " + result3.getKey() + "\n" + 
                           "Resultado da remoção: " + tamanho + 
                           "----->" + result3.getValue().size() +"\n\n");
    }
    
    
    
    
    private List<Integer> randomList(int caso){
        Random r = new Random();
        int i;
        switch(caso){
            case 1:
                List<Integer> lista = new ArrayList<Integer>();
                for(i=0;i<1000000;i++){
                    lista.add(r.nextInt(9999+1)+1);
                }
                return lista;
            case 2:
                List<Integer> lista2 = new ArrayList<Integer>();
                for(i=0;i<2000000;i++){
                    lista2.add(r.nextInt(9999+1)+1);
                }
                return lista2;
            case 3:
                List<Integer> lista3 = new ArrayList<Integer>();
                for(i=0;i<3000000;i++){
                    lista3.add(r.nextInt(9999+1)+1);
                }
                return lista3;
            case 4:
                List<Integer> lista4 = new ArrayList<Integer>();
                for(i=0;i<4000000;i++){
                    lista4.add(r.nextInt(9999+1)+1);
                }
                return lista4;
            case 5:
                List<Integer> lista5 = new ArrayList<Integer>();
                for(i=0;i<5000000;i++){
                    lista5.add(r.nextInt(9999+1)+1);
                }
                return lista5;
            case 6:
                List<Integer> lista6 = new ArrayList<Integer>();
                for(i=0;i<6000000;i++){
                    lista6.add(r.nextInt(9999+1)+1);
                }
                return lista6;
            case 7:
                List<Integer> lista7 = new ArrayList<Integer>();
                for(i=0;i<7000000;i++){
                    lista7.add(r.nextInt(9999+1)+1);
                }
                return lista7;
            case 8:
                List<Integer> lista8 = new ArrayList<Integer>();
                for(i=0;i<8000000;i++){
                    lista8.add(r.nextInt(9999+1)+1);
                }
                return lista8;
                
        }
        
        return null;
    }
    
    
    
    /**
     * ´Transforma um List<Integer> num array de inteiros
     * @param ltc
     * @return 
     */
    private int[] listToArray(List<Integer> lista){
        int i = 0;
        int[] arrayRand = new int[lista.size()];
        
        for(Integer t: lista){
            arrayRand[i] = t;
            i++;
        }
        
        return arrayRand;
    }
    
    private int[] removeRepetidos(int[] array){
        int[] semRep = new int[array.length];
        Set<Integer> set = new HashSet<Integer>();
        int i;
        
        for(i=0;i<array.length;i++){
            set.add(array[i]);
        }
        i=0;
        for(Integer s: set){
            semRep[i] = s;
            i++;
        }
        
        return semRep;
    }
    
}
