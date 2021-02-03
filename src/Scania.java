import java.awt.*;

//funktioner sänka och höja
//increaseflatbedAngle = för att höja
//decreaseflatBedAngle = för att sänka
//[0,70] = 0<=flatbedAngle <= 70
//i metoden increamentspeed =Flaket ska inte kunna höjas om lastbilen är i rörelse
//i metoden decreamentspeed=Flaket ska inte kunna höjas om lastbilen är i rörelse
//if (flatbedAngle == 0) bla bla


public class Scania extends Cars {
    //flakets vinkel
    private double flatBedAngle = 0;
    private double speedFactor = 200;

    public Scania() {
        super(2, 200, Color.white, "Scania");
        stopEngine();
    }

    /*public void AdjustFlatBedAngle() {
        if (flatBedAngle > 70) {
            flatBedAngle = 70;
        } else if (flatBedAngle < 0) {
            flatBedAngle = 0;
        }
    }

    public void decreaseFlatBed(double angle) {
        if (getCurrentSpeed() == 0) {
            double currentAngle = flatBedAngle;
            flatBedAngle -= angle;
            AdjustFlatBedAngle();
            if (currentAngle < flatBedAngle) {
                flatBedAngle = currentAngle;

            }
        }
    }
    public void increaseFlatBed ( double angle) {
        if (getCurrentSpeed() == 0) {
            double currentAngle = flatBedAngle;
            flatBedAngle += angle;
            AdjustFlatBedAngle();
            if (currentAngle > flatBedAngle) {
                flatBedAngle = currentAngle;

            }
        }
    }



 public void manipulateAngle(double angle) {
    if (getCurrentSpeed() == 0) {
        if (flatBedAngle+angle <= 70 && flatBedAngle+angle>= 0) {
            flatBedAngle += angle;
        }

        else{
            AdjustFlatBedAngle();
        }
    }
 }
 */



    @Override
    protected void incrementSpeed ( double amount){
        if (flatBedAngle == 0) {
            setCurrentSpeed(getCurrentSpeed() + getEnginePower() * 0.01 * amount);

            double newSpeed = getCurrentSpeed();
            if (newSpeed > getEnginePower()) {
                setCurrentSpeed(getEnginePower());
            }
        }
    }

    @Override
    protected void decrementSpeed ( double amount){
        setCurrentSpeed(getCurrentSpeed() - getEnginePower() * 0.01 * amount);

        double newSpeed = getCurrentSpeed();
        if (newSpeed < 0) {
            setCurrentSpeed(0);
        }
    }


}
