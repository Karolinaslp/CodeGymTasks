package big_task2712_restaurant_manager.kitchen;

import big_task2712_restaurant_manager.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private final String name;

    public Cook(String cookName) {
        this.name = cookName;
    }

    @Override
    public void update(Observable o, Object order) {
        ConsoleHelper.writeMassage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString() {
        return name;
    }
}

