import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarsTest {
    private Cars volvo;


    @Before
    public void setUp() throws Exception {
        volvo = new Volvo240();

    }

    @Test
    public void startEngine() {
        volvo.startEngine();
        double speed = volvo.getCurrentSpeed();
        assertTrue(0.1 == speed); // 0.1 == speed ?
    }

    @Test
    public void stopEngine() {
        volvo.stopEngine();
        double speed = volvo.getCurrentSpeed();
        assertTrue(0 == speed); // 0.0 == speed ?
    }

    @Test
    public void turnRight() {
        // north as defult
        volvo.turnRight();
        assertTrue(Cars.Direction.EAST == volvo.getDir());
    }

    @Test
    public void turnLeft() {
        // north as defult
        volvo.turnLeft();
        assertTrue(Cars.Direction.WEST == volvo.getDir());
    }


    @Test
    public void move() {
        volvo.setCurrentSpeed(1);
        volvo.move(); // we move north with speed 1
        assertTrue(1 == volvo.getPosY() && 0 == volvo.getPosX());
    }

    @Test
    public void gas() {
        double currentSpeed = volvo.getCurrentSpeed();
        volvo.gas(0.5);
        double newSpeed = volvo.getCurrentSpeed();
        assertTrue(newSpeed > currentSpeed);
    }

    @Test
    public void brake() {
        volvo.gas(0.5);
        double currentSpeed = volvo.getCurrentSpeed();
        volvo.brake(0.1);
        double newSpeed = volvo.getCurrentSpeed();
        assertTrue(currentSpeed > newSpeed);
    }

    @Test
    public void setColor() {
        volvo.setColor(Color.green);
        assertEquals(volvo.getColor(), Color.green);
    }


    @Test
    public void getColor() {
        volvo.setColor(Color.green);
        assertEquals(volvo.getColor(), Color.green);
    }

    @Test
    public void getEnginePower() {
        volvo.setEnginePower(100);
        assertTrue(volvo.getEnginePower() == 100);

    }


    @Test

    public void getPosX() {
        volvo.setPosX(1);
        assertTrue(volvo.getPosX() == 1);
    }

    @Test

    public void getPosY() {
        volvo.setPosY(1);
        assertTrue(volvo.getPosY() == 1);
    }


    @Test

    public void getNrDoors() {
        volvo.setNrDoors(4);
        assertEquals(volvo.getNrDoors(),4);

    }
}

