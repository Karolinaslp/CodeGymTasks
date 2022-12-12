package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.add.AdvertisementManager;
import big_task2712_restaurant_manager.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    //Tablet number
    private final int number;
    private static final Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    //Creates an order consisting of the dishes chosen by the customer.
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (order.isEmpty()){
                return null;
            }
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            advertisementManager.processVideos();
            setChanged();
            notifyObservers(order);
        }catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}