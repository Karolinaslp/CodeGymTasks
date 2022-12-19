package big_task2712_restaurant_manager.statistics.event;

import java.util.Date;

public class NoVideosAvailableEventDataRow implements EventDataRow{
    //The time required to prepare the order in seconds
    private final int totalDuration;

    private final Date currentDate;

    public NoVideosAvailableEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;

        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.NO_VIDEOS_AVAILABLE;
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public int getTime() {
        return 0;
    }
}
