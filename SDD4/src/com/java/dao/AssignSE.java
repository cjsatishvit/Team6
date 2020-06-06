package com.java.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaDAO.Try1;

@WebServlet("/AssignSE")
public class AssignSE extends HttpServlet 
{
	
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try {
			request.setAttribute("data", new Try2().share());
			RequestDispatcher rd = request.getRequestDispatcher("AssignNewSE.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
