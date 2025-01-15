package objectTask.task1;

public class Main {
    public static void main(String[] args) {
        boolean result;

        Book book = new Book("Война и мир", "Лев Толстой", 1867);
        Book book2 = new Book("Война и мир", "Лев Толстой", 1867);

        result = book.equals(book2);
        System.out.println(result);
        System.out.println(book);

    }
}
