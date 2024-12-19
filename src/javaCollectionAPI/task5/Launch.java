package javaCollectionAPI.task5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launch {
    Scanner scan;
    private boolean isWork = true;
    String menuListStr = """
            1. Добавить задачу\s
            2. Показать список задач\s
            3. Удалить задачу\s
            4. Переместить задачу\s
            5. Выйти\s
            """;

    public void taskManagerStart(TaskManager taskManager) {
        scan = new Scanner(System.in);
        String valNav;
        System.out.println("--------- Менеджер задач ---------");

        while (isWork) {
            System.out.println(menuListStr);
            System.out.println("Выберите действие");
            valNav = scan.nextLine();

            switch (valNav) {
                case "1" -> {
                    System.out.println("Введите текст задачи");
                    taskManager.addTask(scan.nextLine());
                }
                case "2" -> taskManager.getTaskList();
                case "3" -> {
                    int taskDelIndex;
                    System.out.println("Введите индекс задачи, которую нужно удалить");
                    while (true) {
                        try {
                            taskDelIndex = scan.nextInt();
                            taskManager.deleteTask(taskDelIndex);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Индекс должен быть целым числом");
                            scan.next();
                        }
                    }
                }
                case "4" -> {
                    int taskMoveIndex;
                    System.out.println("Введите индекс задачи, которую нужно переместить");
                    while (true) {
                        try {
                            taskMoveIndex = scan.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Индекс должен быть целым числом");
                            scan.next();
                        }
                    }
                    scan.nextLine();
                    System.out.println("Введите направление перемещения задачи: 'top' - вверх, 'bottom' - вниз");
                    taskManager.moveTask(taskMoveIndex, scan.nextLine());
                }
                case "5" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
        scan.close();
    }
}
