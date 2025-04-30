package ru.maxima.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.maxima.rabbitmq.config.RabbitMQConfig;

/**
 * Обработка получения сообщений
 */
@Service
public class MessageConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_AB)
    public void receiveMessageFromQueueAb(String message) {
        System.out.println("Received message from queue AB:" + message);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_BC)
    public void receiveMessageFromQueueBc(String message) {
        System.out.println("Received message from queue BC:" + message);
    }

}
