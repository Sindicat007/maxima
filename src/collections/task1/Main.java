package collections.task1;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Arrays.asList;

/**
 * 1: Операции addAll, containsAll, removeAll
 * <p>
 * Создайте два ArrayList: один с именами ваших пяти любимых фруктов, а второй - с пятью любимыми овощами.
 * <p>
 * Создайте LinkedList и используйте addAll для добавления всех элементов обоих ArrayList в LinkedList.
 * <p>
 * Проверьте, содержит ли LinkedList все элементы первого и второго списков с помощью containsAll. Выведите результаты проверки в консоль.
 * <p>
 * Используйте removeAll для удаления всех элементов второго списка (овощей) из LinkedList. Выведите содержимое LinkedList после удаления в консоль.
 */

public class Main {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>(asList("apple", "banana", "orange", "pear", "pineapple"));
        ArrayList<String> vegetables = new ArrayList<>(asList("carrot", "cucumber", "onion", "potato", "tomato"));
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addAll(fruits);
        linkedList.addAll(vegetables);

        System.out.println(linkedList.containsAll(fruits));
        System.out.println(linkedList.containsAll(vegetables));

        linkedList.removeAll(vegetables);
        System.out.println(linkedList);


    }
}
