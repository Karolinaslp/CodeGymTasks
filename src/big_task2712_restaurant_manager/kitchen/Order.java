package big_task2712_restaurant_manager.kitchen;

import big_task2712_restaurant_manager.ConsoleHelper;
import big_task2712_restaurant_manager.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(toString());
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Start cooking - ");
        if (dishes.isEmpty()) return result.toString();
        result.append("Your order: [").append(dishes.get(0));

        for (int i = 1; i < dishes.size(); i++) {
            result.append(", ").append(dishes.get(i).name());
        }
        result.append("] from ").append(tablet);
        result.append(", cooking time ").append(getTotalCookingTime()).append(" min");
        return result.toString();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
