package Modell;

public class CarFactory {

    public static Cars createVolvo() {
        return new Volvo240();
    }

    public static ITurbo2 createSaab() { return new Saab95();}

    public static ITrucks createScania() {return new Scania();}

    public static ITransporter createCarTransport(){return new CarTransport();}

}
