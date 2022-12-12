package big_task2712_restaurant_manager.add;

import big_task2712_restaurant_manager.ConsoleHelper;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private final int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        ConsoleHelper.writeMassage("calling the processVideos method");
    }
}
