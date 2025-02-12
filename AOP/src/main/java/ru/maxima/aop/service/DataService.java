package ru.maxima.aop.service;

import org.springframework.stereotype.Component;

@Component
public class DataService {
    public void processData(String data) {
        if (data.isEmpty()) {
            System.out.println("Входные данные не могут быть пустыми");
        }
        System.out.println("Обработка данных: " + data);
    }
}
