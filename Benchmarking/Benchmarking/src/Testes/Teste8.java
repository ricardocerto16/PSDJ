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
import java.util.List;
import java.util.function.Supplier;


/**
 *
 * @author Ricardo
 */
public class Teste8 implements ITestes{
     private List<TransCaixa> ltc;
    
    public Teste8(List<TransCaixa> ltc){
        this.ltc = ltc;
    }
    
    public void execute(){
        
        
        /**
         * JAVA 8
         */        
        Supplier<String> j8sup = () -> ltc.stream().filter(t -> t.getData().getHour() >= 16 && t.getData().getHour() < 21)
                        .max((t1, t2) -> Double.compare(t1.getValor(), t2.getValor()))
                        .toString();
        SimpleEntry<Double,String> resultj8 = Utilidades.testeBoxGenW(j8sup);
        System.out.println("Tempo com Java 8 : " + resultj8.getKey() + "  Código :  " + resultj8.getValue());
        
        
        
        /**
         * JAVA 7
         */
        Supplier<String> j7sup = () -> getCodigoMaior(ltc);
        SimpleEntry<Double,String> resultj7 = Utilidades.testeBoxGenW(j7sup);
        System.out.println("Tempo com Java 7 : " + resultj7.getKey() + "  Código :  " + resultj7.getValue());
    
        
    }
    
    
    private String getCodigoMaior(List<TransCaixa> ltc){
        double maior = 0;
        String codigo = null;
        double valor;
        
        for(TransCaixa trans : ltc){
            int hora = trans.getData().getHour();
            
            if( hora >= 15 && hora < 21){
                valor = trans.getValor();
                
                if(valor > maior) {
                
                    maior = valor;
                    codigo = trans.getTrans();
                }
            }
        }
        
        return codigo;
    }
    
    
}
