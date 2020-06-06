<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% ArrayList EmpRec = (ArrayList)request.getAttribute("data"); %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="design2.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h1>Site Evaluator</h1>
	
	<h2>The following sites have been assigned to you:</h2>

	<p class="ViewSite">
	<ol>
		<li><a href="SiteEvaluation.jsp">Gaur City, 12GT Road, Kolkata-700003 M:987456321</a></li><br><br><br>
		<li><a href="SiteEvaluation.jsp">12B, Hatibagan Main Road, Kolkata-753214 M:4561237899</a></li><br><rb><br>
	</ol>
	</p>
	
	


</html>
	
	