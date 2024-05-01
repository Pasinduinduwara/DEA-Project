package com.example.dao;

import com.example.DatabaseConnection;
import com.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {

    // SQL queries
    private static final String AUTHENTICATE_USER_QUERY = "SELECT * FROM user WHERE userName = ? AND password = ?";
    private static final String INSERT_USER_QUERY = "INSERT INTO user (email, userName, password, role) VALUES (?, ?, ?, ?)";
    private static Connection connection;

    public UserDAO() {
        // Initialize the database connection (You can implement this method)
        this.connection = DatabaseConnection.getConnection();
    }

    public static boolean authenticate(String userName, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(AUTHENTICATE_USER_QUERY);
            statement.setString(1, userName);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Return true if the result set has at least one row
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
