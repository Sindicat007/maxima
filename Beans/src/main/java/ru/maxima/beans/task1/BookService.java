package ru.maxima.beans.task1;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBook() {
        System.out.println(bookRepository.getBook());
    }
}
