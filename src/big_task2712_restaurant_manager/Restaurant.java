package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.kitchen.Cook;
import big_task2712_restaurant_manager.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        final Cook cook = new Cook("Adam");
        final Waiter waiter = new Waiter();
        tablet.addObserver(cook);
        cook.addObserver(waiter);

        tablet.createOrder();
    }
}
