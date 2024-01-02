<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%@page import="com.asgprojects.dao.*,com.asgprojects.bean.*"%>
	<%@page import="java.io.PrintWriter"%>
	<%@page import="javax.servlet.http.Cookie"%>
	<%
	String id = request.getParameter("uid");
	String pas = request.getParameter("password");
	User u = UserDao.getRecordById(Long.parseLong(id));
	PrintWriter pw = response.getWriter();
	if (u != null) {
		if (u.getPassword().equals(pas)) {
			//pw.println("<h1>Success</h1><br><p>Please wait redirecting...<p>");
			// Create a new username cookie
			Cookie usernameCookie = new Cookie("username", id);
			usernameCookie.setMaxAge(24 * 60 * 60); // 1 day
			// Add cookies to the response
			response.addCookie(usernameCookie);
			response.sendRedirect("job-search.jsp");
		} else {
			pw.println("<h1>Incorrect username or password</h1>");
		}
	} else {
		pw.println("<h1>User not found</h1>");
	}
	%>