package Modell;

import java.awt.*;
public abstract class PersonalCars extends Cars {


    /**
     * A constructor to build the car
     *
     * @param nrDoors     Number of doors on the car
     * @param enginePower Engine power of the car
     * @param color       Color of the car
     * @param modelName   The car model name
     * @param carSize     The size of the car
     */
    protected PersonalCars(int nrDoors, double enginePower, Color color, String modelName, int carSize) {
        super(nrDoors, enginePower, color, modelName, carSize);
    }

    @Override
    protected void incrementSpeed(double amount) {

    }

    @Override
    public void decrementSpeed(double amount) {

    }
}
