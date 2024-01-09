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

		// Build WHERE clause conditionally
		boolean hasWhereClause = false;

		// For location (applied to both queries)
		String location = request.getParameter("location");
		if ("states".equals(location)) {
			String state = request.getParameter("state");
			spacer.append(" WHERE jobState = '").append(state).append("'");
			hasWhereClause = true;
		}

		// For Keywords
		String[] keywords = request.getParameter("keywords").split(";");
		if (keywords.length > 0 && !keywords[0].isEmpty()) {
			StringBuilder keywordClause = new StringBuilder("(");
			for (int i = 0; i < keywords.length; i++) {
				String keyword = keywords[i].trim();
				keywordClause.append("jobTitle LIKE '%").append(keyword).append("%'");
				if (i < keywords.length - 1) {
					keywordClause.append(" OR ");
				}
			}
			keywordClause.append(")");

			if (hasWhereClause) {
				spacer.append(" AND ").append(keywordClause.toString());
			} else {
				spacer.append(" WHERE ").append(keywordClause.toString());
				hasWhereClause = true;
			}
		}

		// For sectors
		String[] selectedSectors = request.getParameterValues("sector");

		if (selectedSectors != null) {
			if (hasWhereClause) {
				spacer.append(" AND jobSector IN (" + String.join(",", selectedSectors) + ")");
			} else {
				spacer.append(" WHERE jobSector IN (" + String.join(",", selectedSectors) + ")");
				hasWhereClause = true;
			}
		}
		// For functional
		String functionalarea = request.getParameter("functionalarea");
		if (!(functionalarea.equals("all"))) {
			if (hasWhereClause) {
				spacer.append(" AND jobFunction = " + functionalarea);
			} else {
				spacer.append(" WHERE jobFunction = " + functionalarea);
				hasWhereClause = true;
			}
		}
		// For experience
		String experience = request.getParameter("exp");
		if (Integer.parseInt(experience) > 0) {
			if (hasWhereClause) {
				spacer.append(" AND jobExp <= " + experience);
			} else {
				spacer.append(" WHERE jobExp <= " + experience);
				hasWhereClause = true;
			}
		}

		// For org
		if (org.equals("private")) {
			query = "SELECT jobTitle FROM PRIV_JOBS" + spacer +";";
		} else if (org.equals("government")) {
			query = "SELECT jobTitle FROM GOV_JOBS" + spacer +";";
		} else {
			// Use a subquery to apply the location condition to both UNION queries
			query = "SELECT jobTitle FROM (SELECT jobTitle FROM PRIV_JOBS" + spacer
					+ " UNION SELECT jobTitle FROM GOV_JOBS" + spacer + ") AS combined_jobs;";
		}
		// Print the final query
		System.out.println(query);

	}

}
