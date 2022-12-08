package big_task2712_restaurant_manager.add;

public class AdvertisementStorage {
    private static class  InstanceHolder {
        private static final AdvertisementStorage instance = new AdvertisementStorage();
    }
    public static AdvertisementStorage getInstance() {
        return InstanceHolder.instance;
    }
    private AdvertisementStorage() {
    }
}