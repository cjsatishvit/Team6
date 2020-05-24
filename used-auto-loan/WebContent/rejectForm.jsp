<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reject Form</title>
</head>
<body>
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

<br>
<br>
<h3>The Status had been updated!</h3>
 
 <br>
 <br>
 <a href = "viewLO.jsp">Click here to go back to the Form Page</a>


</center>

</body>
</html>