package odd_even;

class PrintNumber {
    private int number;

    void printNumber() {
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " > " + number);
                number++;
                notifyAll();
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
