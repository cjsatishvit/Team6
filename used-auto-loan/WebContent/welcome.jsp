<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<p style="text-align:right;"><%= new java.util.Date() %></p>
<form action="Logout">
	 	<input type="submit" value="Logout">
	 </form>
	 <center>
<h1>The Bank</h1>
 
	<%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
	<center>
	<br>
	
	
	Welcome ${username }
	<br><br>
	 <a href="application.jsp">Fill Application for Used Auto Loan</a>
	 <br>
	 <br>
	 <a href="Status.jsp">To check submission status click here</a>
	 </center>
</body>
</html>