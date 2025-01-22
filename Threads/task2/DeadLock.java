package task2;

public class DeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1: стартует");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток 1: Ждет поток 2");
                synchronized (lock2) {
                    System.out.println("Поток 1: выполняет поток 2 ");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 2: стартует");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток 2: Ждет поток 1");
                synchronized (lock2) {
                    System.out.println("Поток 2: выполняет 1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
