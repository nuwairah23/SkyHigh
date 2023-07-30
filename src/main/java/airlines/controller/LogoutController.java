package airlines.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import airlines.dao.userDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO dao;
	HttpSession session;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutController() {
		super();
		dao = new userDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//get the current session
			HttpSession session = request.getSession(true);
			//set current session to null.
			session.setAttribute("sessionEmail", null);
			//destroy session
			session.invalidate();			
			//redirect to login page						  
			response.sendRedirect("Login.jsp");			
		}catch (Throwable ex) {
			System.out.println(ex);
		}
	}	

}