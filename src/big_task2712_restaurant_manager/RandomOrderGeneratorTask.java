package big_task2712_restaurant_manager;

import java.util.List;
import java.util.ArrayList;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets = new ArrayList<>();
    private final int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int k = (int) (Math.random() * tablets.size());
                Tablet expected = tablets.get(k);
                expected.createTestOrder();
                Thread.sleep(interval);
            }
        }catch (InterruptedException e){

        }
    }
}
