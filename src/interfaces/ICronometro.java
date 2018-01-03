package interfaces;

public interface ICronometro {

    // inicia a contagem do cronometro
    public void start();

    // termina a contagem do cronometro
    public double stop();

    // imprime o valor final do contador
    public String print();
}
