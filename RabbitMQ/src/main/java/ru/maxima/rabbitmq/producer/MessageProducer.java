package ru.maxima.rabbitmq.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.maxima.rabbitmq.config.RabbitMQConfig;

import static ru.maxima.rabbitmq.config.RabbitMQConfig.*;

/**
 * Обработка отправки сообщений
 */
@Service
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendToRoutingKeyA(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, ROUTING_A, message);
        System.out.println("Send to routing key A:" + message);
    }

    public void sendToRoutingKeyB(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, ROUTING_B, message);
        System.out.println("Send to routing key B:" + message);
    }

    public void sendToRoutingKeyC(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, ROUTING_C, message);
        System.out.println("Send to routing key C:" + message);
    }
}
