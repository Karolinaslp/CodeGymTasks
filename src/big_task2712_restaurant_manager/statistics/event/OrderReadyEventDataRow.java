package big_task2712_restaurant_manager.statistics.event;

import big_task2712_restaurant_manager.kitchen.Dish;

import java.util.Date;
import java.util.List;

public class OrderReadyEventDataRow implements EventDataRow{
    //Name of the tablet
    private final String tabletName;

    //Name of the cook
    private final String cookName;

    //Time required to prepare the order in seconds
    private final int cookingTimeSeconds;

    //The list of dishes to prepare
    private final List<Dish> dishesInOrder;

    private final Date currentDate;

    public OrderReadyEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> dishesInOrder) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.dishesInOrder = dishesInOrder;
        this.currentDate = new Date();
    }


    @Override
    public EventType getType() {
        return EventType.ORDER_READY;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return cookingTimeSeconds;
    }

    public String getCookName() {
        return cookName;
    }
}
