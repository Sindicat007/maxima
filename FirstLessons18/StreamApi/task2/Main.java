package StreamApi.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Alice", "Bob", "Alice", "John", "Bob"));

        //Найдите все уникальные имена
        List<String> uniqueName = list.stream()
                .distinct()
                .toList();

        //Подсчитайте, сколько раз каждое имя встречается в списке.
        Map<String, Long> result = list.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        //Отсортируйте имена в алфавитном порядке и выведите их
        uniqueName.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
