package com.asgprojects.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asgprojects.bean.User;
import com.asgprojects.dao.UserDao;

//@WebServlet("/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("uid");
        String password = request.getParameter("password");
        
        User user = UserDao.getRecordById(Long.parseLong(userId));

        if (user != null && user.getPassword().equals(password)) {
            // Create a new session and set user information
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);

            // Redirect to a specified or default URL after successful login
            String redirectURL = "job-search.jsp"; // You can modify this based on your needs
            response.sendRedirect(redirectURL);
        } else {
            // Forward to an error page or display a message
            request.setAttribute("errorMessage", "Incorrect username or password");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
