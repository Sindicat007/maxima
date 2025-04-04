package ru.maxima.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.maxima.jpa.entity.UserEntity;

import java.util.List;
/*
 * Репозиторий для работы с пользователями
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByAgeGreaterThan(Integer age);

    List<UserEntity> findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE age > :age")
    List<UserEntity> findAllByAgeGreaterThanCustom(@Param("age") Integer age);

}