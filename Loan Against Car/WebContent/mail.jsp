<%@page import="com.bankloan.web.jdbc.userinfo"%> 
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>SEND MAIL</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form action="controllerservlet" method="post">
<table border="1">
<tbody>
<tr>
<td>To</td>
<%userinfo bd=(userinfo)request.getAttribute("LOAN-MAIL");%>
<td><input type="text" name="to" value=<%=bd.getEmail()%>/></td>
</tr>
<tr>
<td>Subject</td>
<td><input type="text" name="subject"/></td>
</tr>
<tr>
<td>message</td>
<td><textarea rows="5" cols="25" name="message"></textarea></td>
</tr>
<tr>
<td>User email id</td>
<td><input type="text" name="user"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="pass"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit"  value="send"/></td>
</tr>
</tbody>
</table>

</form>

</body>
</html>