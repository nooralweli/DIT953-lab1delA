import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage rightCarImage=null;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;


    ArrayList <String> CarImage = new ArrayList<>();
    ArrayList <Point> CarPoints = new ArrayList<>();
    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();
    Point carPoint  =new Point();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
            carPoint.x=x;
            carPoint.y=y;
        }

       /* volvoPoint.x = x;
        volvoPoint.y = y;
        saabPoint.x = x;
        saabPoint.y = y;
        scaniaPoint.x = x;
        scaniaPoint.y = y;*/
    }

    void imageChooser(Cars car) {
        if(car instanceof Volvo240){rightCarImage=volvoImage;}
        else if(car instanceof Saab95){rightCarImage=saabImage;}
        else if(car instanceof Scania){rightCarImage=scaniaImage;}
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g, Point p, Cars car) {

        super.paintComponent(g);
        int i=0;
        for(String cartype : CarImage){

            if(cartype == "Volvo240") {
                g.drawImage(volvoImage, p.x, p.y, null);
            }
            else if(cartype == "Saab95") {
                g.drawImage(saabImage, CarPoints.get(i).getX(), CarPoints.get(i).getY(), null);
            }
            else if(cartype == "Scania") {
                g.drawImage(scaniaImage, CarPoints.get(i).getX(), CarPoints.get(i).getY(), null);
            }
            i++;
        }

        // see javadoc for more info on the parameters

    }
/*    @Override
    protected void paintComponent(Graphics g, Point p, Cars car) {

        super.paintComponent(g);
        int i=0;
        for(String cartype : CarImage){

            if(cartype == "Volvo240") {
                g.drawImage(volvoImage, CarPoints.get(i).getX(), CarPoints.get(i).getY(), null);
            }
            else if(cartype == "Saab95") {
                g.drawImage(saabImage, CarPoints.get(i).getX(), CarPoints.get(i).getY(), null);
            }
            else if(cartype == "Scania") {
                g.drawImage(scaniaImage, CarPoints.get(i).getX(), CarPoints.get(i).getY(), null);
            }
            i++;
        }

        // see javadoc for more info on the parameters

    }*/
}

