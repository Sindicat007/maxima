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
        if (!users.isEmpty()) {
            users.sort(Comparator.comparing(User::getName));
            System.out.println("Список пользователей отсортирован по имени \n");
        } else {
            System.out.println("Список пользователей пуст");
        }
    }

    public void sortByAge() {
        if (!users.isEmpty()) {
            users.sort(Comparator.comparingInt(User::getAge));
            System.out.println("Список пользователей отсортирован по возрасту \n");
        } else {
            System.out.println("Список пользователей пуст");
        }
    }

    public void addUsers(User user) {
        users.add(user);
        System.out.printf("Пользователь %s с возрастом %d добавлен %n", user.getName(), user.getAge());
    }

    public String getUsers() {
        StringBuilder usersResult = new StringBuilder();
        for (User user : users) {
            usersResult
                    .append(user.getName())
                    .append(" ")
                    .append(user.getAge())
                    .append("\n");
        }
        return usersResult.toString();
    }
}
