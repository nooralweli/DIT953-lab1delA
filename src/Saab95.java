import java.awt.*;

public class Saab95 extends Cars{

    private boolean turboOn; // var to enable or disabke turbo

    /**
     * A Constructor to build a Saab95 car
     */
    public Saab95(){
        super(2,125,Color.red,"Saab95");
        stopEngine();
    }

    /**
     *
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
    @Override
    protected void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);

    }

    /**
     * decreease the car speed
     * @param amount to decrease our speed with
     */
    @Override
    protected void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }


}
