package big_task2712_restaurant_manager.add;

public class Advertisement {
    private Object content;
    private String name;
    private long amountPaid;
    private int impressionsRemaining;
    private int duration;

    public Advertisement(Object content, String name, long amountPaid, int impressionsRemaining, int duration) {
        this.content = content;
        this.name = name;
        this.amountPaid = amountPaid;
        this.impressionsRemaining = impressionsRemaining;
        this.duration = duration;
    }
}

