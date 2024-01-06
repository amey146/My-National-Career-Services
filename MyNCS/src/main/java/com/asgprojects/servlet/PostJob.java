package com.asgprojects.servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asgprojects.bean.Job;
import com.asgprojects.bean.User;
import com.asgprojects.dao.GovJob;
import com.asgprojects.dao.JobDao;
import com.asgprojects.dao.PrivJob;
import com.asgprojects.dao.UserDao;

//@WebServlet("/PostJob")
public class PostJob extends HttpServlet {

	private static final AtomicInteger counter = new AtomicInteger(
            (int) (System.currentTimeMillis() % Integer.MAX_VALUE) // Initialize with unique base
    );
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String org = request.getParameter("job_org");
		JobDao jd;
		int status = 0;
		String[] selectedValues = request.getParameterValues("job_sector");
		String combinedValues = String.join(",", selectedValues);
		Job j = new Job(
				counter.incrementAndGet(), //id
				Integer.parseInt(request.getParameter("job_salary")), 
				Integer.parseInt(request.getParameter("job_exp")), 
				request.getParameter("job_title"), 
				request.getParameter("job_desc"), 
				request.getParameter("job_state"), 
				request.getParameter("job_district"),
				request.getParameter("job_city"), 
				combinedValues, //sector 
				request.getParameter("job_function"));
		if(org.equals("gov_jobs")) {
			jd = new GovJob();
			status = GovJob.save(j);
		}
		else if (org.equals("priv_jobs")) {
			jd = new PrivJob();
			status = PrivJob.save(j);
		}
		if (status > 0) {
			System.out.println("<h1>Success</h1><br><p>Please wait redirecting...<p>");
			response.sendRedirect("job-search.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
		
	}

}
