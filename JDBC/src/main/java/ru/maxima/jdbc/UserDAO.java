package ru.maxima.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO {
    public void addUser(String name, String email) {
        if (name.isEmpty() || email.isEmpty()) {
            System.out.println("Имя и email не могут быть пустыми");
            return;
        }
        String reqUser = "INSERT INTO users.users (name, email) VALUES (?, ?)";

        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement state = connection.prepareStatement(reqUser)) {
            state.setString(1, name);
            state.setString(2, email);
            int rowsInserted = state.executeUpdate();
            System.out.println("Добавлено: " + name + " " + email + " " + rowsInserted);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateUser(int id, String newName, String newEmail) {
        String reqUpdateUser = "UPDATE users.users " +
                "SET name = ?, email = ? " +
                "WHERE id = ? ";

        try (Connection connect = ConnectDB.getConnection();
             PreparedStatement state = connect.prepareStatement(reqUpdateUser)) {
            state.setString(1, newName);
            state.setString(2, newEmail);
            state.setInt(3, id);
            int rowsInserted = state.executeUpdate();
            System.out.println("Добавлено: " + id + " " + newName + " " + newEmail + " " + rowsInserted);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String reqDeleteUser = "DELETE FROM users.users WHERE id = ?";
        try (Connection connect = ConnectDB.getConnection();
             PreparedStatement state = connect.prepareStatement(reqDeleteUser)) {
            state.setInt(1, id);
            int rowsDeleted = state.executeUpdate();
            System.out.println("Удалено: " + id + " " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllUsers() {
        String reqAllUsers = "SELECT * FROM users.users";
        List<String> users = new ArrayList<>();
        try (Connection conn = ConnectDB.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(reqAllUsers);
            ResultSet results = stmt.getResultSet();

            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String email = results.getString(3);
                users.add("id: " + id + "\t" + "name: " + name + "\t" + "email: " + email + "\t");
            }
        return users;
        } catch (SQLException e) {
            System.out.println("Error " + e.getSQLState());
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
