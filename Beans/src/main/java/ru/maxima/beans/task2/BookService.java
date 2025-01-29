package ru.maxima.beans.task2;

public class BookService {
    BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBook() {
        System.out.println(bookRepository.getBook());
    }
}
