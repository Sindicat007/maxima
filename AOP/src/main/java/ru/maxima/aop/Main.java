package ru.maxima.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.maxima.aop.service.DataService;
import ru.maxima.aop.service.MyService;

@ComponentScan("ru.maxima.aop")
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        MyService service = context.getBean(MyService.class);

        DataService service1 = context.getBean(DataService.class);
        service1.processData("Тестовые данные 1");
        service1.processData("Тестовые данные 2");
        service1.processData(""); // Должно выбросить исключение
        service.doSomething();

        service.doWithTimeOut();
        service.doWithTimeOut();
        service.doWithTimeOut();

        context.close();

    }
}