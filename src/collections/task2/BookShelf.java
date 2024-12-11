package collections.task2;


import java.util.ArrayList;

/**
 * 2: Класс "Книжная полка"
 * <p>
 * Создайте класс BookShelf, который содержит приватное поле books типа ArrayList<String>.
 * Данный список будет хранить названия книг на книжной полке.
 * <p>
 * В классе BookShelf реализуйте следующие методы:
 * <p>
 * Конструктор без аргументов, который инициализирует список.
 * <p>
 * addBook(String bookName): добавляет название книги в список.
 * <p>
 * removeBook(String bookName): удаляет книгу по названию.
 * <p>
 * listBooks(): выводит в консоль список всех книг на полке.
 */
public class BookShelf {
    private final ArrayList<String> books;

    public BookShelf() {
        books = new ArrayList<>();
    }

    public void addBook(String bookName) {
        books.add(bookName);
    }

    public void removeBook(String bookName) {
        if (books.contains(bookName)) {
            books.remove(bookName);
        } else {
            System.out.println("Такой книги нет");
        }
    }

    public void listBooks() {
        System.out.println(books);
    }
}
