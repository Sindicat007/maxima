package ru.maxima.aop.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {
    public void doSomething() {
        System.out.println("Работа метод doSomething()");
    }

    public void doWithTimeOut() {
        System.out.println("Работа метод doWithTimeOut()");
    }
}
