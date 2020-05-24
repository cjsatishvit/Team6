<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
</head>
<body>
<form action="Logout">
	 	<input type="submit" value="Logout">
	 </form>
<%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
	
	%>
<center>
        <h1>The Bank</h1>
        <br>
        <br>
        <h2>Used Auto Loan Application</h2>
        <br>
        <br>
        <form method="post" action="FileUploadDB" enctype="multipart/form-data">
            <table border="0">
                
                <tr>
                    <td>UserName : </td>
                    <td><input type="text" name="uname" value=${username} readonly/></td>
                </tr>
                
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" size="50"/></td>
                </tr>
                
                               
                
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastName" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Resident Address : </td>
                    <td><input type="text" name="raddress" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Email : </td>
                    <td><input type="text" name="email" size="75"/></td>
                </tr>
                
                <tr>
                    <td>Phone Number : </td>
                    <td><input type="number" name="phone" size="50"/></td>
                </tr>
                               
                <tr>
                    <td>Requested Amount : </td>
                    <td><input type="number" name="amount" size="50"/></td>
                </tr>
                
                <tr>
                    <td> Car Model : </td>
                    <td><input type="text" name="model" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Lisence Plate Number : </td>
                    <td><input type="text" name="plate" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Vendor Name : </td>
                    <td><input type="text" name="vname" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Vendor Address : </td>
                    <td><input type="text" name="vaddress" size="100"/></td>
                </tr>
                
                <tr>
                    <td>Document: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>