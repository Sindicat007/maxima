package ru.maxima.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для RabbitMQ
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "maxima";
    public static final String QUEUE_AB = "QueueAB";
    public static final String QUEUE_BC = "QueueBC";
    public static final String ROUTING_A = "A";
    public static final String ROUTING_B = "B";
    public static final String ROUTING_C = "C";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean("QueueAB")
    public Queue queueAb() {
        return new Queue(QUEUE_AB);
    }

    @Bean("QueueBC")
    public Queue queueBc() {
        return new Queue(QUEUE_BC);
    }

    @Bean
    public Binding bindingQueueAbWithA(@Qualifier("QueueAB") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_A);
    }

    @Bean
    public Binding bindingQueueAbWithB(@Qualifier("QueueAB") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_B);
    }

    @Bean
    public Binding bindingQueueBcWithB(@Qualifier("QueueBC") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_B);
    }

    @Bean
    public Binding bindingQueueBcWithC(@Qualifier("QueueBC") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_C);
    }
}
