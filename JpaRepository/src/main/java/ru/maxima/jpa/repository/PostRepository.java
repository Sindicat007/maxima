package ru.maxima.jpa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.maxima.jpa.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.jpa.entity.UserEntity;

import java.util.List;

/*
 * Репозиторий для работы с постами
 *
 */
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUser(UserEntity userEntity);

    List<PostEntity> findPostByUser(UserEntity userEntity, Pageable pageable);

    @Query("SELECT p FROM PostEntity p JOIN FETCH p.user WHERE p.title LIKE %:title%")
    List<PostEntity> findByTitle(@Param("title") String title);
}