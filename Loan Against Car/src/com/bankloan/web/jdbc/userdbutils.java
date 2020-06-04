package com.bankloan.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class userdbutils {
	
	int t=10;
	
	private DataSource dataSource; // for connection to database 
	
	public userdbutils(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public void regUser(userinfo user) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get db connection
			Class.forName("com.mysql.jdbc.Driver"); // loads the driver
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_loan","utkrisht","utkrisht");
			
			// create sql for insert
			String sql = "insert into customer "
					   + "(customer_fname,customer_lname,customer_phone,customer_address,customer_account,customer_pass,customer_email,customer_dob) "
					   + "values (?, ?, ?, ?, ?, ?, ?, ?);";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, user.getFname());
			myStmt.setString(2, user.getLname());
			myStmt.setString(3, user.getPhone());
			myStmt.setString(4, user.getAddress());
			myStmt.setString(5, user.getCustomerID());
			myStmt.setString(6, user.getPass());
			myStmt.setString(7, user.getEmail());
			myStmt.setString(8, user.getDOB());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}
	
private void close(Connection myConn, PreparedStatement myStmt,ResultSet myRs) {
		
		try {
			
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	


public int checkUser(userinfo theUser) throws SQLException  {
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;

        //getting connection to database
		myConn = dataSource.getConnection();
		String id = theUser.getCustomerID();
		String sql="select * from customer where customer_account="+'"'+id+'"';//sql query to retrieve bidder
		myStmt = myConn.prepareStatement(sql);
		myRs = myStmt.executeQuery(sql);//the myRs variable stores rows returned after the query execution
		while(myRs.next())
		{
		String pass=myRs.getString("customer_pass");
		if(pass.equals(theUser.getPass()))//check if password entered matches the one in database
		{
		   t=1;  
		}
		else {
			t=0;
		}
		}
		
	   
		close(myConn, myStmt, myRs);
		return t;
			
}
public void addapplication(loanApplication theuser) throws Exception{
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs=null;
	
	try {
		// get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into loan "
				   + "(loan_id, loan_account, loan_amount, loan_type, loan_time, loan_manufacturer, loan_car, loan_salary, loan_dom, loan_insurance, loan_status, fname, lname, email, phone, address) "
				   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		// set the param values for the bidder application
		myStmt.setString(1, theuser.getLoan_id());
		myStmt.setString(2, theuser.getLoanAccount());
		myStmt.setString(3, theuser.getAmount());
		myStmt.setString(4, theuser.getType());
		myStmt.setString(5, theuser.getTime());
		myStmt.setString(6, theuser.getManufacturer());
		myStmt.setString(7, theuser.getCar());
		myStmt.setString(8, theuser.getSalary());
		myStmt.setString(9, theuser.getDOM());
		myStmt.setString(10, theuser.getInsurance());
		myStmt.setString(11, theuser.getStatus());
		myStmt.setString(12, theuser.getFname());
		myStmt.setString(13, theuser.getLname());
		myStmt.setString(14, theuser.getEmail());
		myStmt.setString(15, theuser.getPhone());
		myStmt.setString(16, theuser.getAddress());
		// execute sql insert
		myStmt.execute();
		
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, myRs);
	}
	}


public int loginloanofficer(loanofficer theOfficer) throws SQLException {
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	myConn = dataSource.getConnection();
	String id = theOfficer.getID();
	String sql = "select * from bank_employee where emp_id="+'"'+id+'"';
	myStmt = myConn.prepareStatement(sql);
	myRs = myStmt.executeQuery(sql);
	while(myRs.next())
	{
	String pass=myRs.getString("emp_pass");
	if(pass.equals(theOfficer.getPassword()))
	{
	   t=1;  
	}
	else {
		t=0;
	}
	}
	close(myConn, myStmt, myRs);
	
	return t;
}

public void deleteLoan(loanApplication theloan) throws SQLException {
Connection myConn = null;
PreparedStatement myStmt = null;
ResultSet myRs = null;
myConn = dataSource.getConnection();
String id = theloan.getLoan_id();
String sql="delete from loan where loan_id="+'"'+id+'"';//sql query to delete loan
myStmt = myConn.prepareStatement(sql);
myStmt.execute();
close(myConn, myStmt, myRs);
}

public void approvalOfficer(String ID) throws SQLException{
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	myConn = dataSource.getConnection();
	String id = ID;
	String sql = "update loan set loan_status ='WITH MANAGER' where loan_id="+'"'+id+'"'; // query to update status of the loan 
	myStmt = myConn.prepareStatement(sql);
	myStmt.execute();
	close(myConn, myStmt, myRs);
}

public  List<loanApplication> getApplications() throws SQLException {
	
	List<loanApplication> loans = new ArrayList<>();
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	myConn = dataSource.getConnection();
	String sql = "select * from loan order by loan_id"; 
	
	myStmt = myConn.prepareStatement(sql);
	myRs = myStmt.executeQuery(sql);
	while (myRs.next()) {
			
			
			String loan_id = myRs.getString("loan_id");
			String loan_account = myRs.getString("loan_account");
			String loan_time = myRs.getString("loan_time");
			String loan_amount = myRs.getString("loan_amount");
			String loan_type = myRs.getString("loan_type");
			String loan_status = myRs.getString("loan_status")  ;
			String loan_car = myRs.getString("loan_car");
			String loan_manufacturer = myRs.getString("loan_manufacturer");
			String loan_insurance = myRs.getString("loan_insurance");
			String loan_salary = myRs.getString("loan_salary");
			String loan_dom = myRs.getString("loan_dom");
			String fname = myRs.getString("fname");
			String lname = myRs.getString("lname");
			String email = myRs.getString("email");
			String phone = myRs.getString("phone");
			String address = myRs.getString("address");
			
			
			
			
			loanApplication temp = new loanApplication(loan_id,  loan_account,  loan_time,  loan_amount,  loan_type,  loan_status,
					 loan_car,loan_manufacturer, loan_insurance, loan_salary, loan_dom, fname, lname, email, phone, address);
			
		
			loans.add(temp);//adding returned loan application details to the list to display 				
		}
		close(myConn,myStmt, myRs);
		return loans;		
	}


public  List<loanApplication> getApplicationsManager() throws SQLException {
	
	List<loanApplication> loans = new ArrayList<>();
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	myConn = dataSource.getConnection();
	String sql = "select * from loan order by loan_id where loan_status='WITH MANAGER'"; // here 
	
	myStmt = myConn.prepareStatement(sql);
	myRs = myStmt.executeQuery(sql);
	while (myRs.next()) {
			
			
			String loan_id = myRs.getString("loan_id");
			String loan_account = myRs.getString("loan_account");
			String loan_time = myRs.getString("loan_time");
			String loan_amount = myRs.getString("loan_amount");
			String loan_type = myRs.getString("loan_type");
			String loan_status = myRs.getString("loan_status")  ;
			String loan_car = myRs.getString("loan_car");
			String loan_manufacturer = myRs.getString("loan_manufacturer");
			String loan_insurance = myRs.getString("loan_insurance");
			String loan_salary = myRs.getString("loan_salary");
			String loan_dom = myRs.getString("loan_dom");
			String fname = myRs.getString("fname");
			String lname = myRs.getString("lname");
			String email = myRs.getString("email");
			String phone = myRs.getString("phone");
			String address = myRs.getString("address");
			
			
			
			
			loanApplication temp = new loanApplication(loan_id,  loan_account,  loan_time,  loan_amount,  loan_type,  loan_status,
					 loan_car,loan_manufacturer, loan_insurance, loan_salary, loan_dom, fname, lname, email, phone, address);
			
		
			loans.add(temp);//adding returned loan application details to the list to display 				
		}
		close(myConn,myStmt, myRs);
		return loans;		
	}

public userinfo getUser(userinfo theuser) throws SQLException {
	String account = theuser.getCustomerID();
	userinfo temp = null;
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	myConn = dataSource.getConnection();
	String sql = "select * from customer where customer_account="+'"'+account+'"';
	myStmt = myConn.prepareStatement(sql);
	myRs = myStmt.executeQuery(sql);
	while (myRs.next()) {
		String customer_id = myRs.getString("customer_account");
		String fname = myRs.getString("customer_fname");
		String lname = myRs.getString("customer_lname");
		String phone = myRs.getString("customer_phone");
		String email = myRs.getString("customer_email");
		String password = myRs.getString("customer_pass");
		String dob = myRs.getString("customer_dob");
		String gender = myRs.getString("customer_gender");
		String address = myRs.getString("customer_address");
		
	    temp=new userinfo(fname, lname,gender,password, phone, email,customer_id ,dob,address);
	}
	close(myConn, myStmt, myRs);
	return temp;//returning user object to retrieve email address to send email
			
	}

}
