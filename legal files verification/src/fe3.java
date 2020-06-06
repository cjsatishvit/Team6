

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fe3
 */
@WebServlet("/fe3")
public class fe3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fe3() {
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
//String name=request.getParameter("name");
//String app=request.getParameter("app");


public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  showBankmanager(request, response);
 }

public static void main{
	String url = "jdbcmysql://localhost3306/legal";
	String user="root";
	String password="";

try
{
	Class.forName("java.sql.DriveManager"); //connecting to mysql database
	Connection con;
	con=(Connection)DriveManager.getConnection(url,user,password);
	
	//my sql statement
	Statement smt1=(Statement)con.createStatement(); //insert query for customer_details table
	
	String sql="insert into legal"
			+ "(app,name,legaldc)"
			+ "values('9999999999','mona','accepted')";
	
	smt1.executeUpdate(sql);
	
	System.out.println("insert complete,");
			
	
}

catch(Exception e)
{
	exe.printStackTrace();
}
}



