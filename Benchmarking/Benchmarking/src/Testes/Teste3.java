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
import java.util.Set;
import java.util.function.Supplier;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 *
 * @author Bandolero
 */
public class Teste3 implements ITestes {
    
    private List<TransCaixa> ltc;
    
    public Teste3(List<TransCaixa> ltc){
        this.ltc = ltc;
 
    }
 
    @Override
    public void execute() {
        List<Integer> listaRand = randomList();
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
    
    private List<Integer> randomList(){
        List<Integer> lista = new ArrayList<Integer>();
        Random r = new Random();
        int i;
        for(i=0;i<ltc.size();i++){
            lista.add(r.nextInt(9999+1)+1);
        }
        return lista;
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
