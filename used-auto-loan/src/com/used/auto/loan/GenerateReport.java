package com.used.auto.loan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.io.File;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateReport")
public class GenerateReport extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con=null;
    Statement stm=null;
    ResultSet rs=null;
    
    String url = "jdbc:mysql://localhost:3306/?user=root";
	String username = "root";
	String password = "sou19999";
	String message = null;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
    	
		
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
		finally
        {
        	response.sendRedirect("viewBMPage.jsp");
        }
   
    }

	private void addContent(Document document) throws DocumentException 
	{
		PdfPTable table = new PdfPTable(5);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
		

        PdfPCell c1 = new PdfPCell(new Phrase("ApplicationID"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("First Name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Last Name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Requested Amount"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Status"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        
        
        table.setHeaderRows(1);
        
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
       
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
			String sql = "select  first_name, last_name,ApplicationID, Requested_Amount, Date_Applied, Status_Loan from used_auto_loan.application ;";
			
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next())
			{
				
				
				//if(rs.getString(5)!= null && mysqlDateString.equals(rs.getString(5)))
				//{
					table.addCell(Integer.toString(rs.getInt(3)));
					table.addCell(rs.getString(1));
					table.addCell(rs.getString(2));
					table.addCell(Integer.toString(rs.getInt(4)));
					table.addCell(rs.getString(6));
					
					
				//}
				//else
				//{
					//table.addCell("No Applications were submitted today.");
				//}
			}
			
			
        }
        catch(Exception e)
        {
        	message = "ERROR: " + e.getMessage();
        	e.printStackTrace();
        }
       

        finally
        {
        
        document.add(table);
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

	


