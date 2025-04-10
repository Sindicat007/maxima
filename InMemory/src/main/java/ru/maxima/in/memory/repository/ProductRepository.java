package ru.maxima.in.memory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.in.memory.entity.Product;

/*
 * Репозиторий для работы с продуктами
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
