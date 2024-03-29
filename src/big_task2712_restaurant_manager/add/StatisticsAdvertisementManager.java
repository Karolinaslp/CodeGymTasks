package big_task2712_restaurant_manager.add;

import java.util.ArrayList;
import java.util.List;

public class StatisticsAdvertisementManager {
    private final static StatisticsAdvertisementManager ourInstance = new StatisticsAdvertisementManager();
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticsAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticsAdvertisementManager() {

    }

    public List<Advertisement> getVideoList(boolean isActive) {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (!isActive ^ advertisement.isActive()) {
                result.add(advertisement);

            }
        }
        return result;
    }
}

