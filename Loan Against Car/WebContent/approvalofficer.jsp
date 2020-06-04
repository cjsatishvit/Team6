<!-- This page takes in the loan id of the loan whose application the loan officer wants to forward,the corresponding application is forwarded to manager -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORWARD APPLICATION</title>
<link rel="stylesheet" type="text/css" href="css/style2.css"/>
</head>
<body>
<h1 style="text-align:center">FORWARD APPLICATION</h1>
<br/>
<br/>
<div>
<form action="controllerservlet" method="GET">
<input type="hidden" name="command" value="FORWARD" />
LOAN ID:<br/><input type="text" name="loan id"/>
<br/>
<br/>
<input type="submit" value="submit"/>
</form>
</div>

</body>
</html>