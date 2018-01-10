
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
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Ricardo
 */
public class Teste2 implements ITestes{
    private final List<TransCaixa> ltc;
    
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
    Supplier<List<List<TransCaixa>>> listSup = () -> selec2listas(listaOrd, vintep100);
    SimpleEntry<Double,List<List<TransCaixa>>>  reslist = Utilidades.testeBoxGenW(listSup);
    System.out.println("Tempo List S.Sequencial : " + reslist.getKey());
    
    // TREESET
    Supplier<List<TreeSet<TransCaixa>>> treeSup = () -> selec2tree(treeOrd,vintep100);
    SimpleEntry<Double,List<TreeSet<TransCaixa>>> restree = Utilidades.testeBoxGenW(treeSup);
    System.out.println("Tempo TreeSet S.Sequencial :  " + restree.getKey());
    
    
    /**
    * STREAMS PARELELAS
    */

    // LIST 
    Supplier<List<List<TransCaixa>>> listSuppar = () -> selec2listasparalelas(listaOrd, vintep100);
    SimpleEntry<Double,List<List<TransCaixa>>>  reslistpar = Utilidades.testeBoxGenW(listSuppar);
    System.out.println("Tempo List S.Paralela : " + reslistpar.getKey());
    
    // TREESET
    Supplier<List<TreeSet<TransCaixa>>> treeSuppar = () -> selec2treeparalelas(treeOrd,vintep100);
    SimpleEntry<Double,List<TreeSet<TransCaixa>>> restreepar = Utilidades.testeBoxGenW(treeSup);
    System.out.println("Tempo TreeSet S.Paralela :  " + restreepar.getKey()); 
  

  
  
}

    /**
     * FUNÇÕES AUXILIARES
     */
    
  private List<List<TransCaixa>> selec2listas(List<TransCaixa> listaOrd, int vintep100){
      List<TransCaixa> prim20 = listaOrd.stream()
              .limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
      List<TransCaixa> ult20 = listaOrd.stream()
              .sorted(Caixa.transPorData2).limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
     
      
      List<List<TransCaixa>> result = new ArrayList<>();
      result.add(prim20);
      result.add(ult20);
      
      return result;
  }
    
      
  private List<TreeSet<TransCaixa>> selec2tree(TreeSet<TransCaixa> treeOrd, int vintep100){
      TreeSet<TransCaixa> prim20 = treeOrd.stream()
              .limit(vintep100).collect(toCollection(() -> new TreeSet<>(Caixa.transPorData)));
      TreeSet<TransCaixa> ult20 = treeOrd.stream()
              .sorted(Caixa.transPorData2).limit(vintep100).collect(toCollection(() -> new TreeSet<>(Caixa.transPorData)));
      
      List<TreeSet<TransCaixa>> result = new ArrayList<>();
      result.add(prim20);
      result.add(ult20);
      
      
      return result;
  }
  
  
  private List<List<TransCaixa>> selec2listasparalelas(List<TransCaixa> listaOrd , int vintep100){
      List<TransCaixa> prim20 = listaOrd.parallelStream()
              .limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
      List<TransCaixa> ult20 = listaOrd.parallelStream()
              .sorted(Caixa.transPorData2).limit(vintep100).collect(toCollection(() -> new ArrayList<>()));
      
      List<List<TransCaixa>> result = new ArrayList<>();
      result.add(prim20);
      result.add(ult20);
      
      return result;
  
      
  }
  
 
 private List<TreeSet<TransCaixa>> selec2treeparalelas(TreeSet<TransCaixa> treeOrd, int vintep100){
      TreeSet<TransCaixa> prim20 = treeOrd.parallelStream()
              .limit(vintep100).collect(toCollection(() -> new TreeSet<>(Caixa.transPorData)));
      TreeSet<TransCaixa> ult20 = treeOrd.parallelStream()
              .sorted(Caixa.transPorData2).limit(vintep100).collect(toCollection(() -> new TreeSet<>(Caixa.transPorData)));
      
      List<TreeSet<TransCaixa>> result = new ArrayList<>();
      result.add(prim20);
      result.add(ult20);
      
      
      return result;
  } 
}
    
    
