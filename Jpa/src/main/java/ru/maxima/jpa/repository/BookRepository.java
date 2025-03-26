package ru.maxima.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.jpa.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
