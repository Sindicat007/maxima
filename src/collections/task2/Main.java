package collections.task2;

public class Main {

    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf();

        bookShelf.addBook("War and Peace");
        bookShelf.addBook("Linux Kali");
        bookShelf.addBook("Java Dev");

        bookShelf.removeBook("War and Peace");

        bookShelf.listBooks();
    }
}
