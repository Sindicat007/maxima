package ru.maxima.spring.boot.entity;

import jakarta.persistence.*;
import lombok.*;

/*
 * Сущность для хранения данных о книге
 *
 * @author Sindicat
 */
@Entity
@Table(schema = "book_service", name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
}
