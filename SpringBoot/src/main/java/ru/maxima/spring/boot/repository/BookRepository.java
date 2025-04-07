package ru.maxima.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.spring.boot.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
