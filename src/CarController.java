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

    /*void collisionCheck(Cars car){
        boolean collidedX;
        boolean collidedY;
        if(car.getPosX() >= 800+(car.getCarSize()/2)) {
        car.currentspeed + car.getposX() <=0 ||
        }*/

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
