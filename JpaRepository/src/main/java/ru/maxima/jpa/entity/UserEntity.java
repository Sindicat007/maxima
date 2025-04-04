package ru.maxima.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * Сущность пользователя
 *
 */
@Entity
@Table(schema = "user_service", name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "age", nullable = false)
    private Integer age;

}
