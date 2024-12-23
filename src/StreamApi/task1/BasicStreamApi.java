package StreamApi.task1;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStreamApi {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Иванов", "Иван", 25));
        people.add(new Person("Кузнецов", "Кузьма", 40));
        people.add(new Person("Попов", "Павел", 45));
        people.add(new Person("Смирнов", "Сергей", 50));
        people.add(new Person("Соколов", "Сергей", 50));
        people.add(new Person("Сидоров", "Сидор", 65));
        people.add(new Person("Лебедев", "Лена", 65));
        people.add(new Person("Козлов", "Костя", 73));
        people.add(new Person("Новиков", "Никита", 75));
        people.add(new Person("Морозов", "Максим", 15));
        people.add(new Person("Волков", "Владимира", 60));
        people.add(new Person("Кириллов", "Кирилл", 17));
        people.add(new Person("Орлов", "Олег", 25));
        people.add(new Person("Петров", "Петр", 30));
        people.add(new Person("Куликов", "Кузьма", 16));

        //Отфильтруйте людей младше 18 лет.
        List<Person> peopleOver18 = people.stream()
                .filter(person -> person.getAge() > 18)
                .toList();

        peopleOver18.forEach(System.out::println);

        //Сформируйте список полных имен старше 30 лет.
        List<String> peopleOver30 = people.stream()
                .filter(person -> person.getAge() > 30)
                .map(person1 -> person1.getFirstName() + " " + person1.getLastName())
                .toList();

        peopleOver30.forEach(System.out::println);

        //Найдите человека с максимальным возрастом.
        Person personMaxAge = people.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElse(null);

        System.out.println(personMaxAge);

        //Сгруппируйте людей по возрасту.
        Map<Integer, List<Person>> groupPeopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        for (Map.Entry<Integer, List<Person>> groupAge : groupPeopleByAge.entrySet()) {
            System.out.printf("Группа по возрасту: %d %n", groupAge.getKey());
            System.out.println(groupAge.getValue());
        }

        //Рассчитайте средний возраст
        double averageAge = people.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.printf("Средний возраст %.2f", averageAge);
    }

}
