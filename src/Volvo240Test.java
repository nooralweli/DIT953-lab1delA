import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {
    private Volvo240 volvo;

    @Before
    public void setUp() throws Exception {
        volvo = new Volvo240();
    }

    @Test
    public void gas() {
        double amount = 1;
        double oldSpeed = volvo.getCurrentSpeed();
        volvo.gas(amount);
        double currentSpeed = volvo.getCurrentSpeed();
        assertTrue(currentSpeed >= oldSpeed);
    }

    @Test
    public void brake() {
        double amount = 1;
        double oldSpeed = volvo.getCurrentSpeed();
        volvo.brake(amount);
        double currentSpeed = volvo.getCurrentSpeed();
        assertTrue(currentSpeed <= oldSpeed);
    }
}