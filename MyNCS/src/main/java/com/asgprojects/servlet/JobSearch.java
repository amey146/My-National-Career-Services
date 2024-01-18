package com.asgprojects.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asgprojects.bean.DatabaseConnection;
import com.asgprojects.bean.Job;

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
			query = "SELECT * job FROM PRIV_JOBS" + spacer + ";";
		} else if (org.equals("government")) {
			query = "SELECT jobTitle, jobCity FROM GOV_JOBS" + spacer + ";";
		} else {
			// Use a subquery to apply the location condition to both UNION queries
			query = "SELECT * FROM (SELECT * FROM PRIV_JOBS" + spacer + " UNION SELECT * FROM GOV_JOBS" + spacer
					+ ") AS combined_jobs;";
		}
		// Print the final query
		System.out.println(query);
		request.setAttribute("searchQuery", query);
		request.getRequestDispatcher("job-list.jsp").forward(request, response);

		// ... (Database connection and query execution)
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {

			con = DatabaseConnection.getConnection();
			statement = con.prepareStatement(query);
			results = statement.executeQuery();

			PrintWriter out = response.getWriter();
			out.println("<html><head>");
			out.println("<link href='css/displayjobstyle.css' rel='stylesheet'>");

			List<Job> searchResults = new ArrayList<>();
			while (results.next()) {
				searchResults.add(new Job(results.getInt("jobId"), results.getInt("jobSalary"),
						results.getInt("jobExp"), results.getString("jobTitle"), results.getString("jobDesc"),
						results.getString("jobState"), results.getString("jobDistrict"), results.getString("jobCity"),
						results.getString("jobSector"), results.getString("jobFunction")));
			}

			results.close();
			statement.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
