package Modell;

import java.awt.*;

public class Saab95 extends ITurbo2 implements IContext{

    private boolean turboOn; // var to enable or disable turbo
    IState state;
    /**
     * A Constructor to build a Saab95 car
     */
    public Saab95(){
        super(2,125,Color.red,"Saab95",4);
        stopEngine();
        this.state = new NoTurboState();
    }

    public void setTurboOn() {
        setState(new TurboState());
    }

    @Override
    public void setTurboOff() {
        setState(new NoTurboState());
    }

    @Override
    public void setState(IState t) {
        state = t;
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
    /*public void setTurboOn(){
        turboOn = true;
        System.out.println("turbo on");
    }

    /**
     * disables turbo, i.e off/false
     */
    /*public void setTurboOff(){
        turboOn = false;
    }

    /**
     * A method to get the cars speed factor
     * @return the speed factor of the car
     */
    private double speedFactor(){
        double turbo = state.stateSpeedFactor();

        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * increases the car speed
     * @param amount we want to increase our speed with
     */
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);

    }

    /**
     * decreease the car speed
     * @param amount to decrease our speed with
     */

    public void decrementSpeed(double amount) {
        double speed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(Math.max(speed,0));

    }



}