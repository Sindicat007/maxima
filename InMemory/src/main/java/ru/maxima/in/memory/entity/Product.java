package ru.maxima.in.memory.entity;

import jakarta.persistence.*;
import lombok.*;

/*
 * Сущность продукта
 */
@Getter
@Setter
@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
}
