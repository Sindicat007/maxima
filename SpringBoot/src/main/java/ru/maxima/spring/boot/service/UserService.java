package ru.maxima.spring.boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.maxima.spring.boot.entity.UserEntity;
import ru.maxima.spring.boot.repository.UserRepository;

import java.util.Optional;

/*
 * Сервис для работы с пользователями
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    public Optional<UserEntity> getUser(UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return userRepository.findByUsername(user.getUsername());
        } else {
            return Optional.empty();
        }
    }
}