package OopDop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human alex = new Human("Алексей", "Алхутов", 36);
        Human victor = new Human("Виктор", "Цой", 62);
        Human ivan = new Human("Иван", "Моря", 37);

        ArrayList<Human> people = new ArrayList<>(3);
        people.addAll(List.of(alex, victor, ivan));
        people.sort(Comparator.comparing(Human::getAge));

        for (Human item : people) {
            System.out.println(item);
        }
    }
}
