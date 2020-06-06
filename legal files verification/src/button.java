

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class button
 */
@WebServlet("/button")
public class button extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public button() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

buttonGroup.add(rb1);
rb1.setText("accepted");

buttonGroup.add(rb2);
rb2.setText("rejected");

private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {

String text= tf1.getText();
String value="";

if(rb1.isSelected())
{
	value="accepted";
}
else if(rb2.isSelected())
{
	value="rejected";
}
else
{
	value="null";
}


try
{
	Class.forName("java.sql.DriveManager"); //connecting to mysql database
	Connection con;
	con=(Connection)DriveManager.getConnection("jdbcmysql://localhost3306/legal","root","");
	
	//my sql statement
	Statement smt1=(Statement)con.createStatement(); //insert query for customer_details table
	
	
	smt1.executeUpdate(sql);
			
	
}

catch(Exception e)
{
	System.out.println(e.getMessage());
}
}






