package javaCollectionAPI.task5;

/*
5. Реализация менеджера задач с использованием LinkedList

Описание задачи:
Разработайте программу, которая позволит пользователю управлять списком задач. Пользователь сможет:


Добавлять новые задачи.

Просматривать список задач.

Удалять выполненные задачи.

Перемещать задачу вверх или вниз в списке.


Требования к реализации:

Использовать LinkedList для хранения задач. Каждая задача должна быть представлена строкой.

Реализовать текстовое меню для взаимодействия с пользователем.

Обеспечить корректное перемещение задач в списке вверх или вниз.


Функциональные требования:

Добавление задач:

Пользователь вводит описание задачи.

Задача добавляется в конец списка.

Просмотр задач:

Выводятся все задачи с их индексами.

Удаление задач:
Пользователь вводит индекс задачи, которую хочет удалить.

Перемещение задач:
Пользователь вводит индекс задачи и направление перемещения (вверх или вниз).

Задача перемещается в указанное место, если это возможно.


 */

import java.util.LinkedList;

public class TaskManager {
    LinkedList<String> list = new LinkedList<>();

    // Добавление задач
    public void addTask(String task) {
        if (!task.isEmpty()) {
            list.add(task);
            System.out.println("Задача добавлена\n");
        } else {
            System.out.println("Задача не может быть пустой\n");
        }
    }

    // Просмотр задач
    public void getTaskList() {
        if (!list.isEmpty()) {
            System.out.println("Список задач:");
            list.forEach(System.out::println);
            System.out.println();
        } else {
            System.out.println("Список задач пуст\n");
        }
    }

    // Удаление задач
    public void deleteTask(int index) {
        if (index - 1 >= 0 && !list.isEmpty() && index - 1 < list.size()) {
            list.remove(index - 1);
            System.out.println("Задача удалена\n");
        } else {
            System.out.println("Ошибка удаления, проверьте вводимые данные, возможно такой задачи нет\n");
        }
    }

    // Перемещение задач
    public void moveTask(int index, String wayMove) {
        String res;
        index = index - 1;
        //Проверка на пустоту списка
        if (list.isEmpty()) {
            System.out.println("Список задач пуст\n");
        }

        //Верхний предел списка
        else if (wayMove.equalsIgnoreCase("top") && index == 0) {
            System.out.println("Задача уже в начале списка\n");
        }

        //Нижний предел списка
        else if (wayMove.equalsIgnoreCase("bottom") && index == list.size() - 1) {
            System.out.println("Задача уже в конце списка\n");
        }

        //Перемещение вверх
        else if (wayMove.equalsIgnoreCase("top") && index > 0) {
            res = list.set(index - 1, list.get(index));
            list.set(index, res);
            System.out.println("Задача перемещена вверх\n");
        }

        //Перемещение вниз
        else if (wayMove.equalsIgnoreCase("bottom") && index < list.size()) {
            res = list.set(index + 1, list.get(index));
            list.set(index, res);
            System.out.println("Задача перемещена вниз\n");
        } else {
            System.out.println("Ошибка перемещения, проверьте вводимые данные, возможно такой задачи нет\n");
        }
    }
}
