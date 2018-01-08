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
    
        /**
         * JAVA 8
         */
        
        
        /**
         * JAVA 7
         */
        Supplier<List<List<TransCaixa>>> j7sup = () -> listaSemanaTrans(ltc);
        AbstractMap.SimpleEntry<Double,List<List<TransCaixa>>> resultj7 = Utilidades.testeBoxGenW(j7sup);
        System.out.println("Tempo com Java 7 : " + resultj7.getKey() + " Semanas :  " + resultj7.getValue());
        
        
        
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
     
     
}
