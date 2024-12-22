package javaCollectionAPI.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsersList {
    private final List<User> users;

    public UsersList() {
        users = new ArrayList<>();
    }

    public UsersList(List<User> users) {
        this.users = users;
    }

    public void sortByName() {
        users.sort(Comparator.comparing(User::getName));
        System.out.println("Список пользователей отсортирован по имени \n");
        printUsers();
    }

    public void sortByAge() {
        users.sort(Comparator.comparingInt(User::getAge));
        System.out.println("Список пользователей отсортирован по возрасту \n");
        printUsers();
    }

    public void addUsers(User user) {
        users.add(user);
        System.out.printf("Пользователь %s с возрастом %d добавлен %n", user.getName(), user.getAge());
    }

    public void printUsers() {
        System.out.println("Список пользователей:");
        for (User user : users) {
            System.out.printf("%s - %d %n", user.getName(), user.getAge());
        }
        System.out.println();
    }
}
