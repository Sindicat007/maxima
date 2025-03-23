package ru.maxima.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.entity.Book;
import ru.maxima.jpa.mapper.BookMapper;
import ru.maxima.jpa.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper mapper;

    public BookDto addBook(BookDto bookDto) {
        Book book = mapper.mapBookDtoToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return mapper.mapBookToBookDto(savedBook);
    }

    public List<BookDto> getAllBooks() {
        List<BookDto> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(mapper.mapBookToBookDto(book)));
        return books;
    }

    public Optional<BookDto> getUserById(Long id) {
        return bookRepository.findById(id).map(mapper::mapBookToBookDto);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
