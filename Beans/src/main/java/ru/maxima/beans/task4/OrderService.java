package ru.maxima.beans.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final UserRepository userRepository;
    private OrderRepository orderRepository;

    public OrderService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
