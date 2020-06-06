

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



publicclass Member 
{
	private String name,customer,amount,id,income,address,reason,aadhar,proof;

	publicMember() {
		super();
	}

	publicMember(String name, String app, String legaldc) {
		super();
		this.name = name;
		this.app = app;
		this.legaldc = legaldc;

	}
	
	public String getName() {
		returnname;
	}
	
	publicvoidsetName(String name) {
		this.name =name;
	}
	
	publicStringgetApp() {
		returnapp;
	}
	publicvoidsetApp(String app) {
		this.app =app;
	}
	public String getLegaldc() {
		returnlegaldc;
	}
	publicvoidsetLegaldc(String legaldc) {
		this.legaldc =legaldc;
	}
	




