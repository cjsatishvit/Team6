<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>generateReport</title>
</head>
<body>
	<form action="GenrateReport" method="post">
		<table
			style="background-color:lightpink; margin-left: 20px; margin-left: 20px;">
			<tr>
			<td><h3 style="color:red;">${message}</h3>
			<h3 style="color:green;">${successMessage}</h3>
			</td>
			<td><h3>Bank manager Login</h3></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><a href="report.jsp"><b>Login to view report</b></a></td>
			</tr>
		</table>
	</form>
</body>
</html>