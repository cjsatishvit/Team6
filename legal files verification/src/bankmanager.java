

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bankmanager
 */
@WebServlet("/bankmanager")
public class bankmanager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bankmanager() {
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

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String app=request.getParameter("app");
		String legaldc=request.getParameter("legaldc");
		Member member=new Member(name, app, legaldc);
		String result=rDao.insert(member);
		response.getWriter().print(result);
	}

}


try
{
	Class.forName("java.sql.DriveManager"); //connecting to mysql database
	Connection con;
	con=(Connection)DriveManager.getConnection("jdbcmysql://localhost3306/legal","root","");
	
	//my sql statement
	Statement smt1=(Statement)con.createStatement(); //insert query for customer_details table
	//smt1.executeUpdate(query1);
	
	ResultSet myRs= smt1.executeQuery("select * from legal");
	
	while(myRs.next()) {
		System.out.println(myRs.getString("app") + "," + myRs.getString("name") + "," + myRs.getString("legaldc"));
	}
	
			
	
}

catch(Exception e)
{
	System.out.println(e.getMessage());
}
}


