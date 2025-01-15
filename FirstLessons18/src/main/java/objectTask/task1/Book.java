package objectTask.task1;
import java.util.Objects;

/**
 * Задание 1: Создание и сравнение класса "Книга"
 * <p>
 * Создайте класс Book с полями title (название), author (автор) и yearOfPublication (год публикации). Поля должны быть приватными,
 * а доступ к ним осуществляться через геттеры и сеттеры.
 * <p>+
 * Переопределите метод equals() таким образом, чтобы две книги считались равными, если у них совпадают название и автор. Игнорируйте год публикации при сравнении.
 * <p>
 * Переопределите метод hashCode() в соответствии с реализацией equals(), чтобы гарантировать, что равные объекты имеют одинаковый хеш-код.
 * <p>
 * Переопределите метод toString(), чтобы он возвращал строку с полной информацией о книге (название, автор, год публикации).
 **/

public class Book {
    private String title;
    private String author;
    private int yearOfPublication;

    public Book() {
    }

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return String.format("Книга %s, автор %s, год публикации %d", title, author, yearOfPublication);
    }
}
