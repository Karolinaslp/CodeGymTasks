package big_task2712_restaurant_manager.add;

public class Advertisement {
    //The video.
    private final Object content;

    private final String name;

    //The amount paid for ads in cents.
    private final long amountPaid;

    //The number of impressions that have been paid for but not shown.
    private int impressionsRemaining;

    //The duration in seconds.
    private final int duration;

    private long amountPerImpression;


    public Advertisement(Object content, String name, long amountPaid, int impressionsRemaining, int duration) {
        this.content = content;
        this.name = name;
        this.amountPaid = amountPaid;
        this.impressionsRemaining = impressionsRemaining;
        this.duration = duration;
        if (impressionsRemaining > 0) {
            amountPerImpression = amountPaid / impressionsRemaining;
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerImpression() {
        return amountPerImpression;
    }

    public void revalidate() {
        if (impressionsRemaining == 0) {
            throw new UnsupportedOperationException();
        }
        impressionsRemaining--;
    }

    public boolean isActive() {
        return impressionsRemaining > 0;
    }
}

