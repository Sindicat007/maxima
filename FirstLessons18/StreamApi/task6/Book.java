package StreamApi.task6;


public class Book {
    private final String author;
    private final String title;
    private final double price;

    public Book(String author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Автор: %s, название книги: %s, цена: %.2f", author, title, price);
    }
}
