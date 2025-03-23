package ru.maxima.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.maxima.jpa.config.AppConfig;
import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.service.BookService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookService userService = context.getBean(BookService.class);

        BookDto bookDto = new BookDto("Lev Tolstoy", "War and Peace", "1867");
        userService.addBook(bookDto);

        context.close();
    }
}
