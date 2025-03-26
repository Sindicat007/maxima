package ru.maxima.jpa.mapper;

import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.entity.BookEntity;

public interface BookMapper {
    public BookDto mapBookToBookDto(BookEntity book);

    public BookEntity mapBookDtoToBook(BookDto bookDto);
}