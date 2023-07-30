package airlines.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airlines.dao.reportDAO;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private reportDAO dao;
	String action="";
    String forward="";
    String role="";
    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        dao = new reportDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("search1")) {
			
			forward = "staff/ListReportSales.jsp";
			String q = request.getParameter("q");
			request.setAttribute("sales", reportDAO.search1(q));
		}
		if(action.equalsIgnoreCase("search2")) {
			
			forward = "staff/ListReportFlight.jsp";
			String q = request.getParameter("q");
			request.setAttribute("num", reportDAO.search2(q));
		}
		if(action.equalsIgnoreCase("search3")) {
			
			forward = "staff/ListReportBookings.jsp";
			String q = request.getParameter("q");
			request.setAttribute("book", reportDAO.search3(q));
		}
		 if(action.equalsIgnoreCase("report")) {
	        	forward = "staff/ReportList.jsp";
	        	request.setAttribute("most", reportDAO.mostVisited());
	        	request.setAttribute("sales", reportDAO.salesEachFlight());
	        	request.setAttribute("num", reportDAO.passengersEachFlight());
	        	request.setAttribute("book", reportDAO.bookingsMadeByMonth());
	     }
		 if(action.equalsIgnoreCase("listReport1")) {
	        	forward = "staff/ListReportSales.jsp";
	        	request.setAttribute("sales", reportDAO.salesEachFlightFull());
	     }
		 if(action.equalsIgnoreCase("listReport2")) {
	        	forward = "staff/ListReportFlight.jsp";
	        	request.setAttribute("num", reportDAO.passengersEachFlightFull());
	     }
		 if(action.equalsIgnoreCase("listReport3")) {
	        	forward = "staff/ListReportBookings.jsp";
	        	request.setAttribute("book", reportDAO.bookingsMadeByMonthFull());
	     }
		
		view = request.getRequestDispatcher(forward);
	    view.forward(request, response);
	}

}
