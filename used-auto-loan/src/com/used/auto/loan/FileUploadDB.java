package com.used.auto.loan;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/FileUploadDB")
@MultipartConfig(maxFileSize = 9656820)    // upload file's size up to 16MB


public class FileUploadDB extends HttpServlet {
     
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/used_auto_loan";
    private String dbUser = "root";
    private String dbPass = "sou19999";
    Connection conn = null; // connection to the database
    PreparedStatement statement =null;
    ResultSet res=null;
    Statement stm=null;
    
    String message = null;  // message will be sent back to client
    
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
    	String uname= request.getParameter("uname");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String raddress= request.getParameter("raddress");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        String amount = request.getParameter("amount");
            
        String model = request.getParameter("model");
        String plate = request.getParameter("plate");
        String vname = request.getParameter("vname");
        String vaddress= request.getParameter("vaddress");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
                 
        try 
        {
            // connects to the database
             Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "INSERT INTO used_auto_loan.application (first_name, last_name, Form, Application_Type, Requested_Amount, Status_Loan, Date_Applied, userName, Email, Phone, ResidentAddress, Model, PlateNumber, Vendor, VendorAddress) values (?, ?, ?, 'UAL', ?, 'Pending.', ?,?   ,?,? ,? ,?,?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3, inputStream);
            }
            statement.setString(4, amount);
            Date now = new Date();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            String mysqlDateString = formatter.format(now);
            
            statement.setString(5,mysqlDateString );
            statement.setString(6, uname);
            
            statement.setString(7, email);
            statement.setString(8, phone);
            statement.setString(9, raddress);
            statement.setString(10, model);
            statement.setString(11, plate);
            statement.setString(12, vname);
            statement.setString(13, vaddress);
            
            // sends the statement to the database server
            int row = statement.executeUpdate();
            
                       
            if (row > 0) 
            {
            	
                message = "File uploaded and saved into database.";
            }
        } 
        catch (SQLException ex) 
        {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
            if (conn != null) 
            {
                // closes the database connection
                try 
                {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
    }


}