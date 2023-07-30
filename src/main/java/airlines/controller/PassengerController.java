package airlines.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlines.dao.passengerDAO;
import airlines.dao.userDAO;
import airlines.model.passenger;

/**
 * Servlet implementation class PassengerController
 */
@WebServlet("/PassengerController")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private passengerDAO pdao;
	private userDAO udao;
	    String action="";
	    String forward="";
	    String role ="";
	    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerController() {
        super();
        udao = new userDAO();
        pdao = new passengerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("viewProfile")) {
			
			forward = "passenger/Profile.jsp";
			int uid= Integer.parseInt(request.getParameter("id"));
			request.setAttribute("pass", passengerDAO.getPassengerByUId(uid));
		}
		
		if (action.equalsIgnoreCase("updateProfile")) {
			forward = "passenger/ProfileEdit.jsp";
			int uid = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("pass", passengerDAO.getPassengerByUId(uid));
		}
		
		if (action.equalsIgnoreCase("viewPassenger")) {
			
			forward = "staff/viewpassenger.jsp";
			int uid= Integer.parseInt(request.getParameter("id"));
			request.setAttribute("pass", passengerDAO.getPassengerById(uid));
		}
		
		if (action.equalsIgnoreCase("passengerList")) {
			
			forward = "staff/passengerList.jsp";
			
			request.setAttribute("pass", passengerDAO.getAllpassenger());
		}
		
		if(action.equalsIgnoreCase("deleteAcc")) {
            int uid= Integer.parseInt(request.getParameter("id"));
            udao.deleteUser(uid);
            HttpSession session = request.getSession(true);
            session.setAttribute("sessionEmail", null);
            session.invalidate();
            forward = "Login.jsp";
        }

		 view = request.getRequestDispatcher(forward);
	     view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		passenger passenger = new passenger();
		
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String passic = request.getParameter("passic");
		String address = request.getParameter("address");
		String contnumber = request.getParameter("contnumber");
		int userid = Integer.parseInt(request.getParameter("id"));
		
		passenger.setFirstname(name);
		passenger.setLastname(lname);
		passenger.setPassport_ic(passic);
		passenger.setAddress(address);
		passenger.setContactnumber(contnumber);
		passenger.setUserid(userid);
		
		pdao.updatePassenger(passenger);
		
		request.setAttribute("pass", passengerDAO.getPassengerByUId(userid));
        view = request.getRequestDispatcher("passenger/Profile.jsp");
    	view.forward(request, response);
	}

}
