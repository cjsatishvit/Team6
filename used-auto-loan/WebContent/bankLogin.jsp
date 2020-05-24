<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Login</title>
</head>
<body>
<p style="text-align:right;"><%= new java.util.Date() %></p>

<center>
<h1>The Bank</h1>

<br>


<form action="BankLogin" method="post">
		
			<br>
			<h3>Bank Employee Login</h3>	
	<table border="0">
                <tr>
                    <td>Enter username : </td>
                    <td><input type="text" name="uname"/></td>
                </tr>
                <tr>
                    <td>Enter password : </td>
                    <td><input type="password" name="pass"/></td>
                </tr>
                
      </table>
	<input type="Submit" value="BankLogin">
	</form>


</center>

</body>
</html>