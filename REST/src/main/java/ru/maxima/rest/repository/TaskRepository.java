package ru.maxima.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.rest.entity.Task;

/*
 * Репозиторий для работы с БД
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
