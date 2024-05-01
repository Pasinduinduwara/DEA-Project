package com.example.servlet;

import com.example.dao.UserDAO;
import com.example.entity.SignInRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parse JSON request body
        ObjectMapper mapper = new ObjectMapper();
        SignInRequest signInRequest = mapper.readValue(request.getReader(), SignInRequest.class);

        // Authenticate user
        boolean authenticated = authenticateUser(signInRequest.getUserName(), signInRequest.getPassword());

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (authenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticatedUser", signInRequest.getUserName());

            // OR generate session token and return it to the client
            String sessionToken = generateSessionToken();
            out.println("<h1>Sign-in successful!</h1>");
            out.println("<p>Your session token: " + sessionToken + "</p>");
            out.println("<h1>Sign-in successful!</h1>");
        } else {
            out.println("<h1>Invalid username or password!</h1>");
        }
    }

    private boolean authenticateUser(String username, String password) {
        return UserDAO.authenticate(username, password);
    }

    private String generateSessionToken() {
        // Generate a session token
        String sessionToken = UUID.randomUUID().toString();
        return sessionToken;
    }

  }















