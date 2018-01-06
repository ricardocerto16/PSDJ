package Apresentação;

import Interfaces.ITestes;
import Modulos.Caixa;
import Modulos.Crono;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import Testes.Teste1;
import Testes.Teste2;
import Testes.Teste3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    private static Menu menuficheiro, menustestes;
    private static Caixa caixa;
    private static Crono crono;
    private static Utilidades util;
    private static TransCaixa trans;

  
     
    private Benchmarking(){};
    
    
    public static void main (String [] args) throws IOException {
       
        List<TransCaixa> ltc;
        String ficheiro;
        util = new Utilidades();
        //crono = new Crono();
        //caixa = new Caixa();
        
        
        carregaMenu();
        menuFicheiro(); 
        
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
       menustestes = new Menu(testes);   
    
    }
    
    
    private static void menuFicheiro() throws IOException{
        int op;
        String ficheiro = null;
        
        
        do{
            op = menuficheiro.showMenu();
            switch (op){
                case 1:
                  ficheiro = "transCaixa1M.txt";
                  System.out.println("Ficheiro transCaixa1M.txt escolhido com sucesso");
                  menuTestes(ficheiro);
                  break;

                case 2:
                    ficheiro  = "transCaixa2M.txt";
                break;
                
                case 3:
                    ficheiro  = "transCaixa4M.txt";
                    break;

                case 4:
                    ficheiro  = "transCaixa8M.txt";
                break;
             }
        }while(op != 0);        
    
   }
    
  
  private static List<TransCaixa> carregaFich(String ficheiro, Utilidades util) throws IOException{
     Crono.start();
     List<TransCaixa> transcaixa = util.setup(ficheiro);
     System.out.println("Setup com Streams -> " + Crono.stop()*1000 + "  milesegundos");
     System.out.println("Transações lidas -> " + transcaixa.size());
     util.memoryUsage();
        
     return transcaixa;
  }
  
  
  private static void menuTestes(String ficheiro) throws IOException{
        int op;
        List<TransCaixa> ltc;
        ltc = carregaFich(ficheiro,util);
        
        
        do{
            op = menustestes.showMenu();
            switch (op){
                case 1:
                    ITestes teste1 = new Teste1(ltc);
                    teste1.execute();
                    break;

                case 2:
                    ITestes teste2 = new Teste2(ltc);
                    teste2.execute();
                    break;
                
                case 3:
                    ITestes teste3 = new Teste3(ltc);
                    teste3.execute();
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
  
}