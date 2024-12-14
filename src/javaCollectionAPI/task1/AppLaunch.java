package javaCollectionAPI.task1;

import java.util.Scanner;

public class AppLaunch {
    private boolean isWork = true;
    String menuPhoneDirectory = """
            1. Добавить контакт\s
            2. Найти номер телефона\s
            3. Удалить контакт\s
            4. Показать все контакты\s
            5. Выйти \s""";

    public void launcherPhoneBook(PhoneNumberDirectory phoneBook) {
        StringBuilder menu = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String val;
        String phone;
        String name;
        System.out.println("---------Телефонный справочник---------");

        while (isWork) {
            System.out.println(menuPhoneDirectory);
            System.out.println("Какое действие нужно выполнить?");
            val = scanner.nextLine();

            switch (val) {
                case "1" -> {
                    System.out.println("Введите имя");
                    name = scanner.nextLine();
                    System.out.println("Введите номер телефона в формате 79234567890");
                    phone = scanner.nextLine().replaceAll("\\W", "");
                    phoneBook.addContactToPhoneBook(name, phone);
                }
                case "2" -> {
                    System.out.println("Введите имя владельца, чей номер нужно найти:");
                    name = scanner.nextLine();
                    System.out.println(phoneBook.findContact(name));
                }
                case "3" -> {
                    System.out.println("Введите номер телефона в формате 71234567890 или имя владельца, чей номер нужно удалить");
                    val = scanner.nextLine();
                    System.out.println(phoneBook.deleteContact(val));
                }
                case "4" -> System.out.println(phoneBook.getPhoneBook());
                case "5" -> {
                    isWork = false;
                    continue;
                }
                default -> System.out.println("Такой команды нет, попробуйте снова");
            }
            System.out.println("Хотите продолжить? Продолжить - введите любой символ, Выйти - 'n'");
            val = scanner.nextLine();
            if (val.equalsIgnoreCase("n") || val.equalsIgnoreCase("т")) isWork = false;
        }
    }
}

