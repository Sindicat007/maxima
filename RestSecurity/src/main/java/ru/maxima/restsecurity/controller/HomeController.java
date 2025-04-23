package ru.maxima.restsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер обработки запросов
 */
@RestController
@RequestMapping
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "Hello";
    }
}
