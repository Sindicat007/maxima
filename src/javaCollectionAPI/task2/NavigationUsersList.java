package javaCollectionAPI.task2;

import java.util.Scanner;

public class NavigationUsersList {
    Scanner scan;
    private boolean isWork = true;
    String menuListStr = """
            1. Сортировать по имени\s
            2. Сортировать по возрасту\s
            3. Показать список\s
            4. Выйти\s""";

    public void navigationStart(UsersList usersList) {
        scan = new Scanner(System.in);
        String valNav;
        System.out.println("--------- Сортировка пользователей ---------");

        while (isWork) {
            System.out.println(menuListStr);
            System.out.println("Выберите действие");
            valNav = scan.nextLine();

            switch (valNav) {
                case "1" -> usersList.sortByName();
                case "2" -> usersList.sortByAge();
                case "3" -> System.out.println(usersList.getUsers());
                case "4" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
    }
}
