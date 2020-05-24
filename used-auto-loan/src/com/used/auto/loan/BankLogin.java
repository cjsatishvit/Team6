package com.used.auto.loan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BankLogin")
public class BankLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BankLoginDao ld = new BankLoginDao();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		
		if(ld.check(uname,pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			if(uname.contains("B"))
			{
				response.sendRedirect("welcomeBankManager.jsp");
			}
			else if (uname.contains("L"))
			{
				response.sendRedirect("welcomeLoanOfficer.jsp");
			}
			else if (uname.contains("R"))
			{
				response.sendRedirect("welcomeReviewOfficer.jsp");
			}
							
		}
		else
		{
			response.sendRedirect("bankLogin.jsp");
		}
    	
	}

}
