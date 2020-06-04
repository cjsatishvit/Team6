<!-- This page takes in the loan id of the loan whose application the loan officer wants to reject,the corresponding application is deleted and the controller moves to the send mail page so that the rejected applicant can be notified -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REJECT APPLICATION</title>
<link rel="stylesheet" type="text/css" href="css/style2.css"/>
</head>
<body>
<h1 style="text-align:center">REJECT APPLICATION</h1>
<br/>
<br/>
<div>
<form action="ControllerServlet" method="GET">
<input type="hidden" name="command" value="DELETE" />
LOAN ID:<br/><input type="text" name="loan id"/>
<br/>
<br/>
<input type="submit" value="reject"/>
</form>
</div>

</body>
</html>