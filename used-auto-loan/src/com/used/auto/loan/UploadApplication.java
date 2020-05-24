package com.used.auto.loan;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadApplication")
public class UploadApplication extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	 String dbURL = "jdbc:mysql://localhost:3306/?user=root";
     String dbUser = "root";
     String dbPass = "sou19999";
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        InputStream inputStream = null;
        Part filePart = request.getPart("application");
        if (filePart != null) 
        {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "INSERT INTO used_auto_loan.application (first_name, last_name, Form) values ( ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            
             
            if (inputStream != null) 
            {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
            	int x= getAID();
                message = "Your Application has been submitted.";
            }
        } 
        catch (Exception exc)
        {
        	 message = "ERROR: " + exc.getMessage();
             exc.printStackTrace();
        }
        finally
        {
        	request.setAttribute("Message", message);
        	
        	
        	getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
        
	}


	private int getAID() 
	{
		String s= "select ApplicationID from used_auto_loan.application where userID";
		
		
		return 0;
	}


}
