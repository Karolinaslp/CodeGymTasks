package big_task2712_restaurant_manager.kitchen;

import big_task2712_restaurant_manager.ConsoleHelper;
import big_task2712_restaurant_manager.Tablet;
import big_task2712_restaurant_manager.statistics.StatisticsManager;
import big_task2712_restaurant_manager.statistics.event.OrderReadyEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

//This class is consumer
public class Cook extends Observable implements Runnable {
    private final String name;

    private boolean busy;

    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>(200);

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public LinkedBlockingQueue<Order> getQueue() {
        return queue;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        this.busy = true;

        Tablet tablet = order.getTablet();

        ConsoleHelper.writeMessage("Start cooking - " + order);

        int totalCookingTime = order.getTotalCookingTime();
        OrderReadyEventDataRow row = new OrderReadyEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticsManager.getInstance().record(row);

        try {
            Thread.sleep(totalCookingTime * 10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setChanged();
        notifyObservers(order);
        this.busy = false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                if (!queue.isEmpty()) {
                    if (!this.isBusy()) {
                        this.startCookingOrder(queue.take());
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}

