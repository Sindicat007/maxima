package ru.maxima.jpa.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.maxima.jpa.entity.PostEntity;
import ru.maxima.jpa.entity.UserEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Тестирование репозитория для работы с постами
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@Import(PostgreSQLContainer.class)
class PostRepositoryTest {

    @Autowired
    PostRepository repository;

    @Test
    @DisplayName("Получение списка постов по пользователю")
    void shouldGetPostsByUser() {

        UserEntity user = new UserEntity();
        user.setId(2L);

        List<PostEntity> posts = repository.findByUser(user);

        assertThat(posts).isNotEmpty();
        assertEquals(14, posts.size());
    }

    @Test
    @DisplayName("Получение списка постов по пользователю c пагинацией")
    void shouldGetPostsByUserWithPagination() {

        UserEntity user = new UserEntity();
        user.setId(2L);

        List<PostEntity> users = repository.findPostByUser(user, Pageable.ofSize(10));
        assertThat(users).isNotEmpty();
        assertEquals(10, users.size());
    }

    @Test
    @DisplayName("Получение списка постов по части названия с кастомным запросом")
    void shouldGetByByTitle() {
        List<PostEntity> posts = repository.findByTitle("My");

        assertThat(posts).isNotEmpty();
        assertEquals(14, posts.size());
    }
}