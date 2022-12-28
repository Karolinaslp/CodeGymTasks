package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.kitchen.Cook;
import big_task2712_restaurant_manager.kitchen.Order;
import big_task2712_restaurant_manager.statistics.StatisticsManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(200);

    public OrderManager() {
        Thread thread = new Thread(() -> {
            Set<Cook> cooks = StatisticsManager.getInstance().getCooks();
            try {
                while (true) {
                    Thread.sleep(10);
                    if (!orderQueue.isEmpty()) {
                        for (Cook cook : cooks) {
                            if (!cook.isBusy()) {
                                cook.startCookingOrder(orderQueue.take());

                            }
                        }
                    }
                }
            }catch (InterruptedException e) {
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}

