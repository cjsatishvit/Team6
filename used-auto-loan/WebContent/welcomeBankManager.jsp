<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcomeBankManager</title>
</head>
<body>
<p style="text-align:right;"><%= new java.util.Date() %></p>
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
<h2> Welcome Bank Manager</h2>
<br>

<br>
<form action ="GenerateReport">

<input type="submit" value="Generate Report">
</form>
<br>
<br>

<br>
<br>



</center>
</body>
</html>