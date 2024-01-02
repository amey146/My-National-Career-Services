<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.asgprojects.dao.UserDao"%>
<jsp:useBean id="u" class="com.asgprojects.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%

int i = UserDao.save(u);
PrintWriter pw = response.getWriter();
if (i > 0) {
	//pw.println("<h1>Success</h1><br><p>Please wait redirecting...<p>");
	response.sendRedirect("job-search.jsp");
} else {
	String s = "Error";
	pw.println(s);
}
%>
