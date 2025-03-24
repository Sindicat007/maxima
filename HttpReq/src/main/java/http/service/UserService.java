package http.service;

import http.User;
import http.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void addUser(String name, int age) {
        userRepository.addUser(new User(name, age));
        System.out.println("User was added");
    }

    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    public void deleteUser(String name) {
        userRepository.deleteUser(name);
        System.out.println("User was deleted");
    }

    public void updateUser(String name, User newUser) {
        userRepository.updateUser(name, newUser);
        System.out.println("User was updated");
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
