package ru.maxima.beans.task3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String user) {
        userRepository.setUsers(user);
    }

    public void printUsers() {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("Список пользователей пуст");
        } else {
            System.out.println("Список пользователей:");
            userRepository.getUsers().forEach(System.out::println);
        }
    }
}
