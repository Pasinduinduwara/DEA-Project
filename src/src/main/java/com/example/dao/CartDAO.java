package com.example.dao;

import com.example.DatabaseConnection;
import com.example.entity.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    // SQL queries
    private static final String INSERT_ITEM_QUERY = "INSERT INTO cart (productId, quantity, userName) VALUES (?, ?, ?)";
    private static final String UPDATE_ITEM_QUERY = "UPDATE cart SET quantity = ? WHERE productId = ? AND userName = ?";
    private static final String DELETE_ITEM_QUERY = "DELETE FROM cart WHERE productId = ? AND userName = ?";
    private static final String SELECT_ALL_ITEMS_QUERY = "SELECT * FROM cart WHERE userName = ?";
    private static Connection connection;

    public CartDAO() {
        // Initialize the database connection (You can implement this method)
        this.connection = DatabaseConnection.getConnection();
    }
    public boolean addItemToCart(Cart cartItem) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_ITEM_QUERY);
            statement.setInt(1, cartItem.getProductId());
            statement.setInt(2, cartItem.getQuantity());
            statement.setString(3, cartItem.getUserName());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCartItem(Cart cartItem) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_ITEM_QUERY);
            statement.setInt(1, cartItem.getProductId());
            statement.setInt(2, cartItem.getQuantity());
            statement.setString(3, cartItem.getUserName());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteItemFromCart(int productId, String userName) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_ITEM_QUERY);
            statement.setInt(1, productId);
            statement.setString(2, userName);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cart> getAllCartItems(String userName) {
        List<Cart> cartItems = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEMS_QUERY);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int productId = resultSet.getInt("productId");
                String user = resultSet.getString("userName");
                int quantity = resultSet.getInt("quantity");

                Cart cartItem = new Cart(productId, user, quantity);
                cartItems.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }

}
