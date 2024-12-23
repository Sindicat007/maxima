package StreamApi.task6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создайте список из 10 книг.
        List<Book> books = Arrays.asList(
                new Book("Джордж Оруэлл", "1984", 55.0),
                new Book("Джеймс Джойс", "Улисс", 200.5),
                new Book("Франц Кафка", "Превращение", 333.0),
                new Book("Марк Твен", "Приключения Тома Сойера", 40.0),
                new Book("Лев Толстой", "Война и мир", 50.0),
                new Book("Виктор Гюго", "Отверженные", 60.0),
                new Book("Александр Пушкин", "Евгений Онегин", 657.32),
                new Book("Фёдор Достоевский", "Преступление и наказание", 80.0),
                new Book("Михаил Булгаков", "Мастер и Маргарита", 90.0),
                new Book("Александр Пушкин", "Капитанская дочка", 520.0));

        //Найдите самую дорогую и самую дешевую книгу.
        printBookMaxAndMinPrice(books);
        System.out.println();
        //Сформируйте список авторов всех книг без повторений.
        printListWithUniqueAuthor(books);
        System.out.println();
        //Подсчитайте общую стоимость всех книг.
        printSumPriceBooks(books);
        System.out.println();
        //Отфильтруйте книги, чья цена больше 500 рублей, и соберите их в новую коллекцию.
        printPriceMore500(books);

    }

    //Метод печати самой дорогой и самой дешевой книги.
    public static void printBookMaxAndMinPrice(List<Book> book) {
        Book maxPriceBook = book.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);

        Book minPriceBook = book.stream()
                .min(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);

        System.out.printf("Самая дорогая книга: %nАвтор: '%s', Название: '%s', Цена: %.2f %n",
                maxPriceBook.getAuthor(), maxPriceBook.getTitle(), maxPriceBook.getPrice());
        System.out.printf("Самая дешевая книга: %nАвтор: '%s', Название: '%s', Цена: %.2f %n",
                minPriceBook.getAuthor(), minPriceBook.getTitle(), minPriceBook.getPrice());
    }

    //Метод печати списка уникальных авторов всех книг без повторений.
    public static void printListWithUniqueAuthor(List<Book> book) {
        List<String> authorUnique = book.stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
        System.out.println("Список уникальных авторов: ");
        authorUnique.forEach(System.out::println);
    }

    //Метод печати общей стоимости всех книг.
    public static void printSumPriceBooks(List<Book> book) {
        double sumPrice = book.stream()
                .mapToDouble(Book::getPrice)
                .sum();

        System.out.printf("Общая сумма всех книг: %.2f %n", sumPrice);
    }

    //Метод фильтрации и печати книг, чья цена больше 500 рублей.
    public static void printPriceMore500(List<Book> book) {
        List<Book> resultMore500 = book.stream()
                .filter(s -> s.getPrice() > 500.00)
                .toList();
        System.out.println("Список книг дороже 500 рублей: ");
        resultMore500.forEach(System.out::println);
    }
}
