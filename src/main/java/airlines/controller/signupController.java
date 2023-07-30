package airlines.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airlines.dao.passengerDAO;
import airlines.dao.staffDAO;
import airlines.dao.userDAO;
import airlines.model.passenger;
import airlines.model.staff;
import airlines.model.user;

/**
 * Servlet implementation class signupController
 */
@WebServlet("/signupController")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static userDAO dao;  
	private static passengerDAO pdao;   
	private static staffDAO sdao;
	String action="",forward="";  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        dao = new userDAO();
        pdao = new passengerDAO();
        sdao = new staffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String role = request.getParameter("role");
		user user = new user();
		
		if(role.equalsIgnoreCase("passenger")) {
		passenger pass = new passenger();
		//retrieve input and set
		user.setEmail(request.getParameter("email"));		
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		pass.setFirstname(request.getParameter("name"));
		pass.setLastname(request.getParameter("lname"));
		pass.setContactnumber(request.getParameter("pnum"));
		PrintWriter out = response.getWriter();

    	out.println(request.getParameter("email"));
    	out.println(request.getParameter("password"));
    	out.println(request.getParameter("role"));
    	out.println(request.getParameter("name"));
    	out.println(request.getParameter("lname"));
    	out.println(request.getParameter("pnum"));
    	
 			
		user = userDAO.getUser(user);
		boolean valid = user.isValid();
		out.println(valid);
		boolean b = false;
		
		//check if user exists
		if(valid==b){
        	try {
        		//if user not exist, add/register the user
				dao.add(user);
				int uidPass=dao.getUserByEmailID(request.getParameter("email"));
				pass.setUserid(uidPass);
				pdao.add(pass);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
		if(role.equalsIgnoreCase("staff")) {
			staff staff = new staff();
			//retrieve input and set
			user.setEmail(request.getParameter("email"));		
			user.setPassword(request.getParameter("password"));
			user.setRole(request.getParameter("role"));
			staff.setStaffname(request.getParameter("staffname"));
			
			user = userDAO.getUser(user);
			boolean validd = user.isValid();
			
			boolean bb = false;
			
			//check if user exists
			if(validd==bb){
	        	try {
	        		//if user not exist, add/register the user
					dao.add(user);
					int uidStaff=dao.getUserByEmailID(request.getParameter("email"));
					staff.setUserid(uidStaff);
					sdao.addStaff(staff);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		}
        	
        	//redirect to login page
        	RequestDispatcher view = request.getRequestDispatcher("Login.jsp"); // staff page
			view.forward(request, response);	
        }       
		
	}

