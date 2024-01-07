package com.asgprojects.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JobSearch
 */
//@WebServlet("/JobSearch")
public class JobSearch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String org = request.getParameter("job_org");
		StringBuffer spacer = new StringBuffer();
		String query = "";

		// For location (applied to both queries)
		String location = request.getParameter("location");
		if ("states".equals(location)) {
			String state = request.getParameter("state");
			spacer.append(" WHERE jobState = '" + state + "'");
		}

		// For Keywords
		// -----------------------------------------------------------------
		String[] keywords = request.getParameter("keywords").split(";");
		String keyword = null;
		StringBuilder keywordClause = new StringBuilder("(");
		for (int i = 0; i < keywords.length; i++) {
			keyword = keywords[i].trim();
			keywordClause.append("jobTitle LIKE '%").append(keyword).append("%'");
			if (i < keywords.length - 1) {
				keywordClause.append(" OR ");
			}
		}
		if (!(keyword.equals(""))) {
			keywordClause.append(")");
			spacer.append(" AND " + keywordClause.toString());
		}

		// For sectors
		String[] selectedSectors = request.getParameterValues("sector");
		if (selectedSectors != null) {
			spacer.append(" AND jobSector IN (" + String.join(",", selectedSectors) + ")");
		}
		// For functional
		String functionalarea = request.getParameter("functionalarea");
		if (functionalarea != null) {
			spacer.append(" AND jobFunction = " + functionalarea);
		}
		// For experience
		String experience = request.getParameter("exp");
		if (experience != null) {
			spacer.append(" AND jobExp <= " + experience);
		}

		// For org
		if (org.equals("private")) {
			query = "SELECT * FROM PRIV_JOBS" + spacer;
		} else if (org.equals("government")) {
			query = "SELECT * FROM GOV_JOBS" + spacer;
		} else {
			// Use a subquery to apply the location condition to both UNION queries
			query = "SELECT * FROM (SELECT * FROM PRIV_JOBS" + spacer + " UNION SELECT * FROM GOV_JOBS" + spacer
					+ ") AS combined_jobs";
		}
		// Print the final query

		System.out.println(query);

	}

}
