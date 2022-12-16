package big_task2712_restaurant_manager.add;

import big_task2712_restaurant_manager.ConsoleHelper;
import big_task2712_restaurant_manager.statistics.StatisticsManager;
import big_task2712_restaurant_manager.statistics.event.VideosSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        this.totalTimeSecondsLeft = Integer.MAX_VALUE;
        obtainOptimalVideoSet(new ArrayList<>(), timeSeconds, 0L);

        VideosSelectedEventDataRow row = new VideosSelectedEventDataRow(optimalVideoSet, maxAmount, timeSeconds - totalTimeSecondsLeft);
        StatisticsManager.getInstance().record(row);

        displayAdvertisement();
    }

    //recursion
    private long maxAmount;
    private List<Advertisement> optimalVideoSet;
    private int totalTimeSecondsLeft;

    private void obtainOptimalVideoSet(
            List<Advertisement> totalList,
            int currentTimeSecondLeft,
            long currentAmount
    ) {
        if (currentTimeSecondLeft < 0) {
            return;
        } else if (currentAmount > maxAmount
                || currentAmount == maxAmount
                && (totalTimeSecondsLeft > currentTimeSecondLeft
                || totalTimeSecondsLeft == currentTimeSecondLeft
                && totalList.size() < optimalVideoSet.size())
        ) {
            this.totalTimeSecondsLeft = currentTimeSecondLeft;
            this.optimalVideoSet = totalList;
            this.maxAmount = currentAmount;
            if (currentTimeSecondLeft == 0) {
                return;
            }
        }

        ArrayList<Advertisement> temporary = getActualAdvertisements();
        temporary.removeAll(totalList);
        for (Advertisement ad : temporary) {
            if (!ad.isActive()) continue;
            ArrayList<Advertisement> currentList = new ArrayList<>(totalList);
            currentList.add(ad);
            obtainOptimalVideoSet(currentList, currentTimeSecondLeft - ad.getDuration(), currentAmount + ad.getAmountPerImpression());
        }
    }

    private ArrayList<Advertisement> getActualAdvertisements() {
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.isActive()) {
                advertisements.add(ad);
            }
        }
        return advertisements;
    }

    private void displayAdvertisement() {
        //TODO displaying
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Collections.sort(optimalVideoSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long l = o2.getAmountPerImpression() - o1.getAmountPerImpression();
                return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
            }
        });

        for (Advertisement ad : optimalVideoSet) {
            displayInPlayer(ad);
            ad.revalidate();
        }
    }

    private void displayInPlayer(Advertisement advertisement) {
        //TODO get Player instance and display content
        System.out.println("Displaying "
                + advertisement.getName()
                + "... "
                + advertisement.getAmountPerImpression()
                + ", "
                + (1000 * advertisement.getAmountPerImpression() / advertisement.getDuration())
        );
    }
}
