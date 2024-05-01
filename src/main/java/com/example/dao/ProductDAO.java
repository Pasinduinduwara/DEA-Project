package com.example.dao;

import com.example.DatabaseConnection;
import com.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static Connection connection;

    public ProductDAO() {
        // Initialize the database connection (You can implement this method)
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean addProduct(Product product) {
        String query = "INSERT INTO product (name, price, stockAmount,discounts,images,description,category) VALUES (?, ?,?,?,?, ?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getStockAmount());
            preparedStatement.setDouble(4, product.getDiscounts());
            preparedStatement.setString(5, product.getImages());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setString(7, product.getCategory());
            // Set other attributes in a similar manner
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String query = "UPDATE product SET name = ?, price = ?, stockAmount = ?, discounts = ?, images = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getStockAmount());
            preparedStatement.setDouble(4, product.getDiscounts());
            preparedStatement.setString(5, product.getImages());
            preparedStatement.setInt(6, product.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduct(int productId) {
        String query = "DELETE FROM product WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Product getProductById(int productId) {
        String query = "SELECT * FROM product WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStockAmount(resultSet.getDouble("stockAmount"));
                product.setDiscounts(resultSet.getDouble("discounts"));
                product.setImages(resultSet.getString("images"));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE category = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStockAmount(resultSet.getDouble("stockAmount"));
                product.setDiscounts(resultSet.getDouble("discounts"));
                product.setImages(resultSet.getString("images"));
                product.setDescription(resultSet.getString("description"));
                product.setCategory(resultSet.getString("category"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStockAmount(resultSet.getDouble("stockAmount"));
                product.setDiscounts(resultSet.getDouble("discounts"));
                product.setImages(resultSet.getString("images"));
                product.setDescription(resultSet.getString("description"));
                product.setCategory(resultSet.getString("category"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

