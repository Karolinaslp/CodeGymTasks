package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        final Cook cook = new Cook("Adam");
        tablet.addObserver(cook);

        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}
