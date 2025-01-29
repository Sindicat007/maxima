package ru.maxima.beans.task5dop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.maxima.beans.task5dop")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);

        OrderService orderService = ctx.getBean(OrderService.class);

        orderService.addUser("Viktor");
        orderService.addOrder("Мясо, Чай");
        orderService.printUserAndOrder();

        ctx.close();
    }
}
