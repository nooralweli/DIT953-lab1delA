package Modell;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a CarService
 */


public class CarService<T extends Cars> {
    //<T> the specified type of which cartype that should be
    //acceptable in each
    protected int MAX_LOAD;
    protected int currentLoad = 0;                            //The current load in the carservice
    protected List<T> carInService = new ArrayList<>();    //The cars we currently have in the carservice


    /*
     * Upon collection of a car from carservice, we need to get as specific typeinformation as possible static.
     */
    private final String staticMessageToCustomer;


    /**
     * A Constructor for the Carservice
     *
     * @param MAX_LOAD                Max load the car service can handle
     * @param staticMessageToCustomer a static message to the customers to inform that the car can be delivered off
     */
    public CarService(int MAX_LOAD, String staticMessageToCustomer) {
        this.MAX_LOAD = MAX_LOAD;
        //this.notAllowedCars = notAllowedCars;
        this.staticMessageToCustomer = staticMessageToCustomer;
    }


    /**
     * A method to load the car to the carservice
     *
     * @param car The car that will be loaded to the service
     */
    public void loadToService(T car) {
        if (currentLoad < MAX_LOAD) {
            carInService.add(car);      //lägger till bil i verkstaden
        }


    }


    /**
     * A method to return a car to its customer from the carservice
     * @param car the car that will be delivered off
     * @return returns a car
     */
    public T deliveryOfCar(T car) {

        int index = carInService.indexOf(car); // letar efter bilens index i våran array, om den ej finns så returnerar den -1
        if (index == -1) {
            System.out.println("Car not in service"); // om det är minus 1 så  skriver vi ut ett medd.
            return null;
        }

        carInService.remove(index); // removes the car from service i.e returns it
        //return staticMessaustomer; // printar ut customer message


        return car;

    }

}


