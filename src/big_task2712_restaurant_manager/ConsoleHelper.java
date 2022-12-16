package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.kitchen.Dish;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String massage) {
        System.out.println(massage);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        ConsoleHelper.writeMessage("Please choose a dish from the list:" + Dish.allDishesToString() + "\n or type 'exit' to complete the order");
        while(true) {
            String dishName = ConsoleHelper.readString().trim();
            if ("exit".equals(dishName)) {
                break;
            }

            try {
                Dish dish = Dish.valueOf(dishName);
                dishes.add(dish);
                writeMessage(dishName + " has been successfully added to your order");
            } catch (Exception e) {
                writeMessage(dishName + " hasn't been detected");
            }
        }

        return dishes;
    }
}
