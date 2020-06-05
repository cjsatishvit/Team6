package com.used.auto.loan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
// Document Object
import com.itextpdf.text.Document;
//For adding content into PDF document
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;




/**
 * Servlet implementation class GenDoc
 */
@WebServlet("/GenDoc")
public class GenDoc extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Connection con=null;
    Statement stm=null;
    ResultSet rs=null;
    
    String url = "jdbc:mysql://localhost:3306/?user=root";
	String username = "root";
	String password = "sou19999";
	String message = null;
    
    String id;
    
    
       
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
	  id= request.getParameter("id");
	  try {
          Document document = new Document();
          response.setContentType("application/pdf;charset=UTF-8");

          response.addHeader("Content-Disposition", "inline; filename=" + "report.pdf");
          ServletOutputStream out = response.getOutputStream();

			PdfWriter.getInstance(document, out);
          document.open();
                      
          addContent(document);
          
          
      } 
		catch (Exception e) 
		{
          e.printStackTrace();
      }
		
    }



private void addContent(Document document) 
{
	
	try
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
		
		String sql = "select  * from used_auto_loan.application where ApplicationID="+id+" ;";
		
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		
		PdfPTable table = new PdfPTable(5);
		
		PdfPCell c1 = new PdfPCell(new Phrase("Requested Amount "));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Plate Number"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Model"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Vendor"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Vendor Address"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);
		
		while(rs.next())
		{
			document.add(new Paragraph("\tThe Bank\n\n"));
<<<<<<< HEAD
			document.add(new Paragraph("\tMr/Mrs "+rs.getString(1)+" "+rs.getString(2)+" your application for Used Auto Loan is "+rs.getString(8)+". "+
=======
			document.add(new Paragraph("\tMr/Mrs "+rs.getString(1)+" "+rs.getString(2)+" your application for Used Auto Loan had been accepted. "+
>>>>>>> branch 'master' of https://github.com/cjsatishvit/Team6.git
			
					"The following are the details: \n\n"));
			
			table.addCell(Integer.toString(rs.getInt(6)));
			table.addCell(rs.getString(15));
			table.addCell(rs.getString(14));
			table.addCell(rs.getString(16));
			table.addCell(rs.getString(17));
			
			document.add(new Paragraph("\n\n\n\n"));
	        
			document.add(table);
			break;
		}
		
		
    }
    catch(Exception e)
    {
    	message = "ERROR: " + e.getMessage();
    	e.printStackTrace();
    }
   

    finally
    {
    	
    	document.close();
    try {
		rs.close();
		stm.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    }
    
    }
	
	
}
	 
	
	  
	  
  
	

