package Modell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CarList extends ArrayList<Cars>{
    private ArrayList<Cars> cars;
    private ArrayList<ITurbo2> turboCars;
    private ArrayList<ITrucks> truckCars;
    public ArrayList<Observer> observers = new ArrayList<>();
    public void startTimer(){
        timer.start();
    }
    private final int delay = 50;

    private final Timer timer = new Timer(delay, new TimerListener());

    public ArrayList<Cars> getCars() {
        return cars;
    }

    public ArrayList<ITurbo2> getTurboCars() {
        return turboCars;
    }


    public CarList() {
        cars = new ArrayList<>();
        turboCars = new ArrayList<>();
        truckCars = new ArrayList<>();
    }

    public ArrayList<ITrucks> getTruckCars() {
        return truckCars;
    }

    public void addVolvo(int posX){
        Cars c = CarFactory.createVolvo();
        c.setPosX(posX);
        cars.add(c);
    }

    public void addSaab(int posX){
        Cars c = (Cars) CarFactory.createSaab();
        c.setPosX(posX);
        turboCars.add((ITurbo2) c);

    }

    public void addScania(int posX){
        Cars c = (Cars) CarFactory.createScania();
        c.setPosX(posX);
        truckCars.add((ITrucks) c);

    }

    public void gas(double amount) {
        for(Cars c : cars) {
            c.gas(amount);
        }
        for (ITurbo2  turboCar: turboCars) {
            Cars c = (Cars) turboCar;
            c.gas(amount);
        }
        for (ITrucks  trucks: truckCars) {
            Cars c = (Cars) trucks;
            c.gas(amount);
        }

    }
    public void brake(double amount) {
        for(Cars c : cars) {
            c.brake(amount);
        }
        for (ITurbo2  turboCar: turboCars) {
            Cars c = (Cars) turboCar;
            c.brake(amount);
        }
        for (ITrucks  trucks: truckCars) {
            Cars c = (Cars) trucks;
            c.brake(amount);
        }
    }
    public void move(){
        for (Cars car : cars) {
            car.move();
        }
        for (ITurbo2 turboCars : turboCars) {
            Cars c = (Cars) turboCars;
            c.move();
        }
        for (ITrucks trucks : truckCars) {
            Cars c = (Cars) trucks;
            c.move();
        }
    }
    public void setTurboOn(){
        for (ITurbo2 turboCars : turboCars) {
            turboCars.setTurboOn();
        }
    }
    public void setTurboOff(){
        for (ITurbo2 turboCars : turboCars) {
            turboCars.setTurboOff();
        }
    }
    public void lowerBed(){
        for (ITrucks trucks : truckCars) {
            trucks.decreaseFlatBed(5);
        }
    }
    public void liftBed() {
        for (ITrucks trucks : truckCars) {
            trucks.increaseFlatBed(2);
        }
    }
    public void stopAllCars() {
        for (Cars car : cars) {
            car.stopEngine();
        }
        for (ITrucks trucks : truckCars) {
            Cars car = (Cars) trucks;
            car.stopEngine();
        }
        for (ITurbo2 turboCars : turboCars) {
            Cars car = (Cars) turboCars;
            car.stopEngine();
        }
    }

    public void startAllCars() {
        for (Cars car : cars) {
            car.startEngine();
        }
        for (ITrucks trucks : truckCars) {
            Cars car = (Cars) trucks;
            car.startEngine();
        }
        for (ITurbo2 turboCars : turboCars) {
            Cars car = (Cars) turboCars;
            car.startEngine();
        }
    }

    public void addCar() {
        int nrOfCars = cars.size() + truckCars.size() + turboCars.size();
        if(nrOfCars < 10) {
            if(nrOfCars > 0) {
                addVolvo((int) (cars.get(cars.size() - 1).getPosX() + 100));
            }else{
                addVolvo(0);
            }
        }
    }

    public void removeCar() {
        int nrOfCars = cars.size() + truckCars.size() + turboCars.size();
        if (nrOfCars > 0) {
            cars.remove(nrOfCars - 1);
        }
    }
    public void notifyObserver () {

        for(Observer observer : observers){
            observer.update();

        }

    }
    private class TimerListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            for (Cars car : cars) {
                collisionCheck(car);
                //car.move();
                car.move();
                //System.out.println(car.toString() + " Position: " + car.getPosY());
            }
            for (ITurbo2 turboCar : turboCars) {
                collisionCheck(turboCar);
                turboCar.move();
                //System.out.println(turboCars.toString() + " Position: " + c.getPosY());
            }
            for (ITrucks trucks : truckCars) {
                collisionCheck((Cars)trucks);
                trucks.move();
            }
            notifyObserver();
        }
    }

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
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
