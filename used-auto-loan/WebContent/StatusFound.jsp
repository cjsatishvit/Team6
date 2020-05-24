<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status Found</title>
</head>
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
<h1>The Bank</h1>
<br>



<table cellpadding="15" border="1" style="background-color: #FFFAFA;">
<tr>
<td width="119"><b>ApplicationID</b></td>
<td width="200"><b>Requested Amount</b></td>
<td width="200"><b> Date Applied</b></td>
<td width="200"><b>Status </b></td>
<td width="200" >	</td>
</tr>
<%Iterator itr;%>
<% List data= (List)request.getAttribute("data");
for (itr=data.iterator(); itr.hasNext(); )
{
%>
<tr>
<%String s=itr.next().toString(); %>
<td width="119"><%=s%></td>
<td width="200"><%=itr.next()%></td>
<td width="200"><%=itr.next()%></td>
<td width="200"><%=itr.next()%></td>
<td><a href="elaborateInfo.jsp?Id=<%=s %>">See More</a>


<%} %>

</tr>

</table>


</center>

</body>
</html>