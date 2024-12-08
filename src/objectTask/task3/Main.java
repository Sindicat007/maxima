package objectTask.task3;

import java.util.LinkedList;
import java.util.List;

/**
 * Задание 3: Реализация обобщенного метода.
 * <p>
 * Реализуйте статический обобщенный метод swap, который принимает список любого типа и два индекса,
 * и меняет местами элементы, находящиеся в этих индексах.
 * <p>
 * Протестируйте метод на списках различных типов (например, Integer и String).
 **/

public class Main {
    public static void main(String[] args) {
        List<String> listStrings = new LinkedList<>();
        List<Integer> listNum = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            listStrings.add(i, "Номер " + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            listNum.add(i, i + 1);
        }

        System.out.println(listStrings);
        swap(listStrings, 3, 5);
        System.out.println(listStrings);

        System.out.println(listNum);
        swap(listNum, 2, 4);
        System.out.println(listNum);
    }

    public static <T> void swap(List<T> list, int index1, int index2) {
        T buf;
        if (list != null && index1 >= 0 && index2 >= 0) {
            buf = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, buf);
        }
    }
}
