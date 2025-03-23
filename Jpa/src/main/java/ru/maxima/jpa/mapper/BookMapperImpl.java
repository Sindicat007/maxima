package ru.maxima.jpa.mapper;

import org.springframework.stereotype.Component;
import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.entity.Book;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public BookDto mapBookToBookDto(Book book) {
        return new BookDto(book.getName(), book.getAuthor(), book.getYearPublication());
    }

    @Override
    public Book mapBookDtoToBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.name());
        book.setAuthor(bookDto.author());
        book.setYearPublication(bookDto.yearPublication());
        return book;
    }
}
