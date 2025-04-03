package ru.maxima.spring.boot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = "books", name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String roles;

}
