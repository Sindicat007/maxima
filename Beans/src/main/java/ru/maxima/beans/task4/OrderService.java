package ru.maxima.beans.task4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private OrderRepository orderRepository;

    public OrderService(UserRepository userRepository) {
        this.userRepository = userRepository;
        setOrderRepository();
    }

    public void setOrderRepository() {
        this.orderRepository = new OrderRepository();
        orderRepository.setOrderRepository(new ArrayList<>());
    }

    public void addUser(String user) {
        userRepository.addUser(user);
    }

    public void addOrder(String order) {
        orderRepository.addOrder(order);
    }

    public void printUserAndOrder() {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("Список пользователь пуст");
        } else {
            System.out.println("Список пользователей и заказов: ");
            userRepository.getUsers().forEach(System.out::println);
            orderRepository.getOrderRepository().forEach(System.out::println);
        }
    }
}
