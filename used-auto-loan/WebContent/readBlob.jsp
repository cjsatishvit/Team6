<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read File</title>
</head>
 <%
		response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	
	%>
<body>
<%
	String id =request.getParameter("Id");
	ServletOutputStream sos;
	Connection  con=null;
	PreparedStatement st=null;
 
	response.setContentType("application/pdf");

	response.setHeader("Content-disposition","inline; filename="+id+".pdf" );
	sos = response.getOutputStream();
	
	String sql = "select Form from used_auto_loan.application where ApplicationID=?;";
	String url = "jdbc:mysql://localhost:3306/?user=root";
	String username = "root";
	String password = "sou19999";
	
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
		st = con.prepareStatement(sql);
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		if (rs.next())
            sos.write(rs.getBytes("Form"));
        else
            return;
	
	}
	catch (SQLException e) 
	{
    // TODO Auto-generated catch block
    e.printStackTrace();
	}
	sos.flush();
    sos.close();





%>






</body>
</html>