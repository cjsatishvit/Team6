<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>
</head>
<body>
<form action="Logout">
	 	<input type="submit" value="Logout">
	 </form>
<%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
    <center>
    <h1> The Bank</h1>
    <h2>Form Submission Status</h2>
    <br>
    
        <h4><%=request.getAttribute("Message")%></h4>
        <br>
              <h3><a href="Status.jsp">To check submission status click here</a></h3>
              <br>
              <br>
              <a href="welcome.jsp">Click here to go back</a>
              <br>
        <br>
        
    </center>
</body>
</html>