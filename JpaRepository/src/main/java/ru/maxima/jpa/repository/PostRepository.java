package ru.maxima.jpa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.maxima.jpa.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.jpa.entity.UserEntity;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUser(UserEntity userEntity);

    List<PostEntity> findPostByUser(UserEntity userEntity, Pageable pageable);

    @Query(value = "SELECT * FROM users.posts WHERE title LIKE %:title%", nativeQuery = true)
    List<PostEntity> findByTitle(@Param("title") String title);


}