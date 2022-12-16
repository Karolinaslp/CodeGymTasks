package big_task2712_restaurant_manager.statistics;

import big_task2712_restaurant_manager.statistics.event.EventDataRow;
import big_task2712_restaurant_manager.statistics.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsManager {
    private static StatisticsManager ourInstance = new StatisticsManager();

    public static StatisticsManager getInstance() {
        return ourInstance;
    }

    private StatisticsStorage statisticsStorage = new StatisticsStorage();

    private StatisticsManager() {
    }

    private class StatisticsStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticsStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            EventType type = data.getType();
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            this.storage.get(type).add(data);
        }
    }

    public void record(EventDataRow data) {
        this.statisticsStorage.put(data);
    }
}