package big_task2712_restaurant_manager;

import big_task2712_restaurant_manager.add.Advertisement;
import big_task2712_restaurant_manager.add.StatisticsAdvertisementManager;
import big_task2712_restaurant_manager.statistics.StatisticsManager;

import java.util.*;

public class ManagerTablet {

    public void printAdRevenue() {
        StatisticsManager statisticsManager = StatisticsManager.getInstance();
        Map<String, Long> profitMap = statisticsManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            long aLong = profitMap.get(key);
            System.out.println(key + " - " + (aLong / 100) + "." + (aLong % 100));
        }
    }

    public void printCookUtilization() {
        StatisticsManager statisticsManager = StatisticsManager.getInstance();
        Map<String, Map<String, Integer>> cookWorkloadingMap = statisticsManager.getCookWorkloadingMap();
        ArrayList<String> list = new ArrayList(cookWorkloadingMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            Map<String, Integer> cookMap = cookWorkloadingMap.get(key);
            System.out.println(key);

            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }

            System.out.println();
        }
    }


    public void printActiveVideoSet() {
        List<Advertisement> videoList = StatisticsAdvertisementManager.getInstance().getVideoList(true);
        Collections.sort(videoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });

        for (Advertisement advertisement : videoList) {
            System.out.println(advertisement.getName() + " - " + advertisement.getHits());
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> videoList = StatisticsAdvertisementManager.getInstance().getVideoList(false);
        Collections.sort(videoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });

        for (Advertisement advertisement : videoList) {
            System.out.println(advertisement.getName());
        }
    }
}
