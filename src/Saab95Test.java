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

}