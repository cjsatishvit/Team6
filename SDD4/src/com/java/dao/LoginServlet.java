package com.java.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("hello");
		
		String name = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		
		
		if(name.equals("rak") && password.equals("rakesh"))
		{
		
			response.sendRedirect("BankManagerHP.jsp");
		}
		
		else if(name.equals("jha") && password.equals("modak"))
		{
		
			response.sendRedirect("SiteEvaluatorHP.jsp");
		}
		
		else
		{
			
			response.sendRedirect("RetryLogin.jsp");
		}
		
		
		
	}

}
