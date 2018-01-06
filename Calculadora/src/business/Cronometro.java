package business;

import interfaces.ICronometro;

public class Cronometro implements ICronometro {

    private static long inicio = 0L;
    private static long fim = 0L;

    public void start() {
        fim = 0L;
        inicio = System.nanoTime();
    }

    public double stop() {
        fim = System.nanoTime();
        long r = fim - inicio;
        inicio = 0L;
        fim = 0L;
        double segs = r / 1.0E09;
        return segs;
    }

    public String print(){
        return " " + stop();
    }
    
}
