package ru.maxima.spring.boot.dto;

/*
 * Класс-обертка для передачи информации о книге.
 */

public record BookDto(String name, String author) {
}
