package http.repository;

import http.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Repository
public class UserRepository {

    private List<User> users;

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByName(String name) {
        return users.stream().filter(e -> e.name().equals(name)).findFirst().orElse(null);
    }

    public void deleteUser(String name) {
        users.removeIf(e -> e.name().equals(name));
    }

    public void updateUser(String name, User newUser) {
        users.removeIf(e -> e.name().equals(name));
        users.add(newUser);
    }
}
