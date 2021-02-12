import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Cars> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                /*if (car.getPosX()<=800||car.getPosY()<=800&&car.getPosX()>=0 && car.getPosY()>=0) { */
                collisionCheck(car);
                car.move();
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
    //}

    /**boolean collisionCheck(Cars car) {
        boolean xCollision = -car.getCurrentSpeed() + car.getPosX() <= 0 || car.getCurrentSpeed() + car.getPosX() >= frame.drawPanel.getWidth();
        boolean yCollision = car.getCurrentSpeed() + car.getPosX() >= 0 || car.getCurrentSpeed() + car.getPosY() > 800;
        return xCollision && yCollision;

    }*/
    boolean xCol(Cars car){
        boolean xCollision = false;

        if(car.getPosX() + car.getCurrentSpeed() > 800){
            xCollision=true;
            car.setPosX(800);
        }
        else if(car.getPosX() - car.getCurrentSpeed() < 0){
            xCollision=true;
            car.setPosX(0);
        }
        return xCollision;
    }
    boolean yCol(Cars car){
        boolean yCollision = false;

        if(car.getPosY() + car.getCurrentSpeed() > 800){
            yCollision = true;
            car.setPosY(800);
        }
        else if(car.getPosY() - car.getCurrentSpeed() < 0){
            yCollision=true;
            car.setPosY(0);
        }
        return yCollision;
    }

    void collisionCheck(Cars car) {


        if (xCol(car)) {
            double currentspeedx = car.getCurrentSpeed();
            //car.stopEngine();
            switch (car.dir) {
                case NORTH:
                    car.dir = Cars.Direction.SOUTH;
                    car.setPosX(800);
                case SOUTH:
                    car.dir = Cars.Direction.NORTH;
                    car.setPosX(0);
            }
            car.startEngine();
            car.setCurrentSpeed(currentspeedx);

            /*
            if(car.getDir() == Cars.Direction.SOUTH ){
                car.dir=Cars.Direction.NORTH;
            }
            else if(car.getDir() == Cars.Direction.NORTH ){
                car.dir=Cars.Direction.SOUTH;
            }
            car.startEngine();
            car.setCurrentSpeed(currentspeedx);
            //stop enginee
            //currentdir motsats
            // start engine
            //currentspeed = gamla currentspeed

             */
        }

            if (yCol(car)) {
                double currentspeedy = car.getCurrentSpeed();
                car.stopEngine();
            /*if(car.getDir() == Cars.Direction.SOUTH ){
                car.dir=Cars.Direction.NORTH;
            }
            else if(car.getDir() == Cars.Direction.NORTH ){
                car.dir=Cars.Direction.SOUTH;
            }
            car.startEngine();
            car.setCurrentSpeed(currentspeedy);*/
                switch (car.dir) {

                    case EAST:
                        car.dir = Cars.Direction.WEST;
                    case WEST:
                        car.dir = Cars.Direction.EAST;

                }
                car.startEngine();
                car.setCurrentSpeed(currentspeedy);


            }

        }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars
        ) {
            car.gas(gas);
        }

    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Cars car : cars
        )
            car.brake(brake);
    }
    void turboOn() {
        for (Cars car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    void turboOff() {
        for (Cars car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    void liftBed() {
        for (Cars truck : cars) {
            if (truck instanceof Scania)
                ((Scania)truck).incrementFlatBed();
        }
    }

    void lowerBed() {
        for (Cars truck : cars) {
            if (truck instanceof Scania)
                ((Scania)truck).decrementFlatBed();
        }
    }

    public void stopAllCars(){
        for (Cars car: cars){
            car.stopEngine();
        }
    }

    public void startAllCars(){
        for(Cars car:cars){
            car.startEngine();
        }
    }
}
