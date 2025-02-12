package task1;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    private static final AtomicInteger count = new AtomicInteger();

    public static void increment() {
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }

        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }

}
