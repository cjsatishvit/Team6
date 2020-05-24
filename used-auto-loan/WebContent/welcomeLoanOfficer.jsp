<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcomeLoanOfficer</title>
</head>
<body>
	<%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
	<p style="text-align:right;"><%= new java.util.Date() %></p>
 
 
 
<form action="Logout">
	 	<input type="submit" value="Logout">
	 </form>
<center>
<h1>The Bank</h1>
<br>
<h2> Welcome Loan Officer</h2>

<br>
<a href="viewLO.jsp">View Applications Submitted</a> 

<br>
<br>

<a href="editLO.jsp">Edit Applications</a> 

</center>
</body>
</html>