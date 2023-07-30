package airlines.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airlines.dao.FlightDAO;
import airlines.dao.airportDAO;

/**
 * Servlet implementation class FlightController
 */
@WebServlet("/FlightController")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private FlightDAO dao;
       String action="";
       String forward="";
       String role ="";
       RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightController() {
        super();
        dao = new FlightDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		String sesh = request.getParameter("sesh");
		String departuredate = request.getParameter("departuredate");
		String from_f = request.getParameter("from_f");
		String to_f = request.getParameter("to_f");
		String flighttype = request.getParameter("flighttype");
		String returndate = request.getParameter("returndate");
		
		System.out.println(action);
		System.out.println(sesh);
		System.out.println(from_f);
		System.out.println(to_f);
		
		if (action.equalsIgnoreCase("listFlight")) {
			forward = "AllFlight.jsp";
			request.setAttribute("fli", FlightDAO.getAllFlight());		
		}
		if (action.equalsIgnoreCase("searchFlight")) {
			if(sesh.equalsIgnoreCase("notlog")) {
				forward = "FindFlight.jsp";
			}
			if(sesh.equalsIgnoreCase("log")) {
				forward = "passenger/FindFlightLog.jsp";
			}
			request.setAttribute("flight", FlightDAO.searchFlights(departuredate, from_f, to_f, flighttype, returndate));

		}
		if (action.equalsIgnoreCase("viewFlight")) {
			String flightid = request.getParameter("flightid");
			forward = "viewFlight.jsp";
			request.setAttribute("airportf", airportDAO.getAirportById(from_f));
			request.setAttribute("airportT", airportDAO.getAirportById(to_f));
			request.setAttribute("flight", FlightDAO.getFlightById(flightid));		
		}
		
		if (action.equalsIgnoreCase("showallFlight")) {
			forward ="staff/AllFlight.jsp";
			request.setAttribute("fli", FlightDAO.getAllFlight());
		}
		
		if (action.equalsIgnoreCase("delflight")) {
			forward ="staff/AllFlight.jsp";
			String flightid = request.getParameter("flightid");
			request.setAttribute("fli", FlightDAO.getAllFlight());
			dao.deleteFlight(flightid);
		}
		
		if (action.equalsIgnoreCase("viewFlightstaff")) {
			String flightid = request.getParameter("flightid");
			forward = "staff/viewFlightstaff.jsp";
			request.setAttribute("airportf", airportDAO.getAirportById(from_f));
			request.setAttribute("airportT", airportDAO.getAirportById(to_f));
			request.setAttribute("flight", FlightDAO.getFlightById(flightid));		
		}
		
		view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

}
