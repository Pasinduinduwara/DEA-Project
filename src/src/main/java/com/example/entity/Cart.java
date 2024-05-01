package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cart {
    @JsonProperty("productId")
    private int productId;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("quantity")
    private int quantity;

    public Cart() {}

    public Cart(int productId, String userName, int quantity) {
        this.productId = productId;
        this.userName = userName;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
