package com.example.dao;

import com.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {

    // SQL queries
    private static final String AUTHENTICATE_USER_QUERY = "SELECT * FROM user WHERE userName = ? AND password = ?";
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

}
