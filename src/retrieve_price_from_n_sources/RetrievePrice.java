package retrieve_price_from_n_sources;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class RetrievePrice {

    Set<Integer> getPrices() {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task(1, "flipkart", prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task(1, "flipkart", prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task(1, "flipkart", prices));
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        try {
            allTasks.get(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prices;
    }
}