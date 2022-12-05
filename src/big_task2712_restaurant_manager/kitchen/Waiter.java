package big_task2712_restaurant_manager.kitchen;

import big_task2712_restaurant_manager.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {
    @Override
    public void update(Observable o, Object order) {
        ConsoleHelper.writeMassage(order + " was prepared by " + o);
    }
}
