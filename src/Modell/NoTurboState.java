package Modell;

public class NoTurboState implements IState {
    @Override
    public void test(IContext context) {

    }

    @Override
    public double  stateSpeedFactor() {
        return  1.0;
    }
}
