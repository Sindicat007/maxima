package ru.maxima.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.kafka.events.UserEvent;
import ru.maxima.kafka.producer.UserEventProducer;

import java.time.LocalDateTime;

/**
 * Контроллер для работы с пользователями
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserEventProducer producer;

    @PostMapping("/create")
    public ResponseEntity<Void> send(@RequestBody UserEvent event) {
        event.setType("create");
        event.setTimestamp(LocalDateTime.now());
        producer.sendMessage("test-topic", event);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UserEvent event) {
        event.setType("update");
        event.setTimestamp(LocalDateTime.now());
        producer.sendMessage("test-topic", event);
        return ResponseEntity.ok().build();
    }
}