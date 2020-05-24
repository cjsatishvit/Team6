package com.used.auto.loan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitRejection
 */
@WebServlet("/SubmitRejection")
public class SubmitRejection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con =null;
		Statement stm = null;
		
		boolean t= false;
		String url = "jdbc:mysql://localhost:3306/?user=root";
		String username = "root";
		String password = "sou19999";
		String id =request.getParameter("Id");
		String s = request.getParameter("R");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			stm = con.createStatement();
			
			
				
				String sql = "update used_auto_loan.application set Status_Loan='Rejected', Reject_Reason='"+s+"' where ApplicationID="+id;
				int x = stm.executeUpdate(sql);
				if (x==1)
				{
					t=true;
				}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(t==true)
			{
				response.sendRedirect("rejectForm.jsp");
			}
			else
			{
				response.sendRedirect("rejectForm1.jsp");
			}
		}

	
	}

}
