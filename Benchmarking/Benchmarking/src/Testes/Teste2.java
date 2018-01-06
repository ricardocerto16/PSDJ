/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;
import Interfaces.ITestes;
import Modulos.Caixa;
import Modulos.TransCaixa;
import Modulos.Utilidades;

import static Modulos.Caixa.transPorData;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author Ricardo
 */
public class Teste2 implements ITestes{
    private List<TransCaixa> ltc;
    
    public Teste2(List<TransCaixa> ltc){
        this.ltc = ltc;
    }

    public void execute(){
        int vintep100 = ltc.size() / 5 ;
    /**
     *  LIST
    */
    List<TransCaixa> listaOrd = ltc.stream()
            .sorted(transPorData)
            .collect(toList());
    
    /**
    * TREESET
    */
    TreeSet<TransCaixa> treeOrd = new TreeSet<>(transPorData);
    treeOrd.addAll(ltc);
   
    
    /**
    * STREAMS SEQUENCIAIS
     */

    // LIST 
    
    Supplier<List<TransCaixa>> listSup = () -> soma2listas(listaOrd, vintep100);
    SimpleEntry<Double,List<TransCaixa>>  reslist = Utilidades.testeBoxGenW(listSup);
    System.out.println("Tempo List Sequencial : " + reslist.getKey());
    
    // TreeSet
    /**
    * STREAMS PARELELAS
    */

    }
  
  
  private List<TransCaixa> soma2listas(List<TransCaixa> listaOrd, int vintep100){
      List<TransCaixa> prim20 = listaOrd.stream()
              .limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
      List<TransCaixa> ult20 = listaOrd.stream()
              .sorted(Caixa.transPorData2).limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
     
      
      List<TransCaixa> res = new ArrayList<>();
      res = Stream.concat(prim20.stream(),
              ult20.stream()).collect(Collectors.toList());
      
      
      return res;
      
  }
    
    
}
