package big_task2909_refactoring_java.car;

public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}
