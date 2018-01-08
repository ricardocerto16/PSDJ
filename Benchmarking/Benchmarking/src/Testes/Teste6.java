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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author Ricardo
 */
public class Teste6 implements ITestes{
    private final List<TransCaixa> ltc;
    
    public Teste6(List<TransCaixa> ltc){
        this.ltc = ltc;
    }
    
    @Override
    public void execute(){
    
        /**
         * STREAMS
         */
        Supplier<Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> supcatalgst = () -> criacat(ltc); 
        SimpleEntry<Double, Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> result = Utilidades.testeBoxGenW(supcatalgst);
        System.out.println("Tempo com Streams : " + result.getKey());
    
        
        /**
         * JAVA 7
         */
        Supplier<Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> supcatalgj7 = () -> criacatalogo(ltc);
        SimpleEntry<Double, Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> resultjav7 = Utilidades.testeBoxGenW(supcatalgj7);
        System.out.println("Tempo com Java 7: " + resultjav7.getKey());
        
        
    }
    
    Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>> criacat(List<TransCaixa> ltc) {
        
        return ltc.stream().collect(groupingBy(util -> util.getData().getMonth(),
                                     groupingBy(util -> util.getData().getDayOfMonth(),
                                     groupingBy(util -> util.getData().getHour())))); 
    
    }
    
    
    Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>> criacatalogo(List<TransCaixa> ltc){
        Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>> catalogo = new HashMap<>();
        
        for(TransCaixa trans : ltc){
        
            Month mes = trans.getData().getMonth();
            int dia = trans.getData().getDayOfMonth();
            int hora = trans.getData().getHour();
            List<TransCaixa> colhora;
            Map<Integer,List<TransCaixa>> coldia;
            Map<Integer,Map<Integer,List<TransCaixa>>> colmes;
            
            colmes = getColmes(catalogo,mes);
            coldia = getColdia(colmes,dia);
            colhora = getColHora(coldia,hora);
            colhora.add(trans);
            
        }
        return catalogo;
    }

    private Map<Integer, Map<Integer, List<TransCaixa>>> getColmes(Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>> catalogo, Month mes) {
        Map<Integer, Map<Integer, List<TransCaixa>>> colunames;
        
        if(!catalogo.containsKey(mes)){
            colunames = new HashMap<>();
            catalogo.put(mes, colunames);
        }
        else{
            colunames = catalogo.get(mes);
        }
        
        return colunames;
    
    }

    private Map<Integer, List<TransCaixa>> getColdia(Map<Integer, Map<Integer, List<TransCaixa>>> colmes, int dia) {
        Map<Integer, List<TransCaixa>> colunadia;
        
        if(!colmes.containsKey(dia)){
            colunadia = new HashMap<>();
            colmes.put(dia, colunadia);
        }
        else{
            colunadia = colmes.get(dia);
        }
        
        return colunadia;
        
    }

    private List<TransCaixa> getColHora(Map<Integer, List<TransCaixa>> coldia, int hora) {
        List<TransCaixa> colunahora;
        
        if(!coldia.containsKey(hora)){
            colunahora = new ArrayList<>();
            coldia.put(hora, colunahora);
        }
        else{
            colunahora = coldia.get(hora);
        }
        
        return colunahora;
    }
    
    
    
    
    
    
}
