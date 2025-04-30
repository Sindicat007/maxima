package ru.maxima.rabbitmq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.maxima.rabbitmq.producer.MessageProducer;

/**
 * Контроллер RabbitMQ
 */
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageProducer messageProducer;

    @PostMapping
    public void sendMessage(@RequestParam("key") String routingKey, @RequestBody String message) {
        switch (routingKey) {
            case "A" -> messageProducer.sendToRoutingKeyA(message);
            case "B" -> messageProducer.sendToRoutingKeyB(message);
            case "C" -> messageProducer.sendToRoutingKeyC(message);
            default -> throw new RuntimeException("Unknown routing key");
        }
    }
}
