package ru.maxima.beans.task1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.maxima.beans.task1.BookRepository;
import ru.maxima.beans.task1.BookService;

@Configuration
public class AppConfig {
    @Bean
    BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    BookService bookService() {
        return new BookService(bookRepository());
    }
}
