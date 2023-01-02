package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.add.AdvertisementManager;
import big_task2712_restaurant_manager.add.NoVideoAvailableException;
import big_task2712_restaurant_manager.kitchen.Order;
import big_task2712_restaurant_manager.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        } catch (NoVideoAvailableException nve) {
            logger.log(Level.INFO, "No video is available for the following order: " + order);
        }
    }

    private boolean processOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        if (order.isEmpty()) {
            return true;
        }
        queue.offer(order);

        new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        return false;
    }

    public void createTestOrder() {
        Order order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available foe the following order: " + order);
        }
    }

    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
}
