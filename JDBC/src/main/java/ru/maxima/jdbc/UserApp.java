package ru.maxima.jdbc;

import java.util.List;
import java.util.Scanner;

public class UserApp {
    private static final UserDAO userDAO = new UserDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Обновить пользователя");
            System.out.println("4. Удалить пользователя");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addUser();
                case 2 -> showUsers();
                case 3 -> updateUser();
                case 4 -> deleteUser();
                case 5 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }

    private static void addUser() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        userDAO.addUser(name, email);
    }

    private static void showUsers() {
        List<String> users = userDAO.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void updateUser() {
        System.out.print("Введите ID пользователя: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите новое имя: ");
        String newName = scanner.nextLine();
        System.out.print("Введите новый email: ");
        String newEmail = scanner.nextLine();
        userDAO.updateUser(id, newName, newEmail);
    }

    private static void deleteUser() {
        System.out.print("Введите ID пользователя: ");
        int id = scanner.nextInt();
        userDAO.deleteUser(id);
    }
}
