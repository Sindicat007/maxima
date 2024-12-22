package javaCollectionAPI.task5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    private final TaskManager taskManager;
    private Scanner scan;
    private boolean isWork = true;
    private final String menu = """
            1. Добавить задачу\s
            2. Удалить задачу\s
            3. Переместить задачу\s
            4. Показать список задач\s
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
                case "1" -> addTask();
                case "2" -> removeTask();
                case "3" -> moveTask();
                case "4" -> taskManager.printTaskList();
                case "5" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
        scan.close();
    }

    private void addTask() {
        System.out.println("Введите текст задачи");
        taskManager.addTask(scan.nextLine());
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
        System.out.println("Введите направление перемещения задачи: 'top' - вверх, 'down' - вниз");
        taskManager.moveTask(readIndexFromConsole(), scan.nextLine());
    }

    private int readIndexFromConsole() {
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
        return indexTaskToMove;
    }
}
