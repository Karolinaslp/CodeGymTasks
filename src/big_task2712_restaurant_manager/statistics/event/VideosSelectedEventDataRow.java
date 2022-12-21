package big_task2712_restaurant_manager.statistics.event;

import big_task2712_restaurant_manager.add.Advertisement;

import java.util.Date;
import java.util.List;

public class VideosSelectedEventDataRow implements EventDataRow {
    //The amount of money in cents
    private final long amount;

    //The list of videos chosen for playback
    private final List<Advertisement> optimalVideoSet;

    //the total duration of the chosen commercials
    private final int totalDuration;

    private final Date currentDate;

    public VideosSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.VIDEOS_SELECTED;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    public long getAmount() {
        return amount;
    }
}

