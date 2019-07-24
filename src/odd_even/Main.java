package odd_even;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**************
 * Parveen D
 * Java Thread
 */
public class Main {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    printNumber.printNumber();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        threadPool.submit(task);
        threadPool.submit(task);

        threadPool.shutdown();
    }
}
