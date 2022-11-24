package big_task2712_restaurant_manager.kitchen;

import big_task2712_restaurant_manager.Tablet;

import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) {
        this.tablet = tablet;
    }
}
