package ru.maxima.beans.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    private List<String> orders;

    public void setOrderRepository(List<String> orders) {
        this.orders = orders;
    }

    public void addOrder(String order) {
        orders.add(order);
    }

    public List<String> getOrderRepository() {
        return orders;
    }
}
