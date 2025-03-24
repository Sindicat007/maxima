package ru.maxima.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.jpa.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
