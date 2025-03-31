package ru.maxima.jpa.dto;

import lombok.Data;

/*
 * Модель создания пользователя
 *
 */
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Integer age;
}
