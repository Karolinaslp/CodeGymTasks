package big_task2712_restaurant_manager.kitchen;

import big_task2712_restaurant_manager.ConsoleHelper;
import big_task2712_restaurant_manager.statistics.StatisticsManager;
import big_task2712_restaurant_manager.statistics.event.OrderReadyEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private final String name;

    public Cook(String cookName) {
        this.name = cookName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        OrderReadyEventDataRow row = new OrderReadyEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticsManager.getInstance().record(row);
    }

    @Override
    public String toString() {
        return name;
    }
}

