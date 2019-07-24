package producer_consumer_problem;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueueUsingWait<T> {

    private Queue<T> queue;
    private int maxSize;

    public MyBlockingQueueUsingWait(int size) {
        queue = new LinkedList<>();
        this.maxSize = size;
    }

    public synchronized void put(T t) {
        try {
            while (queue.size() == maxSize) {
                wait();
            }
            queue.add(t);
            System.out.println("Produced " + t.toString());
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized T get() {
        try {
            while (queue.size() == 0) {
                wait();
            }
            T t = queue.remove();
            System.out.println("Consumed " + t.toString());
            notifyAll();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
