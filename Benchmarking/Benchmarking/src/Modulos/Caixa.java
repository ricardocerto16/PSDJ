package Modulos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;

/**
 *
 * @author Ricardo
 */
public class Caixa {


    /**
     * String para TransCaixa 
     * @param linha
     * @return 
     */
    public static TransCaixa strToTransCaixa(String linha) {
       //     
       double preco = 0.0; 
       int ano = 0; int mes = 0; int dia = 0; 
       int horas = 0; int min = 0; int seg = 0;
       String codTrans, codCaixa;
       
       // split()
       String[] campos = linha.split("/");
       
       codTrans = campos[0].trim();
       codCaixa = campos[1].trim();
       
       try {
             preco = Double.parseDouble(campos[2]); 
       }
       catch(InputMismatchException | NumberFormatException e)
      { return null; } 
               
       String[] diaMesAnoHMS = campos[3].split("T");
       String[] diaMesAno = diaMesAnoHMS[0].split(":");
       String[] horasMin = diaMesAnoHMS[1].split(":");
       try {
             dia = Integer.parseInt(diaMesAno[0]);
             mes = Integer.parseInt(diaMesAno[1]);
             ano = Integer.parseInt(diaMesAno[2]);
             horas = Integer.parseInt(horasMin[0]);
             min = Integer.parseInt(horasMin[1]);
       }
       catch(InputMismatchException | NumberFormatException e) 
       { return null; } 
             
       return TransCaixa.of(codTrans, codCaixa, preco, LocalDateTime.of(ano, mes, dia, horas, min, 0));    
    }
    
    /**
     * Comparator de Datas
     */
    public static Comparator<LocalDate> compMenorData = 
                        (LocalDate ld1, LocalDate ld2) -> { if(ld1.equals(ld2)) return 0;
                                                            else if(ld1.isBefore(ld2)) return -1;
                                                            else return 1 ; 
                                                          };
    
    
    /**
     * Comparator de Time
     */
    public static Comparator<LocalTime> compMenorTime = 
                        (LocalTime lt1, LocalTime lt2) -> { if(lt1.equals(lt2)) return 0;
                                                            else if(lt1.isBefore(lt2)) return -1; 
                                                            else return 1 ; 
                                                          };
    
    
    /**
     * Comparator do TransCaixa
     */
    public static Comparator<TransCaixa> transPorData = 
      (TransCaixa tc1, TransCaixa tc2) -> { 
            LocalDateTime ldt1 = tc1.getData();
            LocalDateTime ldt2 = tc2.getData();
            if(ldt1.equals(ldt2)) return 0;
            else if(ldt1.isBefore(ldt2)) return -1; else return 1 ; 
       };

}

    
    

     
