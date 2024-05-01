package com.example.servlet;

import com.example.dao.CartDAO;
import com.example.entity.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private CartDAO cartDAO;

    public void init() throws ServletException {
        super.init();
        // Initialize CartDAO
        cartDAO = new CartDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parse JSON request body
        ObjectMapper mapper = new ObjectMapper();
        Cart cartItem = mapper.readValue(request.getReader(), Cart.class);

        // Add item to cart
        boolean success = cartDAO.addItemToCart(cartItem);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (success) {
            out.println("<h1>Item added to cart successfully!</h1>");
        } else {
            out.println("<h1>Error adding item to cart!</h1>");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get item ID from request parameter
        String itemIdStr = request.getParameter("productId");
        String userName = request.getParameter("userName");
        if (itemIdStr == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            PrintWriter out = response.getWriter();
            out.println("<h1>Item ID is missing!</h1>");
            return;
        }

        // Convert item ID to integer
        int itemId = Integer.parseInt(itemIdStr);

        // Delete item from cart
        boolean success = cartDAO.deleteItemFromCart(itemId, userName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (success) {
            out.println("<h1>Item deleted from cart successfully!</h1>");
        } else {
            out.println("<h1>Error deleting item from cart!</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get all items in cart for a specific user
        String userName = request.getParameter("userName");
        List<Cart> cartItems = cartDAO.getAllCartItems(userName);

        // Convert to JSON and send response
        ObjectMapper mapper = new ObjectMapper();
        String cartItemsJson = mapper.writeValueAsString(cartItems);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(cartItemsJson);
    }
}
