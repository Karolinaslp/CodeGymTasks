package big_task2909_refactoring_java.car;

public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }
}

