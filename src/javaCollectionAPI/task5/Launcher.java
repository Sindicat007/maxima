package javaCollectionAPI.task5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    private final TaskManager taskManager;
    private Scanner scan;
    private boolean isWork = true;
    private final String menu = """
            1. Добавить задачу\s
            2. Показать список задач\s
            3. Удалить задачу\s
            4. Переместить задачу\s
            5. Выйти\s
            """;

    public Launcher(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void launch() {
        scan = new Scanner(System.in);
        String choiceMenu;
        System.out.println("--------- Менеджер задач ---------");

        while (isWork) {
            System.out.println(menu);
            System.out.println("Выберите действие");
            choiceMenu = scan.nextLine();

            switch (choiceMenu) {
                case "1" -> {
                    System.out.println("Введите текст задачи");
                    taskManager.addTask(scan.nextLine());
                }
                case "2" -> taskManager.printTaskList();
                case "3" -> removeTask();
                case "4" -> moveTask();
                case "5" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
        scan.close();
    }

    private void removeTask() {
        int indexTaskToDelete;
        System.out.println("Введите индекс задачи, которую нужно удалить");
        while (true) {
            try {
                indexTaskToDelete = scan.nextInt();
                taskManager.deleteTask(indexTaskToDelete);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Индекс должен быть целым числом");
                scan.next();
            }
        }
        scan.nextLine();
    }

    private void moveTask() {
        int indexTaskToMove;
        System.out.println("Введите индекс задачи, которую нужно переместить");
        while (true) {
            try {
                indexTaskToMove = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Индекс должен быть целым числом");
                scan.next();
            }
        }
        scan.nextLine();
        System.out.println("Введите направление перемещения задачи: 'top' - вверх, 'bottom' - вниз");
        taskManager.moveTask(indexTaskToMove, scan.nextLine());
    }
}
