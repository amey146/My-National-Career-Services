package com.asgprojects.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asgprojects.bean.User;
import com.asgprojects.dao.UserDao;

//@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User(
				Integer.parseInt(request.getParameter("role")), 
				Long.parseLong(request.getParameter("aadhar")), 
				request.getParameter("password"), 
				request.getParameter("name"), 
				Integer.parseInt(request.getParameter("age")), 
				request.getParameter("state"), 
				request.getParameter("district"),
				request.getParameter("city"), 
				Integer.parseInt(request.getParameter("pincode")), 
				request.getParameter("gender"));
		int i = UserDao.save(u);
		if (i > 0) {
			System.out.println("<h1>Success</h1><br><p>Please wait redirecting...<p>");
			response.sendRedirect("job-search.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
