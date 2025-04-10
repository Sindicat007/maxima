package ru.maxima.jpa.mapper;

import org.springframework.stereotype.Component;
import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.entity.BookEntity;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public BookDto mapBookToBookDto(BookEntity book) {
        return new BookDto(book.getName(), book.getAuthor(), book.getYearPublication());
    }

    @Override
    public BookEntity mapBookDtoToBook(BookDto bookDto) {
        BookEntity book = new BookEntity();
        book.setName(bookDto.name());
        book.setAuthor(bookDto.author());
        book.setYearPublication(bookDto.yearPublication());
        return book;
    }
}
