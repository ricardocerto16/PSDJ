package Apresentação;

import Interfaces.ITestes;
import Modulos.Caixa;
import Modulos.Crono;
import Modulos.TransCaixa;
import Modulos.Utilidades;
import Testes.Teste1;
import Testes.Teste10;
import Testes.Teste11;
import Testes.Teste2;
import Testes.Teste3;
import Testes.Teste4;
import Testes.Teste5;
import Testes.Teste6;
import Testes.Teste8;
import Testes.Teste9;
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
            "                                       * *                            10 - TESTE 10                                              * *",
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
                    System.out.println("Ficheiro transCaixa2M.txt escolhido com sucesso");
                    menuTestes(ficheiro);
                break;
                
                case 3:
                    ficheiro  = "transCaixa4M.txt";
                    System.out.println("Ficheiro transCaixa4M.txt escolhido com sucesso");
                    menuTestes(ficheiro);
                    break;

                case 4:
                    ficheiro  = "transCaixa8M.txt";
                    System.out.println("Ficheiro transCaixa8M.txt escolhido com sucesso");
                    menuTestes(ficheiro);
                break;
             }
        }while(op != 0);        
    
   }
    
  
  private static List<TransCaixa> carregaFich(String ficheiro, Utilidades util) throws IOException{
     Crono.start();
     List<TransCaixa> transcaixa = util.setup(ficheiro);
     System.out.println("Setup com Streams -> " + Crono.stop() + "  segundos");
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
                    ITestes teste4 = new Teste4();
                    teste4.execute();
                    break;
                case 5:
                    ITestes teste5 = new Teste5(ltc);
                    teste5.execute();
                    break;

                case 6:
                    ITestes teste6 = new Teste6(ltc);
                    teste6.execute();
                    break;
                
                case 7:
                    
                    break;

                case 8:
                    ITestes teste8 = new Teste8(ltc);
                    teste8.execute();
                    break;
                case 9:
                    ITestes teste9 = new Teste9(ltc);
                    teste9.execute();
                    break;

                case 10:
                    ITestes teste10 = new Teste10(ltc);
                    teste10.execute();
                    break;
                
                case 11:
                    ITestes teste11 = new Teste11(ltc);
                    teste11.execute();                   
                    break;

                case 12:
                    
                    break;
             }
        }while(op != 0);        
        
      
        }
  
}