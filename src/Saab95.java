import java.awt.*;

public class Saab95 extends PersonalCars {

    private boolean turboOn; // var to enable or disable turbo

    /**
     * A Constructor to build a Saab95 car
     */
    public Saab95(){
        super(2,125,Color.red,"Saab95",4);
        stopEngine();
    }

    /**
     *Checks if turbo is one
     * @return true or false if turbo
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     *  enables turbo, i.e on/true
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * disables turbo, i.e off/false
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * A method to get the cars speed factor
     * @return the speed factor of the car
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * increases the car speed
     * @param amount we want to increase our speed with
     */
    protected void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        // I Metoder ska man sätta metoden inom parents som ovan
        //setCurrentSpeed = getCurrentSpeed() + speedFactor() * amount;

    }

    /**
     * decreease the car speed
     * @param amount to decrease our speed with
     */

    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }



}
