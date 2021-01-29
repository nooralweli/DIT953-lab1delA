import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarsTest  {
    private Cars volvo;
    @Before
    public void setUp() throws Exception {
        volvo = new Volvo240();
    }

    @Test
    public void startEngine() {
        volvo.startEngine();
        double speed  = volvo.getCurrentSpeed();
        assertTrue(0.1 == speed); // 0.1 == speed ?
    }

    @Test
    public void stopEngine() {
        volvo.stopEngine();
        double speed  = volvo.getCurrentSpeed();
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
}