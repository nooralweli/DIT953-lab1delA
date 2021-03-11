package View;

import Modell.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize

    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    private CarList model;

    /**
     * Returns car-image based on modelName.
     */
    public BufferedImage getImage(String modelName) {
        switch (modelName) {
            case "Volvo240":
                return volvoImage;
            case "Saab95":
                return saabImage;
            case "Scania":
                return scaniaImage;
            default:
                return volvoImage;
        }
    }


    // TODO: Make this genereal for all cars


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarList model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "View.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: View.pics -> MOVE *.jpg to View.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.


        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);

            for (Cars car : model.getCars()) {
                BufferedImage img = getImage(car.getModelName());
                int x = (int) car.getPosX();
                int y = (int) car.getPosY();
                g.drawImage(img, x, y, null);
            }
            for (ITurbo2 turboCars : model.getTurboCars()) {
                Cars car = (Cars) turboCars;
                BufferedImage img = getImage(car.getModelName());
                int x = (int) car.getPosX();
                int y = (int) car.getPosY();
                g.drawImage(img, x, y, null);
            }
            for (ITrucks trucks : model.getTruckCars()) {
                Cars car = (Cars) trucks;
                BufferedImage img = getImage(car.getModelName());
                int x = (int) car.getPosX();
                int y = (int) car.getPosY();
                g.drawImage(img, x, y, null);
            }


            // see javadoc for more info on the parameters

        }

    }


