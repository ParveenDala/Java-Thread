package retrieve_price_from_n_sources;

import java.util.Random;
import java.util.Set;

public class Task implements Runnable {
    private int id;
    private String url;
    private Set<Integer> prices;

    Task(int id, String url, Set<Integer> prices) {
        this.id = id;
        this.url = url;
        this.prices = prices;
    }

    @Override
    public void run() {
        int price = 0;
        try {
            Thread.sleep(new Random().nextInt(5));
            price = new Random().nextInt(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prices.add(price);
    }
}
