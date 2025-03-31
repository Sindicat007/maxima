package ru.maxima.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.jpa.dto.PostDTO;
import ru.maxima.jpa.dto.UserDTO;
import ru.maxima.jpa.entity.PostEntity;
import ru.maxima.jpa.entity.UserEntity;
import ru.maxima.jpa.mapper.PostMapper;
import ru.maxima.jpa.mapper.UserMapper;
import ru.maxima.jpa.repository.PostRepository;
import ru.maxima.jpa.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

/*
 * Сервис для работы с постами
 *
 */
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional
    public void addPost(PostDTO postDTO, Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        PostEntity postEntity = postMapper.toEntity(postDTO);
        postEntity.setUser(user);
        postEntity.setCreatedAt(LocalDateTime.now());

        postRepository.save(postEntity);
    }

    @Transactional
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toDto)
                .toList();
    }

    @Transactional
    public List<PostDTO> getPostsByUser(UserDTO userDTO) {
        return postRepository.findByUser(userMapper.toEntity(userDTO))
                .stream()
                .map(postMapper::toDto)
                .toList();
    }

    @Transactional
    public List<PostDTO> getPostsByTitle(String title) {
        return postRepository.findByTitle(title)
                .stream()
                .map(postMapper::toDto)
                .toList();
    }

    @Transactional
    public List<PostDTO> findByUserWithPageable(UserDTO userDTO, Integer page) {
        return postRepository.findPostByUser(userMapper.toEntity(userDTO), PageRequest.of(page, 10))
                .stream().map(postMapper::toDto)
                .toList();
    }
}