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

    public void addTask(String task) {
        if(!task.isEmpty()) {
            list.add(task);
        }
        else {
            System.out.println("Чтоб добавить задачу введите хотя бы один символ");
        }
    }

    public void getTaskList() {
        if(!list.isEmpty()) {
            list.forEach(System.out::println);
        }
        else {
            System.out.println("Список задач пуст");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && !list.isEmpty() && index < list.size()) {
            list.remove(index);
        }
        else {
            System.out.println("Ошибка удаления, проверьте вводимые данные, возможно такой задачи нет");
        }
    }

    public void moveTask(int index, String wayMove) {
        String res;
        if (wayMove.equalsIgnoreCase("top") && index > 0) {
            res = list.set(index - 1, list.get(index));
            list.set(index, res);
        } else if (wayMove.equalsIgnoreCase("down") && index < list.size()) {
            res = list.set(index + 1, list.get(index));
            list.set(index, res);
        }
    }
}
