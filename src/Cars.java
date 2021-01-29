import java.awt.*;

/**
 * Represents a Car
 */

public abstract class Cars implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double posX;    //The position in x-axis
    private double posY;    //The position in y-axis
    private Direction dir = Direction.NORTH; //The direction of the car,default NORTH

    /**
     * A constructor to build the car
     *
     * @param nrDoors     Number of doors on the car
     * @param enginePower Engine power of the car
     * @param color       Color of the car
     * @param modelName   The car model name
     */
    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * sets posX on the car
     *
     * @param posX The position in x-axis
     */
    protected void setPosX(double posX) {
        this.posX = posX;
    }

    /**
     * @return pos x of the car
     */
    public double getPosX() {
        return posX;
    }

    /**
     * @return pos y of the car
     */
    public double getPosY() {
        return posY;
    }

    /**
     * sets posY on the car
     *
     * @param posY The position in y-axis
     */
    protected void setPosY(double posY) {
        this.posY = posY;
    }

    /**
     * Four different directions.
     */
    protected enum Direction {
        EAST, WEST, NORTH, SOUTH
    }

    /**
     * @return our current direction
     */
    protected Direction getDir() {
        return dir;
    }


    /**
     * sets the current speed of a car
     *
     * @param currentSpeed The current speed that will be set
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * a method to get our current speed
     *
     * @return current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * a method to get the nr of doors we have on the car
     *
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * A method to get our engine power
     *
     * @return our engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * A method to get the color of the car
     *
     * @return our cars color
     */
    public Color getColor() {
        return color;
    }

    /**
     * A method to set a color on the car
     *
     * @param clr the new car color
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * starts the engine, i.e sets a speed to 0.1
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the Engine, sets speed to 0
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * A method to increase the car speed (gas)
     *
     * @param amount we want to increase our speed with
     */
    protected void incrementSpeed(double amount) {
        // Overrides in subclasses
    }

    /**
     * A method to decrease the car speed (break)
     *
     * @param amount to decrease our speed with
     */
    protected void decrementSpeed(double amount) {
        // Overrides in subclasses
    }

    /**
     * A Method to increase the Speed of the car
     * Cannot decrease the speed
     *
     * @param amount we want to increase our speed with
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            double currentSpeed = getCurrentSpeed();
            incrementSpeed(amount);
            double newSpeed = getCurrentSpeed();

            if (newSpeed < currentSpeed) {
                setCurrentSpeed(currentSpeed);
            }
        }
    }


    /**
     * A Method to decrease the Speed of the car
     * Cannot increase the speed
     *
     * @param amount we want to decrease our speed with
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            double currentSpeed = getCurrentSpeed();
            decrementSpeed(amount);
            double newSpeed = getCurrentSpeed();

            if (newSpeed > currentSpeed) {
                setCurrentSpeed(currentSpeed);
            }
        }

    }

    /**
     * A method to turn to the right direction
     */
    public void turnRight() {
        switch (dir) {
            case NORTH:
                dir = Direction.EAST;
                break;
            case WEST:
                dir = Direction.NORTH;
                break;
            case SOUTH:
                dir = Direction.WEST;
                break;
            case EAST:
                dir = Direction.SOUTH;
                break;
        }
    }

    /**
     * A method to turn to the left direction
     */
    public void turnLeft() {
        switch (dir) {
            case NORTH:
                dir = Direction.WEST;
                break;
            case WEST:
                dir = Direction.SOUTH;
                break;
            case SOUTH:
                dir = Direction.EAST;
                break;
            case EAST:
                dir = Direction.NORTH;
                break;
        }
    }

    /**
     * A method to move to the new position
     */
    public void move() {
        switch (dir) {
            case NORTH:
                posY += currentSpeed;
                break;
            case WEST:
                posX -= currentSpeed;
                break;
            case SOUTH:
                posY -= currentSpeed;
                break;
            case EAST:
                posX += currentSpeed;
                break;
        }
    }
}
