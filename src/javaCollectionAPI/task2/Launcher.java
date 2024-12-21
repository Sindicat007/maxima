package javaCollectionAPI.task2;

import java.util.Scanner;

public class Launcher {
    private boolean isWork = true;
    String menu = """
            1. Сортировать по имени\s
            2. Сортировать по возрасту\s
            3. Показать список\s
            4. Выйти\s""";

    public void launch(UsersList usersList) {
        Scanner scan = new Scanner(System.in);
        String choiceMenu;
        System.out.println("--------- Сортировка пользователей ---------");

        while (isWork) {
            System.out.println(menu);
            System.out.println("Выберите действие");
            choiceMenu = scan.nextLine();

            switch (choiceMenu) {
                case "1" -> usersList.sortByName();
                case "2" -> usersList.sortByAge();
                case "3" -> usersList.getUsers();
                case "4" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
        scan.close();
    }
}
