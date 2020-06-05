package com.used.auto.loan;

import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class StatusFind
 */
@WebServlet("/StatusFind")
public class StatusFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config;
	
	public void init(ServletConfig config) throws ServletException
	{
		this.config=config;
	}
   
	 private String dbURL = "jdbc:mysql://localhost:3306/used_auto_loan";
	    private String dbUser = "root";
	    private String dbPass = "sou19999";
	    Connection conn = null; // connection to the database
	    PreparedStatement statement =null;
	    ResultSet res=null;
	    
	    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname= request.getParameter("uname");
<<<<<<< HEAD
		//System.out.print(uname);
=======
		System.out.print(uname);
>>>>>>> branch 'master' of https://github.com/cjsatishvit/Team6.git
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List dataList = new ArrayList(); 
		try
		{
			
            Class.forName("com.mysql.cj.jdbc.Driver");
            
           conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
           String sql = "select * from used_auto_loan.application where userName='"+uname+"';";
           statement = conn.prepareStatement(sql);
           statement.executeQuery(sql);
           res= statement.getResultSet();
           while(res.next())
           {
        	   dataList.add(res.getInt("ApplicationID"));
        	   dataList.add(res.getInt("Requested_Amount"));
        	   dataList.add(res.getString("Date_Applied"));
        	   dataList.add(res.getString("Status_Loan"));
        	   //dataList.add(res.getString("Reject_Reason"));
           }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			request.setAttribute("data",dataList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("StatusFound.jsp");
			if (dispatcher != null)
			{
				  dispatcher.forward(request, response);
			} 
		}
		
		
	}

}
