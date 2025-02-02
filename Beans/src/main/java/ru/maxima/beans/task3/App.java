package ru.maxima.beans.task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.maxima.beans.task3")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        UserService userService = ctx.getBean(UserService.class);
        UserService userService1 = ctx.getBean(UserService.class);

        userService.addUser("Any person");
        System.out.println(userService1 == userService);
        userService.printUsers();
    }
}
