<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOAN OFFICER LOGIN</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<h1 style="text-align:center">LOAN OFFICER LOGIN</h1>
<br/>
<br/>
<div>
<form action="ControllerServlet" method="GET">
<input type="hidden" name="command" value="LOAN OFFICER" />
OFFICER ID:<br/><input type="text" name="officer id"/>
<br/>
<br/>
PASSWORD:<br/><input type="password" name="pwd"/>
<br/>
<br/>
<input type="submit" value="login"/>
</form>
</div>

</body>
</html>