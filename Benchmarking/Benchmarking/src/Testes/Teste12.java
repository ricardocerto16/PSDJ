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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *
 * @author Bandolero
 */
public class Teste12 implements ITestes {

    private final List<TransCaixa> ltc;
    
    public Teste12(List<TransCaixa> ltc){
        this.ltc = ltc;
 
    }
    
    @Override
    public void execute() {
        
        /**
         * RESULTADO COM MAP
         */
        
        Map<String,Map<Month,List<TransCaixa>>> transMap = getMap(ltc);
        
        Supplier<Map<String,Double>> supplierMap = ()-> transMap.entrySet().stream()
                                                                .collect(Collectors.toMap(t->t.getKey(), 
                                                            t->t.getValue().values().stream().mapToDouble(l->l.stream().collect(Collectors.summingDouble(s->s.getValor()))).sum()));
                                                                   
        SimpleEntry<Double,Map<String,Double>> resultMap = Utilidades.testeBoxGenW(supplierMap);
        System.out.println("Tempo com Map: "+ resultMap.getKey() +"\n ");
        
        for(Map.Entry<String,Double> entry: resultMap.getValue().entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        
        
        /**
         * RESULTADO COM CONCURRENT MAP
         */
        
        Map<String,Map<Month,List<TransCaixa>>> transConcurrentMap = getConcurrentMap(ltc);
        
        Supplier<Map<String,Double>> supplierConcurrentMap = () -> transConcurrentMap.entrySet().stream()
                                                                                     .collect(Collectors.toMap(t->t.getKey(),t->t.getValue().values().stream()
                                                                                                                                            .mapToDouble(l->l.stream()
                                                                                                                                            .collect(Collectors.summingDouble(s->s.getValor()))).sum()));
        SimpleEntry<Double,Map<String,Double>> resultConcurrentMap = Utilidades.testeBoxGenW(supplierConcurrentMap);
        System.out.println("Time: "+resultConcurrentMap.getKey()+"\n ");
        
        for(Map.Entry<String,Double> entry: resultConcurrentMap.getValue().entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        
        
        
    }
    
    
    private Map<String,Map<Month,List<TransCaixa>>> getMap(List<TransCaixa> ltc){
        Map<String,Map<Month,List<TransCaixa>>> tab = new TreeMap<>();
        Map<Month,List<TransCaixa>> mapMes;
        List<TransCaixa> listaMes;
        
        for(TransCaixa t : ltc){
            String nrCaixa = t.getCaixa();
            Month mes = t.getData().getMonth();
            
            if(tab.containsKey(nrCaixa)){
                mapMes = tab.get(nrCaixa);
            }
            else{
                mapMes = new TreeMap<>();
            }
            
            if(mapMes.containsKey(mes)){
                listaMes = mapMes.get(mes);
                listaMes.add(t);
            }
            else{
                listaMes = new ArrayList<>();
                listaMes.add(t);
            }
            
            mapMes.put(mes,listaMes);
            tab.put(nrCaixa, mapMes);           
            
        }
        
        
        return tab;
    }
    
    
    private Map<String,Map<Month,List<TransCaixa>>> getConcurrentMap(List<TransCaixa> ltc){
        Map<String,Map<Month,List<TransCaixa>>> tab = new ConcurrentSkipListMap<>();
        Map<Month,List<TransCaixa>> mapMes;
        List<TransCaixa> listaMes;
        
        for(TransCaixa t : ltc){
            String nrCaixa = t.getCaixa();
            Month mes = t.getData().getMonth();
            
            if(tab.containsKey(nrCaixa)){
                mapMes = tab.get(nrCaixa);
            }
            else{
                mapMes = new ConcurrentSkipListMap<>();
            }
            
            if(mapMes.containsKey(mes)){
                listaMes = mapMes.get(mes);
                listaMes.add(t);
            }
            else{
                listaMes = new ArrayList<>();
                listaMes.add(t);
            }
            
            mapMes.put(mes,listaMes);
            tab.put(nrCaixa, mapMes);           
            
        }
        
        
        return tab;
    }
    
}
