package ru.maxima.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.spring.boot.entity.UserEntity;

import java.util.Optional;

/*
 * Репозиторий для работы с пользователями
 *
 * @author Sindicat
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}

