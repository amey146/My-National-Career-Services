package com.asgprojects.servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asgprojects.bean.Job;
import com.asgprojects.dao.JobGov;
import com.asgprojects.dao.Job_Dao;
import com.asgprojects.dao.JobPriv;

//@WebServlet("/PostJob")
public class PostJob extends HttpServlet {

	private static final AtomicInteger counter = new AtomicInteger(
            (int) (System.currentTimeMillis() % Integer.MAX_VALUE) // Initialize with unique base
    );
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String org = request.getParameter("job_org");
		Job_Dao jd; //Used to save object
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
			jd = new JobGov();
			status = JobGov.save(j);
		}
		else if (org.equals("priv_jobs")) {
			jd = new JobPriv();
			status = JobPriv.save(j);
		}
		if (status > 0) {
			response.sendRedirect("job-search.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
		
	}

}
