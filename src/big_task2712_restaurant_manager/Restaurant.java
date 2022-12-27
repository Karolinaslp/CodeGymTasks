package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.kitchen.Cook;
import big_task2712_restaurant_manager.statistics.StatisticsManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATION_INTERVAL = 100;

    public static void main(String[] args) {
        Cook cookMichal = new Cook("Michal");
        Cook cookKarolina = new Cook("Karolina");

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(cookMichal);
            tablet.addObserver(cookKarolina);
            tablets.add(tablet);
        }

        StatisticsManager.getInstance().register(cookMichal);
        StatisticsManager.getInstance().register(cookKarolina);

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

        ManagerTablet managerTablet = new ManagerTablet();
        managerTablet.printAdRevenue();
        managerTablet.printCookUtilization();
        managerTablet.printActiveVideoSet();
        managerTablet.printArchivedVideoSet();
    }
}
