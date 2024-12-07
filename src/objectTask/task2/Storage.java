package objectTask.task2;

import java.util.LinkedList;
import java.util.List;

/**
 * Задание 2: Создание обобщенного класса хранилища
 * <p>
 * Создайте обобщенный класс stor<T>, который может хранить объекты заданного типа T. Класс должен предоставлять следующие методы:
 * <p>
 * void add(T item) для добавления элемента в хранилище.
 * <p>
 * T get(int index) для получения элемента по индексу.
 * <p>
 * int size() для получения размера хранилища.
 * <p>
 * Добавьте обработку исключений для обращения за пределы размера хранилища.
 **/

public class Storage<T> {
    private final List<T> store;

    public Storage() {
        this.store = new LinkedList<>();
    }

    void add(T item) {
        store.add(item);

    }

    T get(int index) {
        try {
            return store.get(index);
        } catch (Exception e) {
            System.out.println("Такого элемента не существует: " + e.getMessage());
            return null;
        }
    }

    int size() {
        return store.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Хранилище содержит элементов: ").append(size()).append("\n");
        for (T item : store) {
            str.append(item).append("\n");
        }
        return str.toString();
    }
}
