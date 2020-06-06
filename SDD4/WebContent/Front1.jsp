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
	<table>
	
	</tr>
				<%ArrayList<loanApplication>loan=(ArrayList<loanApplication>)request.getAttribute("LOAN-LIST");
				for(loanApplication s:loan){%>
				<tr>
				<td><%=s.getLoanAccount() %></td>
				<td><%=s.getFname() %></td>
				<td><%=s.getLname() %></td>
				<td><%=s.getManufacturer() %></td>
				<td><%=s.getCar() %></td>
				<td><%=s.getAddress() %></td>
				<td><%=s.getEmail() %></td>
				<td><%=s.getPhone() %></td>
				<td><%=s.getSalary() %></td>
				<td><%=s.getAmount() %></td>
				<td><%=s.getTime() %></td>
				<td><%=s.getLoan_id() %></td>
				</tr>
				
	</p>
	
	


</html>
	
	