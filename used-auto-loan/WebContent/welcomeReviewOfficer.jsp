<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcomeReviewOfficer</title>
</head>
<body>
	<%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
<form action="Logout">
	 	<input type="submit" value="Logout">
	 </form>
	

<center>
<h1>The Bank</h1>
<br>
<h2> Welcome Review Officer</h2>
<br>
<br>
<a href="reviewfinal.jsp">Click Here To View Applications</a>


</center>
</body>
</html>