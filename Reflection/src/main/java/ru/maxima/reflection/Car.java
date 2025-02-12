package ru.maxima.reflection;

import ru.maxima.reflection.annotation.Component;
import ru.maxima.reflection.annotation.Inject;
import ru.maxima.reflection.annotation.Scope;
import ru.maxima.reflection.annotation.Value;

@Scope
@Component
public class Car {

    @Inject
    private Engine engine;
    @Value(port = "8484")
    private Integer port2;

    void drive() {
        engine.start();
        System.out.println("Car is driving");
        System.out.println("Port2 " + port2);
    }
}
