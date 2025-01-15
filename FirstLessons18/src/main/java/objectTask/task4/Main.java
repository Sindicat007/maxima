package objectTask.task4;

import java.util.LinkedList;
import java.util.List;

/**
 * Задание 4: Ограничения обобщенных типов
 * <p>
 * Создайте обобщенный метод sumOfList, который принимает List элементов, расширяющих класс Number
 * double sumOfList(List<? extends Number> list),
 * и возвращает их сумму в виде double.
 * <p>
 * Убедитесь, что ваш метод работает как с List<Integer>, так и с List<Double>.
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> listInt = new LinkedList<>();
        List<Double> listDouble = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            listInt.add(i, i + 1);
        }
        System.out.println(sumOfList(listInt));

        for (int i = 0; i < 10; i++) {
            listDouble.add(i, i + 1.0);
        }
        System.out.println(sumOfList(listDouble));
    }

    public static double sumOfList(List<? extends Number> list) {
        double result = 0.0;
        for (Number number : list) {
            result += number.doubleValue();
        }
        return result;
    }
}
