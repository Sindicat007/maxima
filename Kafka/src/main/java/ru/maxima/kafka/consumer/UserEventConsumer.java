package ru.maxima.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.maxima.kafka.events.UserEvent;

/**
 * Consumer для обработки событий UserEvent
 */
@Service
public class UserEventConsumer {

    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void listen(UserEvent userEvent) {
        System.out.println("Event received: " + userEvent);
    }
}
