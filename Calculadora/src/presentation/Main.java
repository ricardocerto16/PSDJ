/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.Cronometro;
import business.Fusos;
import business.RelogioUser;
import business.Resposta;

/**
 *
 * @author Bandolero
 */
public class Main {
    
    public static void main(String[] args) {
        Resposta principal = new Resposta();
        RelogioUser rel = new RelogioUser();
        Fusos fusos = new Fusos();
        Cronometro cron = new Cronometro();
        CalculadoraApp controlador = new CalculadoraApp(principal,rel,fusos,cron);
    }
}
