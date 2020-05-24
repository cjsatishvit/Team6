<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rejection Reason</title>
<form action="Logout">
	 	<input type="submit" value="Logout">
	 </form>
</head>
 <%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
<body>
<%
	String id= request.getParameter("Id");
%>
<center>
<h1>The Bank</h1>
<br>
<br>
<form action = "SubmitRejection">
<table>
<tr>
<td>Enter Rejection Reason in 100 chracters : </td>
                    <td><input type="text" name="R"/></td>
 </tr>
 <tr>
 <td>Application ID</td>
<td><input type="text" name= "Id" value=<%=id %> readonly></td>
</tr>
</table>
<input type="Submit" value="Submit">

</form>


</center>

</body>
</html>