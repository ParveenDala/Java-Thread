package producer_consumer_problem;

public class ProducerConsumer {

    //private MyBlockingQueueUsingLock<Item> itemList;
    private MyBlockingQueueUsingWait<Item> itemList;

    ProducerConsumer() {
        itemList = new MyBlockingQueueUsingWait<>(2);
    }

    void produce() {
        int id = 0;
        while (true) {
            itemList.put(new Item(id, Thread.class.getName() + " " + id));
            id++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void consume() {
        while (true) {
            itemList.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
