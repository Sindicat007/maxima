package ru.maxima.maven.example.task1;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
}
