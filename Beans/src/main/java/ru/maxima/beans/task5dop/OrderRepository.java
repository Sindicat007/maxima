package ru.maxima.beans.task5dop;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private final List<String> orders;

    public OrderRepository(List<String> orders) {
        this.orders = orders;
    }

    public void addOrder(String order) {
        orders.add(order);
    }

    public List<String> getOrders() {
        return orders;
    }
}
