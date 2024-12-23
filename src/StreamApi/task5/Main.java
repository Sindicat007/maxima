package StreamApi.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Agira", "Biuck", "Cedric", "Derick", "Eliz", "Ford"));

        //Проверьте, есть ли слова, начинающиеся с 'A', 'B' и 'C'
        List<String> listResult = list.stream()
                .filter(s -> s.startsWith("A") || s.startsWith("B") || s.startsWith("C"))
                .toList();

        System.out.println(listResult);

        //Убедитесь, что все слова имеют длину не менее 5 символов.
        List<String> moreThan5Char = list.stream()
                .filter(s -> s.length() > 4)
                .toList();

        System.out.println(moreThan5Char);

        //Найдите слово с максимальной длиной.
        String maxWords = list.stream()
                .max(Comparator.comparing(String::length))
                .orElse(null);

        System.out.println(maxWords);

    }
}
