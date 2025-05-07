package ru.maxima.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.maxima.kafka.events.UserEvent;

/**
 * Producer для UserEvent
 */
@Service
@RequiredArgsConstructor
public class UserEventProducer {
    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    public void sendMessage(String topic, UserEvent event) {
        kafkaTemplate.send(topic, event);
    }
}
