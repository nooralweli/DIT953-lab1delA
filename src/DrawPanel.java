import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
   // BufferedImage rightCarImage=null;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    //ArrayList <BufferedImage> Stg carImage = new ArrayList<>();
    ArrayList<String> CarImage = new ArrayList<>();
    List<Point> CarPoint = List.of(new Point(), new Point(), new Point());

    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();
    Point carPoint  = new Point();

    // TODO: Make this genereal for all cars
    void moveit(int  x, int y, int i) {

        CarPoint.get(i).x=x;
        CarPoint.get(i).y=y;
    }
    /*List<Point>getList(){
        return CarPoint;
    }
    public modifyList(int i){
        getList();
    }
*/

    /*void imageChooser(Cars car) {
        if(car instanceof Volvo240){rightCarImage=volvoImage;}
        else if(car instanceof Saab95){rightCarImage=saabImage;}
        else if(car instanceof Scania){rightCarImage=scaniaImage;}
    }*/


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
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(volvoImage,(int)CarPoint.get(0).x,(int) CarPoint.get(0).y, null);
        g.drawImage(saabImage,(int) CarPoint.get(1).x,(int) CarPoint.get(1).y, null);
        g.drawImage(scaniaImage,(int) CarPoint.get(2).x,(int) CarPoint.get(2).y, null);




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

    /*  int i=0;
        for(String cartype : CarImage){

            if(cartype == "Volvo240") {
                g.drawImage(volvoImage, (int) CarPoint.get(i).getX(),(int) CarPoint.get(i).getY(), null);
            }
            else if(cartype == "Saab95") {
                g.drawImage(saabImage,(int) CarPoint.get(i).getX(),(int) CarPoint.get(i).getY(), null);
            }
            else if(cartype == "Scania") {
                g.drawImage(scaniaImage,(int) CarPoint.get(i).getX(),(int) CarPoint.get(i).getY(), null);
            }
            i++;
        }
*/
}
