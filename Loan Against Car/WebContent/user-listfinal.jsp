<!-- Displays the list of approved loans by the loan officer ,the page can be accessed only by the bank manager in his login -->
<%@page import="com.bankloan.web.jdbc.loanApplication"%> 
<%@page import="java.util.ArrayList"%> 
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER LIST</title>
<link rel="stylesheet" type="text/css" href="css/tabledesign.css"/>
</head>
<body>

<h1>THE APPROVED LOANS</h1>
<table>
			
				<tr>
				<th>ACCOUNT NO</th>
					<th>FIRST NAME</th>
					<th>LASR NAME</th>
					<th>MANUFACTURER</th>
					<th>MODEL</th>
					<th>ADDRESS</th>
					<th>EMAIL</th>
					<th>PHONE</th>
					<th>SALARY</th>
					<th>LOAN AMOUNT</th>
					<th>LOAN TIME</th>
					<th>LOAN_ID</th>
				</tr>
				<%ArrayList<loanApplication>user=(ArrayList<loanApplication>)request.getAttribute("LOAN-LIST");
				for(loanApplication s:user){%>
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
				<%} %>
				
				
			</table>
			<br/>
			<br/>
			<a href="approve.jsp">APPROVE LOAN LIST</a>
			<a href="delete.jsp"> REJECT A LOAN </a>

</body>
</html>