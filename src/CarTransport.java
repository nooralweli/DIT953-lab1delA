import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransport extends Cars {

    private boolean ramp;

    /**
     * A constructor to build the car
     *
     * @param nrDoors     Number of doors on the car
     * @param enginePower Engine power of the car
     * @param color       Color of the car
     * @param modelName   The car model name
     */
    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        super(2 , 400,Color.WHITE, "CarTransport");


    }


    public void lowerRamp(){
        if(getCurrentSpeed()==0){
            ramp = true;
        }

    }

    public void raiseRamp(){
            ramp = false;
        }


    public void loadTransport(Cars car){
        if(ramp && load.size()<3){
            load.push(car);

        }
    }

    public void offLoadTransport(){
        if(ramp){
            load.pop();
        }


    }

    Deque<Cars> load = new ArrayDeque<>();

    @Override
    protected void incrementSpeed(double amount) {

    }

    @Override
    protected void decrementSpeed(double amount) {

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







 */