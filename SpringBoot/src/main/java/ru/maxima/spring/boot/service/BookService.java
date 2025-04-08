package ru.maxima.spring.boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.spring.boot.dto.BookDto;
import ru.maxima.spring.boot.entity.BookEntity;
import ru.maxima.spring.boot.mapper.BookMapper;
import ru.maxima.spring.boot.repository.BookRepository;

import java.util.List;
import java.util.Optional;

/*
 * Сервис для работы с книгами
 */

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final BookMapper bookMapper;

    public void addBook(BookDto bookDto) {
        BookEntity bookEntity = bookMapper.toBookEntity(bookDto);
        repository.save(bookEntity);
    }

    public List<BookDto> getAllBooks() {
        return repository.findAll().stream()
                .map(bookMapper::toBookDto)
                .toList();
    }

    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    public Optional<BookDto> getBookById(Long id) {
        return repository.findById(id)
                .map(bookMapper::toBookDto);
    }
}
