package com.asgprojects.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asgprojects.bean.Job;
import com.asgprojects.dao.JobDao;

//@WebServlet("/AddJob")
public class AddJob extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Job j = new Job(
				 	Integer.parseInt(request.getParameter("job_id")),  
				    Integer.parseInt(request.getParameter("job_salary")),
				    Integer.parseInt(request.getParameter("job_exp")),
				    request.getParameter("job_title"),
				    request.getParameter("job_desc"),
				    request.getParameter("job_country"),
				    request.getParameter("job_state"),
				    request.getParameter("job_district"),
				    request.getParameter("job_city"),
				    request.getParameter("job_org"),
				    request.getParameter("job_sector"),
				    request.getParameter("job_function")
				    );
		int i = JobDao.save(j);
		if (i > 0) {
			System.out.println("<h1>Success</h1><br><p>Please wait redirecting...<p>");
			response.sendRedirect("job-search.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
