package ru.maxima.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.maxima.kafka.events.UserEvent;

/**
 * Logger для событий UserEvent
 */
@Service
@Slf4j
public class UserEventLogger {

    @KafkaListener(topics = "test-topic", groupId = "user-events-logger")
    public void setLog(UserEvent userEvent) {
        log.info("User {} ({}) updated by event {} in {}",
                userEvent.getUserName(),
                userEvent.getUserId(),
                userEvent.getType(),
                userEvent.getTimestamp());
    }
}
