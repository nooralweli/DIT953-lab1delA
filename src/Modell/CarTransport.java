package Modell;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Math.abs;


public class CarTransport extends Trucks implements IContext, ITransporter {
    @Override
    public void setState(IState t) {
        state = t;
    }

    private enum Ramp {
        UP, DOWN
    }

    private IState state;

    private Ramp ramp = Ramp.UP; // default is up
    private final int MAX_LOAD = 3;
    private final int MAX_DISTANCE = 10;
    private final int MAX_SIZE = 20;
    private Deque<Cars> load = new ArrayDeque<>();

    /**
     * A constructor to build the car
     *
     */
    public CarTransport() {
        super(2, 400, Color.WHITE, "CarTransport", 25);
    }


    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp = Ramp.DOWN;
        }

    }

    public void raiseRamp() {
        ramp = Ramp.UP;
    }


    //En cartransport ska inte kunna anv'ndas som variabel i loadtransport
    //if (s.equals(t)) // RIGHT


    //En cartransport ska inte kunna anv'ndas som variabel i loadtransport
    public void loadTransport(Cars car) {

        // om bilen vi vill lasta är själva cartransport -> hoppa över
        //this = vi tar hela klassen "Cartransport"
        //bil som ska lastas på cartransport
        //bilarnas totala size ska vara max 20
        if (ramp == Ramp.DOWN && load.size() < MAX_LOAD && car.carSize <= MAX_SIZE) {
            double transportPosX = this.getPosX();
            double transportPosY = this.getPosY();
            double carPosX = car.getPosX();
            double carPosY = car.getPosY();
            /**
             *Under det att en bil är lastad på biltransporten ska dess position
             *i världen alltid vara densamma som biltransportens position.
             */
            if (abs(transportPosX - carPosX) < MAX_DISTANCE && abs(transportPosY - carPosY) < MAX_DISTANCE) {
                load.push(car);
            }
        }
    }


    public void offLoadTransport() {
        if (ramp == Ramp.DOWN && load.size() > 0) {
            double transportPosX = this.getPosX();
            double transportPosY = this.getPosY();
            Cars car = load.pop();
            car.setPosX(transportPosX + load.size() + 1);
            car.setPosY(transportPosY + load.size() + 1);
            //Vi sätter den nya positionen nära transportbilen o beroende av load size
            //Så kan man lasta av flera bilar utan att flytta på transportbilen så
            // de ej hamnar på samma position

        }

    }


    void test() {
        state.test(this);
        /*
        if(ramp == Ramp.UP) {
            //do something
        } else {
            //do something else
        }*/
    }

    @Override
    protected void incrementSpeed(double amount) {
        if (ramp == Ramp.UP) {
            setCurrentSpeed(getCurrentSpeed() + getEnginePower() * 0.01 * amount);
        }

    }

    @Override
    protected void decrementSpeed(double amount) {
        // är kravet att biltransporten ska inte kunna bromsa medans rampen är nere?
        setCurrentSpeed(getCurrentSpeed() - getEnginePower() * 0.01 * amount);
    }
}














/*

modellnamn filnamn

en ramp med två lägen///////////
kan endast vara nere om bilen står stilla,//////////
bilar kan endast lastas på om rampen är nere//////////
och de ska befinna sig nära bil transporten,
bilar kan endast lossas om rampen är nere,///////////

de ska hamna nära biltransporten,
kan endast lossas i first in last out,///////////
biltransporten ska inte kunna lasta på sig själv,
om en bil är lastad på transporten måste den alltid ha samma position som bilen



bilar ska kunna lastas av o på, max antal bilar, ////////////
dom får inte vara för stora.


//Biltransporten ska inte kunna lasta på sig själv =
//dvs. loadTransport(cartransport) = det ska inte gå





 */