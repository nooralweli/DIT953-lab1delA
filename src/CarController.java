import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    protected Cars.Direction dir = Cars.Direction.NORTH;
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
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        cc.cars.get(0).setPosX(0);
        cc.cars.get(1).setPosX(200);
        cc.cars.get(2).setPosX(400);


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

            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i) instanceof Volvo240) {
                    frame.drawPanel.CarImage.add("Volvo240");
                } else if (cars.get(i) instanceof  Saab95) {
                    frame.drawPanel.CarImage.add("Saab95");
                } else if (cars.get(i) instanceof Scania) {
                    frame.drawPanel.CarImage.add("Scania");
                }
                collisionCheck(cars.get(i));
                // frame.drawPanel.CarPoints.add(new Point(car.getPosX(),car.getPosY()));
                /* frame.drawPanel.imageChooser(car); */

                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).getPosX());
                int y = (int) Math.round(cars.get(i).getPosY());
                frame.drawPanel.moveit(x,y,i);


                //frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel


                System.out.println(cars.toString() + " Position: " + cars.get(i).getPosY());
            }
            frame.drawPanel.repaint();
        }
    }



    //}
    boolean xCol(Cars car) {
        boolean xCollision = false;

        if (car.dir == Cars.Direction.WEST && car.getPosX() + car.getCurrentSpeed() > 800) {

        } else if (car.dir == Cars.Direction.EAST && car.getPosX() + car.getCurrentSpeed() > 800) {
            xCollision = true;

        } else if (car.dir == Cars.Direction.EAST && car.getPosX() - car.getCurrentSpeed() < 0) {

        } else if (car.dir == Cars.Direction.WEST && car.getPosX() - car.getCurrentSpeed() < 0) {
            xCollision = true;

        }
        return xCollision;
    }

    boolean yCol(Cars car) {
        boolean yCollision = false;

        if (car.dir == Cars.Direction.NORTH && car.getPosY() + car.getCurrentSpeed() > 560 - 60) {
            yCollision = true;

        } else if (car.dir == Cars.Direction.SOUTH && car.getPosY() + car.getCurrentSpeed() > 560 - 60) {

        } else if (car.dir == Cars.Direction.SOUTH && car.getPosY() - car.getCurrentSpeed() < 0) {
            yCollision = true;

        } else if (car.dir == Cars.Direction.NORTH && car.getPosY() - car.getCurrentSpeed() < 0) {

        }
        return yCollision;
    }


    void collisionCheck(Cars car) {
        if (yCol(car)) {

            car.stopEngine();
            switch (car.dir) {
                case NORTH:
                    car.setPosY(560 - 60);
                    car.dir = Cars.Direction.SOUTH;
                    break;

                case SOUTH:
                    car.setPosY(0);
                    car.dir = Cars.Direction.NORTH;
                    break;

            }
            car.startEngine();
            car.gas(0);


        } else if (xCol(car)) {
            double currentSpeedX = car.getCurrentSpeed();
            car.stopEngine();

            switch (car.dir) {

                case EAST:
                    car.dir = Cars.Direction.WEST;
                    car.setPosX(800);
                    break;
                case WEST:
                    car.dir = Cars.Direction.EAST;
                    car.setPosX(0);
                    break;

            }
            car.startEngine();
            car.gas(0);
        }
    }
    /*
     * boolean collisionCheck(Cars car) {
     * boolean xCollision = -car.getCurrentSpeed() + car.getPosX() <= 0 || car.getCurrentSpeed() + car.getPosX() >= frame.drawPanel.getWidth();
     * boolean yCollision = car.getCurrentSpeed() + car.getPosX() >= 0 || car.getCurrentSpeed() + car.getPosY() > 800;
     * return xCollision && yCollision;
     * }
     */

         /*
         if(car.getDir() == Cars.Direction.SOUTH ){
                car.dir=Cars.Direction.NORTH;
            }
            else if(car.getDir() == Cars.Direction.NORTH ){
                car.dir=Cars.Direction.SOUTH;
            }
            car.startEngine();
            car.setCurrentSpeed(currentspeedy);

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
                ((Scania) truck).increaseFlatBed(2);
        }
    }

    void lowerBed() {
        for (Cars truck : cars) {
            if (truck instanceof Scania)
                ((Scania) truck).decreaseFlatBed(5);
        }
    }

    public void stopAllCars() {
        for (Cars car : cars) {
            car.stopEngine();
        }
    }

    public void startAllCars() {
        for (Cars car : cars) {
            car.startEngine();
        }
    }
}
