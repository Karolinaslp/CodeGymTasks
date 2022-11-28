package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.kitchen.Dish;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMassage(String massage) {
        System.out.println(massage);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();

        writeMassage("Enter: \"exit\" to exit");
        writeMassage("Please, select a dish and add it to the list:");
        writeMassage(Dish.allDishesToString());

        while (true) {
            String dishName = readString().trim();
            if ("exit".equals(dishName)) break;

            try {
                Dish dish = Dish.valueOf(dishName);
                dishes.add(dish);
                writeMassage(dishName + " has been successfully added to your order");
            } catch (Exception e) {
                writeMassage(dishName + " hasn't been detected");
            }
        }
        return dishes;
    }
}
