package ru.maxima.springmvc.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.springmvc.entity.Book;
import ru.maxima.springmvc.repository.BookRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}