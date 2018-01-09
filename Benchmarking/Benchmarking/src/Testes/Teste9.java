/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Interfaces.ITestes;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Supplier;

/**
 *
 * @author Ricardo
 */
public class Teste9 implements ITestes {
    private final List<TransCaixa> ltc;
    
    private List<List<TransCaixa>> listasem = new ArrayList<>();
    
    public Teste9(List<TransCaixa> ltc){
        this.ltc = ltc;
    }
    
    @Override
    public void execute(){
        int i;
        final int sem;
        
        do{
            Scanner in = new Scanner(System.in);
            System.out.println("Insira a semana em que ver o total faturado (1 a 53)");
            i = in.nextInt();
            
            if(i>=1 && i<=53) break;
            else System.out.println("Número inválido!");
            
        }while(true);
        
        sem = i;
        List<List<TransCaixa>> lista = listaSemanaTrans(ltc);
        List<List<TransCaixa>> lista2 = lista;
        /**
         * JAVA 8
         */
        Supplier<Double> j8sup = () -> lista.get(sem).stream().map(t->t.getValor()).reduce(0.0, Double::sum);
        SimpleEntry<Double,Double> resultj8 = Utilidades.testeBoxGenW(j8sup);
        System.out.println("Tempo com Java 8 : " + resultj8.getKey() +"\n"+
                           "Total Faturado Semana " + sem + ": " + resultj8.getValue());
        
        /**
         * JAVA 7
         */
        Supplier<Double> j7sup = () -> faturadoSemana(lista2,sem);
        SimpleEntry<Double,Double> resultj7 = Utilidades.testeBoxGenW(j7sup);
        System.out.println("Tempo com Java 7 : " + resultj7.getKey() +"\n"+ 
                           "Total Faturado Semana " + sem + ": " + resultj7.getValue());
        
        
        
    }
    
     private int semanaCalendario(LocalDateTime data) {

        return data.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
       }
     
     private List<List<TransCaixa>> listaSemanaTrans(List<TransCaixa> ltc){
         TreeMap<Integer,List<TransCaixa>> aux = new TreeMap<>();
         
         for(TransCaixa trans :ltc){
            LocalDateTime data = trans.getData();
            int nsem = semanaCalendario(data);
            List<TransCaixa> lsem = new ArrayList<>();
            
            if(aux.containsKey(nsem)){
                lsem = aux.get(nsem);
                lsem.add(trans);
                aux.put(nsem,lsem);
            }
            else{
                List<TransCaixa> ll = new ArrayList<>();
                ll.add(trans);
                aux.put(nsem,ll);
            }
         }
         
         List<List<TransCaixa>> lista = new ArrayList<>(aux.values()); 
         
         return lista;
     }
         
     
     private double faturadoSemana(List<List<TransCaixa>> listasem,int sem){
         
         List<TransCaixa> ll = new ArrayList<>();
         ll = listasem.get(sem);
         double valor = 0.0;
         
         for(TransCaixa tt : ll) {
             valor += tt.getValor();
         }
         
         return valor;
     }
}
