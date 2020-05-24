<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status</title>
</head>
<body>
<p style="text-align:right;"><%= new java.util.Date() %></p>
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

	 <br>
	 <form method="post" action="StatusFind">
	 <table border="0">
                
                <tr>
                    <td>UserName : </td>
                    <td><input type="text" name="uname" value=${username} readonly/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Next">
                    </td>
                </tr>
            </table>
        </form>
	 
	  </form>

</center>

</body>
</html>