package com.example.servlet;

import com.example.dao.ProductDAO;
import com.example.entity.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
        // Initialize ProductDAO
        ProductDAO ProductDAO = new ProductDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getMethod().equalsIgnoreCase("PATCH")) {
            doPatch(request, response);}
        else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Parse JSON request body
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(request.getReader(), Product.class);

            // Assuming you have a database connection and ProductDAO class for database operations
            ProductDAO productDAO = new ProductDAO();
            boolean success = productDAO.addProduct(product);

            if (success) {
                out.println("<h1>Product created successfully!</h1>");
            } else {
                out.println("<h1>Error creating product!</h1>");
            }
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get product ID from request parameter
        String productIdStr = request.getParameter("id");
        if (productIdStr == null) {
            out.println("<h1>Product ID is missing!</h1>");
            return;
        }

        // Convert product ID to integer
        int productId = Integer.parseInt(productIdStr);

        // Assuming you have a database connection and ProductDAO class for database operations
        ProductDAO productDAO = new ProductDAO();

        // Delete the product from the database
        boolean success = productDAO.deleteProduct(productId);

        if (success) {
            out.println("<h1>Product deleted successfully!</h1>");
        } else {
            out.println("<h1>Error deleting product!</h1>");
        }
    }
}