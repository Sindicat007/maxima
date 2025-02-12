package ru.maxima.beans.task3;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final ArrayList<String> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public void setUsers(String user) {
        users.add(user);
    }

    public List<String> getUsers() {
        return users;
    }
}
