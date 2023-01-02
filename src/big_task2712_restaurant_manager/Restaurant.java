package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.kitchen.Cook;
import big_task2712_restaurant_manager.kitchen.Order;
import big_task2712_restaurant_manager.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATION_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(200);

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i + 1);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }

        Cook cookMichal = new Cook("Michal");
        cookMichal.setQueue(orderQueue);
        Cook cookKarolina = new Cook("Karolina");
        cookKarolina.setQueue(orderQueue);

        Waiter waiter = new Waiter();
        cookMichal.addObserver(waiter);
        cookKarolina.addObserver(waiter);

        Thread cookMichalThread = new Thread(cookMichal);
        cookMichalThread.start();

        Thread cookKarolinaThread = new Thread(cookKarolina);
        cookKarolinaThread.start();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATION_INTERVAL));
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Show statistics
        ManagerTablet managerTablet = new ManagerTablet();
        managerTablet.printAdRevenue();
        managerTablet.printCookUtilization();
        managerTablet.printActiveVideoSet();
        managerTablet.printArchivedVideoSet();
    }
}
