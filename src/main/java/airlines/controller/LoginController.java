package airlines.controller;
import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import airlines.dao.userDAO;
import airlines.model.user;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static userDAO dao;	
	HttpSession session;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		dao = new userDAO();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			user user = new user();
			//retrieve and set email and password
			user.setEmail((request.getParameter("email")));
			user.setPassword(request.getParameter("password"));

			user = userDAO.login(user);
			String messageStatus;
			//set user session if user is valid
			if(user.isValid()){
				session = request.getSession(true);
				session.setAttribute("sessionEmail", user.getEmail());
				System.out.println(user.getEmail());
				
				session.setAttribute("sessionRole", user.getRole()); 
				System.out.println(user.getRole());
				
				session.setAttribute("sessionId", user.getUser());
				System.out.println(user.getUser());
				
				messageStatus ="SUCCESS";
				if(user.getRole().equalsIgnoreCase("staff")) {
					request.setAttribute("user", userDAO.getUserById(user.getUser()));   				
					RequestDispatcher view = request.getRequestDispatcher("staff/HomeStaff.jsp"); // staff page
					view.forward(request, response);	
				}
				else {
					request.setAttribute("user", userDAO.getUserById(user.getUser()));   									
					RequestDispatcher view = request.getRequestDispatcher("passenger/HomeLog.jsp"); 	 // passenger page
					view.forward(request, response);	
				}											
			}
			
			//redirect here if user is not valid
			 else
	         {
				 messageStatus = "Invalid user credentials.";
	             request.setAttribute("errMessage", messageStatus); 
	             RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
	             view.forward(request, response);
	         }		
		}

		catch (Throwable ex) {
			System.out.println(ex);
		}
	}

}