/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Interfaces.ITestes;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import java.time.Month;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;

/**
 *
 * @author Ricardo
 */
public class Teste10 implements ITestes{
    private final List<TransCaixa> ltc;
    
    public Teste10(List<TransCaixa> ltc){
        this.ltc = ltc;
    }
    
    public void execute(){

        
      /**
       * JAVA 8
       */  
        Supplier<Map<Month,Double>> j8sup = () -> ltc.stream()
                   .collect(Collectors.groupingBy(t -> 
		        t.getData().getMonth(),
                        Collectors.summingDouble(t->t.getValor()<20.0 ? t.getValor() *0.15 : 
                                                (t.getValor() >= 20.0 && t.getValor()<29.0 ? t.getValor()*0.20 : t.getValor()*0.23))));
        SimpleEntry<Double,Map<Month,Double>> resultj8 = Utilidades.testeBoxGenW(j8sup);
        System.out.println("Tempo com Java 8: " + resultj8.getKey() + " IVA : " + resultj8.getValue());
      
      
      /**
       * JAVA 7
       */
        Supplier<Map<Month,Double>> j7sup = () -> ivapormes(ltc);
        SimpleEntry<Double,Map<Month,Double>> resultj7 = Utilidades.testeBoxGenW(j7sup);
        System.out.println("Tempo com Java 7 : " + resultj7.getKey() + " IVA :  " + resultj7.getValue());
      
    }
    

    private Map<Month,Double> ivapormes(List<TransCaixa> ltc) {
        Map<Month,Double> ivam = new HashMap<>(); 
        
        for(TransCaixa trans : ltc){
        
            Month mes = trans.getData().getMonth();
            double valor = trans.getValor();
            double valoriva = 0;
            
            if (valor < 20.0) {
                valoriva = valor * 0.15;
            }
            else if ( valor >= 20.0 && valor < 29.0 ){
                valoriva = valor * 0.20;
            }
            else if (valor >= 29.0){
                valoriva = valor * 0.23;
            }
            
            adicionaiva(mes,valoriva,ivam);
                    
        }          
        
        return ivam;
    }

    private void adicionaiva(Month mes, double valoriva, Map<Month, Double> ivam) {
        
        if(ivam.containsKey(mes)){
            ivam.put(mes, ivam.get(mes) + valoriva);
        }
        else {
            ivam.put(mes, valoriva);
        }
    }
    
    
}

