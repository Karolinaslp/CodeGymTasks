package big_task2712_restaurant_manager.add;

public class Advertisement {
    private final Object content;
    private final String name;
    private final long amountPaid;
    private final int impressionsRemaining;
    private final int duration;
    private final long amountPerImpression;


    public Advertisement(Object content, String name, long amountPaid, int impressionsRemaining, int duration) {
        this.content = content;
        this.name = name;
        this.amountPaid = amountPaid;
        this.impressionsRemaining = impressionsRemaining;
        this.duration = duration;
        amountPerImpression = amountPaid / impressionsRemaining;
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
}

