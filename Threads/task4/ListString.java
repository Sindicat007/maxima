package task4;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.*;
import static java.util.concurrent.Executors.*;

public class ListString {
    private static List<Integer> randomNumber;
    private static final ConcurrentHashMap<Integer, Long> targetValueToResultFactorial = new ConcurrentHashMap<>();
    private static final AtomicLong startTime = new AtomicLong(System.nanoTime());

    public static void main(String[] args) throws InterruptedException, RuntimeException {
        long timeWorkThread;

        setRandomWords();
        startTime.set(System.nanoTime());
        for (Integer val : randomNumber) {
            putResultFactorial(val);
        }
        long timeWithoutThread = System.nanoTime() - startTime.get();

        printResultFactorial();

        ExecutorService exec = newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try (exec) {
            System.out.println("Начало работы");
            startTime.set(System.nanoTime());

            for (Integer val : randomNumber) {
                exec.execute(() -> {
                    putResultFactorial(val);
                    System.out.println();
                });
            }

            exec.shutdown();

            System.out.println("Пул потоков завершен: " + exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
            timeWorkThread = System.nanoTime() - startTime.get();
        }
        printResultFactorial();

        System.out.println("Время выполнения без потоков: " + (timeWithoutThread / 10000000.0));
        System.out.println("Время выполнения с потоками: " + (timeWorkThread / 10000000.0));
    }

    public static void putResultFactorial(int val) {
        System.out.printf("%s Вычисление факториала числа: %d началось%n", LocalTime.now(), val);

        targetValueToResultFactorial.put(val, factorial(val));

        System.out.printf("%s Вычисление факториала числа: %d завершилось%n", LocalTime.now(), val);
    }

    public static void printResultFactorial() {
        targetValueToResultFactorial.forEach((k, v) -> System.out.printf("Для числа %d, факториал: %d%n", k, v));
    }

    public static void setRandomWords() {
        randomNumber = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            randomNumber.add((int) round(random() * 20));
        }
    }

    public static long factorial(long n) {
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
