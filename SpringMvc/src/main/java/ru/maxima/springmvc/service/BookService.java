package ru.maxima.springmvc.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.maxima.springmvc.entity.Book;
import ru.maxima.springmvc.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}