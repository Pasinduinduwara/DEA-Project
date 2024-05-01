package com.example.servlet;

import com.example.dao.UserDAO;
import com.example.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parse JSON request body
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(request.getReader(), User.class);

        boolean success = UserDAO.addUser(user);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (success) {
            out.println("<h1>User added successfully!</h1>");
        } else {
            out.println("<h1>Error adding user!</h1>");
        }
    }
  }















