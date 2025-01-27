package ru.maxima.reflection;

import ru.maxima.reflection.annotation.Component;
import ru.maxima.reflection.annotation.Inject;
import ru.maxima.reflection.annotation.Scope;

@Scope
@Component
public class Car {

    @Inject
    private Engine engine;

    void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}
