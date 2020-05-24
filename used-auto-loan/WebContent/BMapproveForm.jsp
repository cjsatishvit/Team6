<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Form</title>
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
	  <%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
<center>
<h1>The Bank</h1>
<%
	Connection con =null;
	Statement stm = null;
	
	boolean t= false;
	String url = "jdbc:mysql://localhost:3306/?user=root";
	String username = "root";
	String password = "sou19999";
	String id =request.getParameter("Id");
	String sql = "update used_auto_loan.application set Status_Loan='BMApproved' where ApplicationID="+id;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}
	catch(ClassNotFoundException e)
	{
	}
	try
	{
		
		con = DriverManager.getConnection(url, username, password);
		stm = con.createStatement();
		
		int x = stm.executeUpdate(sql);
		if (x==1)
		{
			t=true;
			
		}
	}
	catch (Exception e)
	{
		
	}
	finally
	{
		if (t==true)
		{
			%>
			
			<h2>The Application has been approved.</h2>
			<br>
			<a href= "viewBMPage.jsp">Click Here To Go Back</a>
			
			<%
		}
		
		else
		{
			%>
			<h2>There was an error in approving the Application.</h2>
			<br>
			<a href= "viewBMPage.jsp">Click Here To Go Back</a>
			
			
			<%
			
			
			
		}
	}

%>






</center>

</body>
</html>