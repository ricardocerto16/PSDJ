package Apresentação;

import Crono;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class Benchmarking {

    private static Menu menuficheiro, menutestes;
    
    private Benchmarking(){
    };
    
    public static void main (String [] args) {
       
        carregaMenu();
        printMenuFicheiro();
}
    
    
    private static void carregaMenu(){
    
        String [] ficheiro = {
            "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
            "                                       * *                            ESCOLHA DO FICHEIRO:                                       * *",
            "                                       * *                            1 - 1M.TXT                                                 * *",
            "                                       * *                            2 - 2M.TXT                                                 * *",
            "                                       * *                            3 - 4M.TXT                                                 * *",
            "                                       * *                            4 - 8M.TXT                                                 * *",
            "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
        };
        
        String [] testes = {
            "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *",
            "                                       * *                            ESCOLHA DO TESTE:                                          * *",
            "                                       * *                            1 - TESTE 1                                                * *",
            "                                       * *                            2 - TESTE 2                                                * *",
            "                                       * *                            3 - TESTE 3                                                * *",
            "                                       * *                            4 - TESTE 4                                                * *",
            "                                       * *                            5 - TESTE 5                                                * *",
            "                                       * *                            6 - TESTE 6                                                * *",
            "                                       * *                            7 - TESTE 7                                                * *",
            "                                       * *                            8 - TESTE 8                                                * *",
            "                                       * *                            9 - TESTE 9                                                * *",
            "                                       * *                            10 - TESTE 10                                               * *",
            "                                       * *                            11 - TESTE 11                                              * *",
            "                                       * *                            11 - TESTE 12                                              * *",
            "                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
        };
        
       menuficheiro = new Menu(ficheiro);
       menutestes = new Menu(testes);   
    
    }
    
    
    private static void printMenuFicheiro(){
        int op;
        String t1 = "transCaixa1M";
        String t2 = "transCaixa2M";
        String t4 = "transcaixa4M";
        String t8 = "transcaixa8M";
        
        do{
            op = menuficheiro.showMenu();
            switch (op){
                case 1:
                  //carregafich(t1); 
                    break;

                case 2:
                  //carregaFich(f2);  
                break;
                
                case 3:
                    //carregaFich(f3);
                    break;

                case 4:
                    //carregaFich(f4);
                break;
             }
        }while(op != 0);        
    
   }
    
  // criar crono
  // Utilidades -> Trans_Caixa_Exs
  // Trans_Caixa -> t
    /*
  private static List<TransCaixa> carregaFich(String filename, Utilidades utl , BufferedReader) throws IOException{
     Crono.start();
     List<TransCaixa> trans = trans.setupStream(ficheiro);
     u.setupStream(ficheiro);
     System.out.println("Setup com Streams -> " + Crono.stop()*1000 + "milesegundos");
     System.out.println("Transações lidas -> " + trans.size());
  }
    
    */
    
}