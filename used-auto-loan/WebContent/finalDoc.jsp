<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>finalDoc</title>
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

 <%
 String id =request.getParameter("Id");
 %>
					 
	
					 <form  action="GenDoc">
	 <table border="0">
                
                <tr>
                    <td>Application ID : </td>
                    <td><input type="text" name="id" value=<%=id %> readonly/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Next">
                    </td>
                </tr>
            </table>
        </form>
					
				
</center>



</body>
</html>