package big_task2712_restaurant_manager.statistics;

import big_task2712_restaurant_manager.statistics.event.EventDataRow;

public class StatisticsManager {
    private static class InstanceHolder {
        private static final StatisticsManager instance = new StatisticsManager();
    }

    public static StatisticsManager getInstance() {
        return InstanceHolder.instance;
    }

    private StatisticsManager() {
        Object someStatistic = new Object();
    }

    public void record(EventDataRow dataRow) {

    }
}
