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

        protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Parse JSON request body
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(request.getReader(), Product.class);

            // Assuming you have a database connection and ProductDAO class for database operations
            ProductDAO productDAO = new ProductDAO();

            // Add the product to the database
            boolean success = productDAO.updateProduct(product);

            if (success) {
                out.println("<h1>Product updated successfully!</h1>");
            } else {
                out.println("<h1>Error updating product!</h1>");
            }
        }

    }

}
