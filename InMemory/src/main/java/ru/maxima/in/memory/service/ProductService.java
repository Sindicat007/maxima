package ru.maxima.in.memory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.in.memory.entity.Product;
import ru.maxima.in.memory.repository.ProductRepository;

import java.util.List;

/*
 * Сервис для работы с продуктами
 */

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(String name, Double price) {
        Product product = new Product(null, name, price);
        return productRepository.save(product);
    }
}