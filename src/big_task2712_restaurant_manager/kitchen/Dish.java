package big_task2712_restaurant_manager.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private final int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        String result = "";

        for (Dish dish : Dish.values()) {
            if ("".equals(result)) {
                result += dish.name();
            } else {
                result += ", " + dish.name();
            }
        }
        return result;
    }
}
