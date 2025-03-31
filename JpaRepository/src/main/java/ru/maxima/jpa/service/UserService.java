package ru.maxima.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.jpa.dto.UserDTO;
import ru.maxima.jpa.entity.UserEntity;
import ru.maxima.jpa.mapper.UserMapper;
import ru.maxima.jpa.repository.UserRepository;

import java.util.List;

/*
 * Сервис для работы с пользователями
 *
 */
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public List<UserEntity> findUserByAgeMoreThan(Integer age) {
        return userRepository.findAllByAgeGreaterThan(age);
    }

    @Transactional
    public List<UserEntity> findAllByAgeGreaterThanCustom(Integer age) {
        return userRepository.findAllByAgeGreaterThanCustom(age);
    }

    @Transactional
    public List<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public UserEntity createUser(UserDTO userDTO) {
        userRepository.save(userMapper
                .toEntity(userDTO));
        return userMapper.toEntity(userDTO);
    }
}