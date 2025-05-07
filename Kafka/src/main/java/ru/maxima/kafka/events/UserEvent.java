package ru.maxima.kafka.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Класс данных пользователя
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEvent {

    private String type;
    private Long userId;
    private String userName;
    private LocalDateTime timestamp;
}
