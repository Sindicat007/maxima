package ru.maxima.beans.task4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public List<String> orders() {
        return new ArrayList<>();
    }
}
