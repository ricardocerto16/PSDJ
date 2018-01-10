/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Modulos.TransCaixa;
import Modulos.Utilidades;

import Interfaces.ITestes;
import Modulos.Caixa;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
/**
 *
 * @author Ricardo
 */
public class Teste5 implements ITestes{
    private final List<TransCaixa> ltc;
    
    public Teste5(List<TransCaixa> ltc){
        this.ltc = ltc;
    }

   
    public void execute() {
      
         /**
          * LIST COM COMPARATOR
          */
         Supplier<List<TransCaixa>> listcomp = () -> listaComparador(ltc);
         SimpleEntry<Double, List<TransCaixa>> simplist = Utilidades.testeBoxGenW(listcomp);
         System.out.println("Tempo List com Comparator : " + simplist.getKey());
         
        
      
         /**
          * TREESET COM SORTED
          */
         Supplier<TreeSet<TransCaixa>> treesorte = () -> setsortetree(ltc);
         SimpleEntry<Double, TreeSet<TransCaixa>> tst = Utilidades.testeBoxGenW(treesorte);
         System.out.println("Tempo TreeSet com Sorted :  " + tst.getKey());
         
    }
    
     List<TransCaixa> listaComparador(List<TransCaixa> ltc){
            return ltc.stream()
                    .sorted(Caixa.transPorData).collect(toList());
         }
     
     TreeSet<TransCaixa> setsortetree(List<TransCaixa> ltc){
         return ltc.stream()
                 .collect(toCollection(() -> new TreeSet<>(Caixa.transPorData)));
     }
}
