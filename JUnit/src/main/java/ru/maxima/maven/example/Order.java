package ru.maxima.maven.example;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class Order {
    private int id;
    private List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public double calculateTotalPrice() {

        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
