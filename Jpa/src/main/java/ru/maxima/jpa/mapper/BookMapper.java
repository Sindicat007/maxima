package ru.maxima.jpa.mapper;

import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.entity.Book;

public interface BookMapper {
    public BookDto mapBookToBookDto(Book book);
    public Book mapBookDtoToBook(BookDto bookDto);
}