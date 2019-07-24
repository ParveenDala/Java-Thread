package producer_consumer_problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueUsingLock<T> {

    private Queue<T> queue;
    private int maxSize = 10;

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueueUsingLock(int size) {
        queue = new LinkedList<>();
        this.maxSize = size;
    }

    public void put(T t) {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                notFull.await();
            }
            queue.add(t);
            System.out.println("Produced " + t.toString());
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            T t = queue.remove();
            System.out.println("Consumed " + t.toString());
            notFull.signalAll();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
