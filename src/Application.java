import Controller.CarController;
import Modell.CarFactory;
import Modell.CarList;
import View.CarView;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        CarList carlist = new CarList();


        carlist.addVolvo(0);
        carlist.addSaab(100);
        carlist.addScania(200);



        CarView view = new CarView("CarSim 1.0", carlist);
        carlist.addObserver(view);
        CarController cc = new CarController(view, carlist);

        // Start the timer

        carlist.startTimer();

    }
}