import java.awt.*;
import java.util.Stack;

import static java.lang.Math.abs;

/**
 * Presents a Cartransport car
 */
public class CarTransport extends Trucks {


    /**
     * For two ways to positions, up and down
     */
    protected enum Ramp {
        UP, DOWN
    }


    protected Ramp ramp = Ramp.UP; // default is up
    private final int MAX_LOAD = 3;
    private final int MAX_DISTANCE = 10;
    private final int MAX_SIZE = 20;
    private final Stack<Cars> load = new Stack<>();
    //private String[] allowedCars;


    /**
     * A constructor to build the car
     *
     * @param enginePower Engine power of the car
     * @param color       Color of the car
     * @param modelName   The car modelName
     * @param carSize     The size of the car
     * @param nDoors      The number of doors
     */
    public CarTransport(int nDoors,double enginePower, Color color, String modelName, int carSize) {
        super(2, 400, Color.WHITE, "CarTransport", 25);

    }



    /**
     * A method to decrease the ramp down
     */
    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp = Ramp.DOWN;
        }


    }

    /**
     * A method to raise the ramp up
     */
    public void raiseRamp() {
        ramp = Ramp.UP;
    }


    /**
     * A Method to Load the cars in a the carTransport
     *
     * @param car The car that will be loaded in the carTransport
     */
    protected void loadTransport(PersonalCars car) {

        if (ramp == Ramp.DOWN && load.size() < MAX_LOAD && car.carSize <= MAX_SIZE) {
            double transportPosX = getPosX();
            double transportPosY = getPosY();
            double carPosX = car.getPosX();
            double carPosY = car.getPosY();

            if (abs(transportPosX - carPosX) < MAX_DISTANCE && abs(transportPosY - carPosY) < MAX_DISTANCE) {
                car.setPosX(transportPosX);
                car.setPosY(transportPosY);
                load.push(car);

            }
        }
    }


    /**
     * A method to offLoad the cars from the carTransport
     */
    protected void offLoadTransport() {
        if (ramp == Ramp.DOWN && load.size() > 0) {
            double transportPosX = this.getPosX();
            double transportPosY = this.getPosY();
            Cars car = load.pop();
            car.setPosX(transportPosX + load.size() + 1);
            car.setPosY(transportPosY + load.size() + 1);

        }
    }


    /**
     * A method to increase the speed of the car
     *
     * @param amount we want to increase our speed with
     */
    @Override
    protected void incrementSpeed(double amount) {
        if (ramp == Ramp.UP) {
            setCurrentSpeed(getCurrentSpeed() + getEnginePower() * 0.01 * amount);
        }

    }

    /**
     * A method to decrease the speed of the car
     *
     * @param amount to decrease our speed with
     */
    @Override
    protected void decrementSpeed(double amount) {
        // är kravet att biltransporten ska inte kunna bromsa medans rampen är nere?
        setCurrentSpeed(getCurrentSpeed() - getEnginePower() * 0.01 * amount);
    }

    @Override
    public void move() {
        super.move();
        for (Cars cars : load) {
            cars.setPosX(this.getPosX());
            cars.setPosY(this.getPosY());
        }
    }
}





