package ru.maxima.beans.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.maxima.beans.task1.config.AppConfig;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService = ctx.getBean("bookService", BookService.class);

        bookService.printBook();
    }
}
