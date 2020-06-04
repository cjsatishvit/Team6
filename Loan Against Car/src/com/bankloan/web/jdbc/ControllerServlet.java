package com.bankloan.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private userdbutils userdbutil; //here
	
	@Resource(name="jdbc/bank_loan")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException{
		super.init();
		// create our own db util .. and pass in the conn pool/datasource
		try {
			userdbutil = new userdbutils(dataSource);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			switch (theCommand) {
			case "ADD":
				addUser(request,response);//function to register new loans into the database
				break;
			case "LOGIN":				
				loginUser(request,response); // login functioning of user to apply for loan
				break;
			case "CONFIRM":
				loanapplication(request,response);//function to store loan application form in database
				break;
			case "LOAN OFFICER":
				officerlogin(request,response);
				break;
			case "VIEW APPLICATIONS":
				applicationview(request,response);//function which displays list of loan applications
				break;
			case "DELETE":
				loandelete(request,response);//function to delete a loan application by the loan officer or Manager
				break;
			case "FORWARD": //approval by loan officer
				forwardToManager(request,response);//used to forward a loan application after being investigated by the loan officer to the manager 
				break;
			case "APPROVAL":
				loanfinallist(request,response);//used to display the final list of loan applications after being investigated by the manager
				break;
			
			}
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	}
	
	private void forwardToManager(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	
		String ID = request.getParameter("loan id");
		userdbutil.approvalOfficer(ID); // this sets status to forwarded to manager in DB;
		RequestDispatcher dispatcher = request.getRequestDispatcher("/approvedofficer.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void loanfinallist(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<loanApplication> users = userdbutil.getApplicationsManager();//call to function which returns the list of loans forwarded to manager from database
		request.setAttribute("LOAN-LIST", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user-listfinal.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerID = request.getParameter("customerid");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phonenumber = request.getParameter("phone");
		String email = request.getParameter("email");	
		String password = request.getParameter("pass");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String address = request.getParameter("line1")+" "+request.getParameter("line2")+" ";
		address+=request.getParameter("city")+" "+request.getParameter("state")+" "+request.getParameter("pincode");
		
		// create a new user object
		userinfo theUser= new userinfo(firstName,lastName,gender,password,phonenumber,email,customerID,dob,address);
		
		// add the user to the database
		userdbutil.regUser(theUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp"); //here
		dispatcher.forward(request, response);
  }
	
	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String customerID = request.getParameter("customer id");
		String password = request.getParameter("pass");
		// create a new user object
		userinfo theUser= new userinfo(customerID, password);
		
		int r = userdbutil.checkUser(theUser);//compare login details with database stored values
		if(r==1)//if user found with correct details the function returns 1 else 0
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loanAgainstCar.jsp");
			dispatcher.forward(request, response);
		}
		if(r==0)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmation.jsp");
			dispatcher.forward(request, response);
		}
 }

	private void loanapplication(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loan_id=request.getParameter("loan_id");
		String loan_account=request.getParameter("accountNo");
		String loan_type=request.getParameter("loan_type");
		String loan_time=request.getParameter("loan_time");
		String loan_amount=request.getParameter("loan_amount");
		String loan_salary=request.getParameter("salary");
		String loan_manufacturer=request.getParameter("manufacturer");
		String loan_car=request.getParameter("model");
		String loan_insurance = request.getParameter("insuranceCover");
		String loan_dom = request.getParameter("manufactureDate");
		String loan_status = "Loan Officer Review";
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("line1")+" "+request.getParameter("line2")+" ";
		address+=request.getParameter("city")+" "+request.getParameter("state")+" "+request.getParameter("pincode");
		
		loanApplication theuser= new loanApplication(loan_id,loan_account,loan_time,loan_amount,loan_type,loan_status,loan_car,loan_manufacturer,loan_insurance,loan_salary,loan_dom,fname,lname,email,phone,address);
		userdbutil.addapplication(theuser);//function to add application to the database
		// add the files to the database
		RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
		dispatcher.forward(request, response);
		}

	private void officerlogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String officerId=request.getParameter("officer id");
		String pass=request.getParameter("pwd");
		String post="Loan Officer";
		loanofficer theOfficer=new loanofficer(officerId, pass,post);
		int r = userdbutil.loginloanofficer(theOfficer);
		if(r==1)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loanlist.jsp");
			dispatcher.forward(request, response);
		}
		if(r==0)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmation.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	private void applicationview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//PrintWriter out=response.getWriter();
		List<loanApplication> loans = userdbutil.getApplications(); 

		request.setAttribute("LOAN-LIST", loans);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loan-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void loandelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String loan_id = request.getParameter("loan id");
		loanApplication theuser = new loanApplication(loan_id);
		userinfo theuser2=new userinfo(loan_id);
		userdbutil.deleteLoan(theuser);//function to delete a loan from database
		userinfo m = userdbutil.getUser(theuser2);//function to get the deleted user inorder to access his email id
		request.setAttribute("LOAN-MAIL", m);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mail.jsp");
		dispatcher.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp;charset=UTF-8");//used to send mail after taking data entered in the frontend page
		PrintWriter out=response.getWriter();
		String to=request.getParameter("to");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		email.send(to, subject, message, user, pass);
		out.println("<h1>mail sent successfully</h1>");

		
	}

}
