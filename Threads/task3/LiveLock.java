package task3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LiveLock {

    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);


    public static void main(String[] args) {
        LiveLock liveLock = new LiveLock();
        Thread thread1 = new Thread(() -> {
            try {
                liveLock.operation1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                liveLock.operation2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }

    public void operation1() throws InterruptedException {
        int counter = 0;
        while (true) {
            lock1.tryLock(1000, TimeUnit.SECONDS);
            System.out.println("Поток 1 запущен");
            sleep(1000);

            if (lock2.tryLock()) {
                System.out.println("Поток 2 запущен");
            } else {
                counter++;
                if ((counter > 5)) {
                    System.out.println("Превышен лимит попыток запуска потока 2");
                    lock1.unlock();
                    break;
                }
                System.out.println("Поток 2 не запущен");
                lock1.unlock();
                continue;
            }
            System.out.println("Поток 1 завершен");
            break;
        }
    }

    public void operation2() throws InterruptedException {
        int counter = 0;
        while (true) {
            lock2.tryLock(1000, TimeUnit.SECONDS);
            System.out.println("Поток 2 запущен");
            sleep(1000);
            if (lock1.tryLock()) {
                System.out.println("Поток 1 запущен");
            } else {
                counter++;
                if ((counter > 5)) {
                    System.out.println("Превышен лимит попыток запуска потока 1");
                    lock2.unlock();
                    break;
                }
                System.out.println("Поток 1 не запущен");
                lock2.unlock();
            }
        }
    }
}
