package Modell;

public interface ITransporter {
    void lowerRamp();
    void raiseRamp();
    void loadTransport(Cars car);
    void offLoadTransport();
}
