package javaCollectionAPI.task5;

import java.util.LinkedList;

public class TaskManager {
    private final LinkedList<String> toDoList = new LinkedList<>();

    // Добавление задач
    public void addTask(String task) {
        if (task.isEmpty()) {
            System.out.println("Задача не может быть пустой\n");
            return;
        }
        toDoList.add(task);
        System.out.println("Задача добавлена\n");
    }

    // Печать задач в консоль
    public void printTaskList() {
        if (toDoList.isEmpty()) {
            System.out.println("Список задач пуст\n");
            return;
        }
        System.out.println("Список задач:");
        toDoList.forEach(System.out::println);
        System.out.println();
    }

    // Удаление задач
    public void deleteTask(int index) {
        index = index - 1;
        if ((toDoList.isEmpty() || index < 0 || index > toDoList.size())) {
            System.out.println("Ошибка удаления, проверьте вводимые данные, возможно такой задачи нет\n");
            return;
        }
        toDoList.remove(index);
        System.out.println("Задача удалена\n");
    }

    // Перемещение задач
    public void moveTask(int index, String wayMove) {
        String taskBuffer;
        index = index - 1;

        //Проверка на пустоту списка
        if (toDoList.isEmpty()) {
            System.out.println("Список задач пуст\n");
            return;
        }

        //Верхний предел списка
        if (wayMove.equalsIgnoreCase("top") && index == 0) {
            System.out.println("Задача уже в начале списка\n");
            return;
        }

        //Нижний предел списка
        if (wayMove.equalsIgnoreCase("down") && index == toDoList.size() - 1) {
            System.out.println("Задача уже в конце списка\n");
            return;
        }

        //Перемещение вверх
        if (wayMove.equalsIgnoreCase("top") && index > 0) {
            taskBuffer = toDoList.set(index - 1, toDoList.get(index));
            toDoList.set(index, taskBuffer);
            System.out.println("Задача перемещена вверх\n");
        }

        //Перемещение вниз
        else if (wayMove.equalsIgnoreCase("down") && index < toDoList.size()) {
            taskBuffer = toDoList.set(index + 1, toDoList.get(index));
            toDoList.set(index, taskBuffer);
            System.out.println("Задача перемещена вниз\n");
        }

        //Отработка прочих случаев
        else {
            System.out.println("Ошибка перемещения, проверьте вводимые данные, возможно такой задачи нет\n");
        }
    }
}
