/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Interfaces.ITestes;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.IsoFields;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 *
 * @author Ricardo
 */
public class Teste9 implements ITestes {
    private final List<TransCaixa> ltc;
    
    public Teste9(List<TransCaixa> ltc){
        this.ltc = ltc;
    }
    
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
        /**
         * JAVA 8
         */
        
        
        /**
         * JAVA 7
         */
        Supplier<Double> j7sup = () -> faturadoSemana(ltc,sem);
        AbstractMap.SimpleEntry<Double,Double> resultj7 = Utilidades.testeBoxGenW(j7sup);
        System.out.println("Tempo com Java 7 : " + resultj7.getKey() + " Total Faturado Semana  :  " + resultj7.getValue());
        
        
        
    }
    
     private int semanaCalendario(LocalDateTime data) {

        return data.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
       }
     
     private List<List<TransCaixa>> listaSemanaTrans(List<TransCaixa> ltc){
         List<List<TransCaixa>> lista = new ArrayList<>();
                 
         for(TransCaixa trans : ltc){
             LocalDateTime data = trans.getData();
             int nsem = semanaCalendario(data);
             List<TransCaixa> lmes = new ArrayList<>();
             
             if( lista.get(nsem)!= null){
                 lmes = lista.get(nsem);
                 lmes.add(trans);
             } else {
                 List<TransCaixa> ll = new ArrayList<>();
                 lista.add(nsem,ll);
             }
         
         }
         
         return lista;
    
     }
     
     private double faturadoSemana(List<TransCaixa> ltc , int semana){
         List<List<TransCaixa>> listasem = new ArrayList<>();
         listasem = listaSemanaTrans(ltc);
         List<TransCaixa> ll = new ArrayList<>();
         ll = listasem.get(semana);
         double valor = 0.0;
         
         for(TransCaixa tt : ll) {
             valor += tt.getValor();
         }
         
         return valor;
     }
}
