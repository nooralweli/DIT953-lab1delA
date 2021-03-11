package Modell;

import java.awt.*;

import static java.lang.Math.abs;


public class Scania extends Trucks implements ITrucks {
    /**
     * A Variable for the angle of the flatbed
     */
    private int flatBedAngle;

    /**
     * A constructor to build Scania car
     */
    public Scania() {
        super(2, 200, Color.black, "Scania",5);

    }


    /**
     * Checks if the angle is between [0,70]
     * otherwise the angle will be the newAngle
     *
     * @param newAngle the new angle for the flatbed
     */
    public void adjustBedAngle(int newAngle) {
        if (newAngle < 0) {
            flatBedAngle = 0;
        } else if (newAngle > 70) {
            flatBedAngle = 70;
        } else {
            flatBedAngle = newAngle;
        }
    }


    /**
     * Inrease the flatbed
     *
     * @param angle the amount the flatbed will be increased with
     */
    public void increaseFlatBed(int angle) {
        if (getCurrentSpeed() == 0) {
            int currentAngle = flatBedAngle;
            int newAngle = currentAngle + abs(angle);
            adjustBedAngle(newAngle);

        }


    }


    /**
     * decrease the flatbed
     *
     * @param angle the amount the flatbed will be decreased with
     */
    public void decreaseFlatBed(int angle) {
        if (getCurrentSpeed() == 0) {
            int currentAngle = flatBedAngle;
            int newAngle = currentAngle - abs(angle);
            adjustBedAngle(newAngle);

        }


    }

    /**
     * increament the speed if flatBedAngle is 0
     *
     * @param amount we want to increase our speed with
     */
    @Override
    protected void incrementSpeed(double amount) {
        if (flatBedAngle == 0) {
            setCurrentSpeed(getCurrentSpeed() + getEnginePower() * 0.01 * amount);

        }

    }

    /**
     * increament the speed if flatbedAngle is 0
     *
     * @param amount to decrease our speed with
     */
    @Override
    protected void decrementSpeed(double amount) {
        if (flatBedAngle == 0) {
            double speed = getCurrentSpeed() - getEnginePower() * 0.01 * amount;
            setCurrentSpeed(Math.max(speed,0));
        }
    }
}
