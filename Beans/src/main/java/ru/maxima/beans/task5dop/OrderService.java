package ru.maxima.beans.task5dop;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public OrderService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public void addUser(String user) {
        userRepository.addUser(user);
    }

    public void addOrder(String order) {
        orderRepository.addOrder(order);
    }

    @PostConstruct
    public void init() {
        System.out.println("Метод init() вызван");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Метод destroy() вызван");
    }

    public void printUserAndOrder() {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("Список пользователь пуст");
        } else {
            System.out.println("Список пользователей и заказов: ");
            userRepository.getUsers().forEach(System.out::println);
            orderRepository.getOrders().forEach(System.out::println);
        }
    }
}
