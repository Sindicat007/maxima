package ru.maxima.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.jpa.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
