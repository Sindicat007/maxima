package StreamApi.task3;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new Random()
                .ints(20, 1, 100)
                .boxed()
                .toList();

        //Отфильтруйте только четные числа.
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();

        System.out.println("Четные " + evenNumbers);

        //Найдите сумму всех чисел, кратных 5.
        int multiply5 = numbers.stream()
                .filter(number -> number % 5 == 0)
                .mapToInt(number -> number)
                .sum();

        System.out.println("Сумма чисел кратных 5" + multiply5);

        //Возведите каждое число в квадрат и соберите их в новый список.
        List<Integer> squareNumber = numbers.stream()
                .map(number -> number * number)
                .toList();

        System.out.println("Квадрат числа" + squareNumber);

        //Определите, есть ли в списке хотя бы одно число больше 50.
        boolean other50 = numbers.stream()
                .anyMatch(number -> number > 50);

        System.out.println(other50);
    }
}
