package ru.maxima.beans.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ContextApplication.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);

        bookService.printBook();
    }
}
