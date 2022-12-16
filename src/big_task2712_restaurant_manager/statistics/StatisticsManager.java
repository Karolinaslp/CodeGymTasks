package big_task2712_restaurant_manager.statistics;

import big_task2712_restaurant_manager.statistics.event.EventDataRow;
import big_task2712_restaurant_manager.statistics.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsManager {
    private final static StatisticsManager ourInstance = new StatisticsManager();

    public static StatisticsManager getInstance() {
        return ourInstance;
    }

    private final StatisticsStorage statisticsStorage = new StatisticsStorage();

    private StatisticsManager() {
    }

    public void record(EventDataRow dataRow) {
    }

    private static class StatisticsStorage {
        private final Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticsStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<>());
            }
        }
    }
}
