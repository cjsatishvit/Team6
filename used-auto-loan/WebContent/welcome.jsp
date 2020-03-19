<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
	
	
	Welcome ${username }
	<br><br>
	 <a href="application.jsp">Fill Application for Used Auto Loan</a>
	 <form action="Logout">
	 	<input type="submit" value="Logout">
	 </form>
</body>
</html>