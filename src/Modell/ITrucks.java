package Modell;

public interface ITrucks extends Movable{
    void increaseFlatBed(int angle);
    void decreaseFlatBed(int angle);
    void adjustBedAngle(int newAngle);
}
