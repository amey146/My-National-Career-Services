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

		// For Keywords
		// -----------------------------------------------------------------
		String[] keywords = request.getParameter("keywords").split(";");
		StringBuilder keywordClause = new StringBuilder("(");
		for (int i = 0; i < keywords.length; i++) {
			String keyword = keywords[i].trim();
			keywordClause.append("keywords LIKE '%").append(keyword).append("%'");
			if (i < keywords.length - 1) {
				keywordClause.append(" OR ");
			}
		}
		keywordClause.append(")");
		String finalQuery = "SELECT * FROM jobs_table WHERE " + keywordClause.toString();

		// For location
		// -----------------------------------------------------------------
		String location = request.getParameter("location");
		System.out.println(location);
		if ("states".equals(location)) {
			String state = request.getParameter("state");
			keywordClause.append(" AND location = " + "'" + state + "'");
		} else {
			// Do Nothing
		}

		// For District
		// -----------------------------------------------------------------
		String district = request.getParameter("district");

		if (district != null) {
			keywordClause.append(" AND district = " + "'" + district + "'");
		}

		// For City
		// -----------------------------------------------------------------
		String city = request.getParameter("city");

		if (district != null) {
			keywordClause.append(" AND city = " + "'" + city + "'");
		}
		finalQuery = "SELECT * FROM jobs_table WHERE " + keywordClause.toString();
		System.out.println(finalQuery);
	}

}

/*
 * ...{ SELECT * FROM jobs_table WHERE (location = 'allIndia' OR location =
 * 'selectedState') AND organisation_type = 'selectedOrgType' AND sector IN
 * (selectedSector1, selectedSector2, ...) AND functional_area =
 * 'selectedFunctionalArea' AND experience = 'selectedExperience' }
 * 
 */