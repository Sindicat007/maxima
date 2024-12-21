package javaCollectionAPI.task1;

import java.util.Scanner;

public class Launcher {
    private boolean isWork = true;
    private Scanner scan;
    private String name;
    private String choiceMenu;
    private final String menu = """
            1. Добавить контакт\s
            2. Найти номер телефона\s
            3. Удалить контакт\s
            4. Показать все контакты\s
            5. Выйти \s""";

    public void launch(PhoneNumberDirectory phoneBook) {
        scan = new Scanner(System.in);
        System.out.println("---------Телефонный справочник---------");

        while (isWork) {
            System.out.println(menu);
            System.out.println("Какое действие нужно выполнить?");
            choiceMenu = scan.nextLine();

            switch (choiceMenu) {
                case "1" -> inputName(phoneBook);

                case "2" -> printNumberByName(phoneBook);

                case "3" -> deleteContact(phoneBook);

                case "4" -> phoneBook.getPhoneBook();

                case "5" -> {
                    isWork = false;
                    continue;
                }
                default -> System.out.println("Такой команды нет, попробуйте снова");
            }
            repeatChoiceMenu();
        }
        scan.close();
    }

    private void inputName(PhoneNumberDirectory phoneBook) {
        String phone;
        scan = new Scanner(System.in);
        System.out.println("Введите имя");
        name = scan.nextLine();
        System.out.println("Введите номер телефона в формате 79234567890");
        phone = scan.nextLine().replaceAll("\\W", "");
        phoneBook.addContactToPhoneBook(name, phone);
    }

    private void printNumberByName(PhoneNumberDirectory phoneBook) {
        System.out.println("Введите имя владельца, чей номер нужно найти:");
        name = scan.nextLine();
        System.out.println(phoneBook.findContact(name));
    }

    private void deleteContact(PhoneNumberDirectory phoneBook) {
        String nameOrPhone;
        System.out.println("Введите номер телефона в формате 79234567890 или имя владельца, чей номер нужно удалить");
        nameOrPhone = scan.nextLine();
        System.out.println(phoneBook.deleteContact(nameOrPhone));
    }

    private void repeatChoiceMenu() {
        System.out.println("Хотите продолжить? Продолжить - введите любой символ, Выйти - 'n'");
        choiceMenu = scan.nextLine();
        if (choiceMenu.equalsIgnoreCase("n") || choiceMenu.equalsIgnoreCase("т")) isWork = false;
    }
}