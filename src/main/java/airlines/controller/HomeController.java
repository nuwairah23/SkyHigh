package airlines.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String action="";
	    String forward="";
	    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("homeS")) {
			forward="staff/HomeStaff.jsp";
		}
		if (action.equalsIgnoreCase("homeP")) {
			forward="passenger/HomeLog.jsp";
		}
		if (action.equalsIgnoreCase("home")) {
			forward="HomeNotLog.jsp";
		}
		
		 view = request.getRequestDispatcher(forward);
	     view.forward(request, response);
		
	}
}
