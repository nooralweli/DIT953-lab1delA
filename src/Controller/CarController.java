package Controller;

import Modell.*;
import View.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    //protected Cars.Direction dir = Cars.Direction.NORTH;
    // The delay (ms) corresponds to 20 updates a sec (hz)


    // The frame that represents this instance View of the MVC pattern

    private CarList model;
    private final CarView frame;

    public CarController(CarView newFrame, CarList model) {
        this.model = model;
        frame = newFrame;
        initComponents();
    }



    // A list of cars, modify if needed


    //methods:

    public void initComponents(){
        frame.gasButton.addActionListener(e -> gas(frame.gasAmount));
        frame.brakeButton.addActionListener(e -> brake(frame.gasAmount));
        frame.lowerBedButton.addActionListener(e -> lowerBed());
        frame.liftBedButton.addActionListener(e -> liftBed());
        frame.startButton.addActionListener(e -> startAllCars());
        frame.stopButton.addActionListener(e -> stopAllCars());
        frame.turboOnButton.addActionListener(e -> turboOn());
        frame.turboOffButton.addActionListener(e -> turboOff());
        frame.addButton.addActionListener(e -> addCar());
        frame.removeButton.addActionListener(e -> removeCar());
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    /*private class TimerListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            for (Cars car : model.getCars()) {
                collisionCheck(car);
                //car.move();
                model.move();
                //System.out.println(car.toString() + " Position: " + car.getPosY());
            }
            for (ITurbo2 turboCars : model.getTurboCars()) {
                Cars c = (Cars) turboCars;
                collisionCheck(c);
                model.move();
                //System.out.println(turboCars.toString() + " Position: " + c.getPosY());
            }
            for (ITrucks trucks : model.getTruckCars()) {
                Cars c = (Cars) trucks;
                collisionCheck(c);
                model.move();
            }
           model.notifyObserver();
        }
    }*/

    boolean xCol(Cars car) {
        boolean xCollision = false;

        if (car.getDir() == Direction.EAST && car.getPosX() + car.getCurrentSpeed() > 800) {
            xCollision = true;

        } else if (car.getDir() == Direction.WEST && car.getPosX() - car.getCurrentSpeed() < 0) {
            xCollision = true;

        }
        return xCollision;
    }

    boolean yCol(Cars car) {
        boolean yCollision = false;

        if (car.getDir() == Direction.NORTH && car.getPosY() + car.getCurrentSpeed() > 560 - 60) {
            yCollision = true;

        }else if (car.getDir() == Direction.SOUTH && car.getPosY() - car.getCurrentSpeed() < 0) {
            yCollision = true;

        }
        return yCollision;
    }


    void collisionCheck(Cars car) {
        if (yCol(car)) {

            car.stopEngine();
            switch (car.getDir()) {
                case NORTH:
                    car.setPosY(560 - 60);
                    car.setDir(Direction.SOUTH);
                    break;

                case SOUTH:
                    car.setPosY(0);
                    car.setDir(Direction.NORTH);
                    break;

            }
            car.startEngine();
            car.gas(0);


        } else if (xCol(car)) {
            car.stopEngine();

            switch (car.getDir()) {

                case EAST:
                    car.setDir(Direction.WEST);
                    car.setPosX(800);
                    break;
                case WEST:
                    car.setDir(Direction.EAST);
                    car.setPosX(0);
                    break;

            }
            car.startEngine();
            car.gas(0);
        }
    }

    // Calls the gas method for each car once

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        model.gas(gas);
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        model.brake(brake);
    }

    public void turboOn() {
        model.setTurboOn();
    }

    public void turboOff() {
        model.setTurboOff();
    }

    public void addCar() {
        model.addCar();
    }
    public void removeCar() {
        model.removeCar();
    }

    public void liftBed() {
        model.liftBed();
    }

    public void lowerBed() {
        model.lowerBed();

    }

    public void stopAllCars() {
        model.stopAllCars();
    }

    public void startAllCars() {
        model.startAllCars();
    }
}