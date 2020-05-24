<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
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
<h1>The Bank</h1>
<br>

<table cellpadding="15" border="1" style="background-color: #FFFAFA;">
	<tr>
		<td>	First Name	</td>
		<td>	Last Name	</td>
		<td>	Phone	</td>
		<td>	ApplicationID	</td>
		<td>	Date Applied	</td>
		<td>	Car Model	</td>
		<td>	Plate Number	</td>
		<td>	Vendor Name	</td>
		<td>	Vendor Address	</td>
		<td>	Document	</td>
		<td>		</td>
		<td>		</td>
	</tr>
	
		 <%
	 	String sql = "select * from used_auto_loan.application order by ApplicationID;";
		String url = "jdbc:mysql://localhost:3306/?user=root";
		String username = "root";
		String password = "sou19999";
	 	try
	 	{
	 		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery(sql);
			
			while(res.next())
				{
				if(((res.getString(8)).contains("Pending")))
				{
					
				%>
				<tr>
				<td><%=res.getString(1)%></td>
				<td><%=res.getString(2)%></td>
				<td><%=res.getString(12)%></td>
				<td><%=res.getInt(3) %></td>
				<td><%=res.getString(7)%></td>
				<td><%=res.getString(14)%></td>
				<td><%=res.getString(15)%></td>
				<td><%=res.getString(16)%></td>
				<td><%=res.getString(17)%></td>
				<td><a href="readBlob.jsp?Id=<%=res.getInt(3)%>" >View Document</a></td>
				<td><a href="approveForm.jsp?Id=<%=res.getInt(3)%>">Approve</a></td>
				<td><a href="rejectForm1.jsp?Id=<%=res.getInt(3)%>">Reject</a></td>
				</tr>
				<%
				}
				}
	 	}
	 	catch (Exception e)
	 	{
	 		e.printStackTrace();
	 	}
	 
	 %>
		
</table>


</center>
</body>
</html>