package Apresentação;

import Modulos.Caixa;
import Modulos.Crono;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import java.io.BufferedReader;
import java.io.IOException;

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
    private static Caixa caixa;
    private static Crono crono;
    private static Utilidades util;
    private static TransCaixa trans;
   
    
    private Benchmarking(){};
    
    
    public static void main (String [] args) throws IOException {
        
      
        util = new Utilidades();
        crono = new Crono();
        caixa = new Caixa();
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
    
    
    private static void printMenuFicheiro() throws IOException{
        int op;
        String t1 = "transCaixa1M";
        String t2 = "transCaixa2M";
        String t4 = "transcaixa4M";
        String t8 = "transcaixa8M";
        List<TransCaixa> ltc;
        
        do{
            op = menuficheiro.showMenu();
            switch (op){
                case 1:
                  ltc = carregaFich(t1,util); 
                  printMenuTestes();
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
    
  
  private static List<TransCaixa> carregaFich(String ficheiro, Utilidades util) throws IOException{
     Crono.start();
     List<TransCaixa> transcaixa = util.setup(ficheiro);
     System.out.println("Setup com Streams -> " + Crono.stop()*1000 + "milesegundos");
     System.out.println("Transações lidas -> " + transcaixa.size());
     util.memoryUsage();
        
     return transcaixa;
  }
  
  
  private static void printMenuTestes() throws IOException{
        int op;
        
        do{
            op = menuficheiro.showMenu();
            switch (op){
                case 1:
                  
                    break;

                case 2:
                    
                    break;
                
                case 3:
                    
                    break;

                case 4:
                    
                    break;
                case 5:
                  
                    break;

                case 6:
                    
                    break;
                
                case 7:
                    
                    break;

                case 8:
                    
                    break;
                case 9:
                  
                    break;

                case 10:
                    
                    break;
                
                case 11:
                    
                    break;

                case 12:
                    
                    break;
             }
        }while(op != 0);        
        
      
}