package ru.maxima.jpa.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.maxima.jpa.entity.UserEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Тестирование репозитория для работы с пользователями
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@Import(PostgreSQLContainer.class)
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    @DisplayName("Получение списка старше 16 лет")
    void shouldGetAllByAgeGreaterThan() {
        List<UserEntity> users = repository.findAllByAgeGreaterThan(16);

        assertThat(users).isNotEmpty();
        assertEquals(1, users.size());
    }

    @Test
    @DisplayName("Получение пользователя по имени")
    void shouldGetByUsername() {
        List<UserEntity> users = repository.findByUsername("Dan");

        assertThat(users).isNotEmpty();
        assertEquals(1, users.size());
    }

    @Test
    @DisplayName("Получение списка старше 11 лет с кастомным запросом")
    void shouldGetByUsernameCustom() {
        List<UserEntity> users = repository.findAllByAgeGreaterThanCustom(11);

        assertThat(users).isNotEmpty();
        assertEquals(2, users.size());
    }
}