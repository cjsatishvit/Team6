package login.dishi.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginRegister() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BankUserDAO bd = new BankuserDAOImpl();
		String userName=request.getParameter("username");
		String password=request.getParameter("password1");
		String submitType=request.getParameter("submit");
		Bankuser b = bd.getuser(userName, password);
		if(submitType.equals("login") && b!=null && b.getName()!=null) {
			request.setAttribute("message", b.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else if(submitType.contentEquals("register")) {
			b.setName(request.getParameter("name"));
			b.setPassword(password);
			b.setUsername(userName);
			bd.insertuser(b);
			request.setAttribute("successMessage", "Registration done, please login to continue!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("message","Data Not Found, click on Register !!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
