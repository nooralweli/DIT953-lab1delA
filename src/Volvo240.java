import java.awt.*;

/**
 * A subclass,represent Volvo240
 */
public class Volvo240 extends PersonalCars {

    private final static double trimFactor = 1.25;

    /**
     * A Constructor to build a VOLVO240 car
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240",5);
        stopEngine();

    }


    /**
     * A method to calculate a speed factor
     *
     * @return speed factor
     */
    private double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * increases the car speed
     *
     * @param amount we want to increase our speed with
     */

    protected void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * decreases the car speed
     *
     * @param amount to decrease our speed with
     */
    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));

    }
}


