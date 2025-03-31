package ru.maxima.jpa.dto;

import lombok.Data;

import java.time.LocalDateTime;

/*
 * Модель создания поста
 *
 */
@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}