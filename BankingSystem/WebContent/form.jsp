<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Application form</title>
</head>
<body>
	<form action="Submitform" method="post">
		<table
			style="background-color: skyblue; margin-left: 20px; margin-left: 20px;">
			<tr>
			<td><h3 style="color:red;">${message}</h3>
			<h3 style="color:green;">${successMessage}</h3>
			</td>
			<td></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Occupation :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Account number :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Loan amount :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><a href="submitform.jsp"><b>Submit loan application form</b></a></td>
			</tr>
		</table>
	</form>
</body>
</html>