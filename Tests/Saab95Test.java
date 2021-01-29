import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {
    private Saab95 saab95;
    @Before
    public void setUp() throws Exception {
        saab95 = new Saab95();
    }

    @Test
    public void setTurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.isTurboOn() == true);
    }

    @Test
    public void setTurboOff() {

        saab95.setTurboOff();
        assertTrue(saab95.isTurboOn() == false);
    }

    @Test
    public void isTurboOn(){
        saab95.setTurboOn();
        assertTrue(saab95.isTurboOn()==true);
    }

    @Test
    public void incrementSpeed(){
        saab95.setCurrentSpeed(100);
        saab95.incrementSpeed(20);
        double result = 100 + 1.25 * 20;

        assertEquals(saab95.getCurrentSpeed(),result,0.00001);

    }

    @Test
    public void decrementSpeed(){
        saab95.setCurrentSpeed(100);
        saab95.decrementSpeed(20);
        double result = 100 - 1.25 * 20;

        assertEquals(saab95.getCurrentSpeed(),result,0.000001);
    }

}