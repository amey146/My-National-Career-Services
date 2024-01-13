package com.asgprojects.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asgprojects.bean.User;
import com.asgprojects.dao.UserClient;
import com.asgprojects.dao.UserSuper;
import com.asgprojects.dao.User_Dao;

//@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int role = Integer.parseInt(request.getParameter("role"));
		
		int i = 0;
		User u = new User(role, Long.parseLong(request.getParameter("aadhar")),
				request.getParameter("password"), request.getParameter("name"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("state"),
				request.getParameter("district"), request.getParameter("city"),
				Integer.parseInt(request.getParameter("pincode")), request.getParameter("gender"));
		if(role == 2) {
			i = UserClient.save(u);
		}
		else if(role == 1){
			i = UserSuper.save(u);
		}
		else {
			System.out.println("Something went wrong");
		}
		if (i > 0) {
			System.out.println("Success");
			response.sendRedirect("job-search.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}
