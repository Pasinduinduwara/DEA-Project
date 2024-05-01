package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private int id;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("price")
    private double price;
    @JsonProperty("stockAmount")
    private double stockAmount;
    @JsonProperty("discounts")
    private double discounts;
    @JsonProperty("images")
    private String images;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category")
    private String category;
    // Add other attributes, constructors, getters, and setters as needed

    public Product() {}

    public double getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(double stockAmount) {
        this.stockAmount = stockAmount;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Product(int id, String productName, double price, double stockAmount, double discounts, String images, String description, String category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stockAmount = stockAmount;
        this.discounts = discounts;
        this.images = images;
        this.description = description;
        this.category = category;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
