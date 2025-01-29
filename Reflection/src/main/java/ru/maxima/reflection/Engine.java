package ru.maxima.reflection;

import ru.maxima.reflection.annotation.Component;
import ru.maxima.reflection.annotation.Scope;

@Scope
@Component
public class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}