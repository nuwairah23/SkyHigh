package airlines.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airlines.dao.FlightDAO;
import airlines.dao.bookingDAO;
import airlines.dao.passengerDAO;
import airlines.dao.reportDAO;
import airlines.model.booking;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private bookingDAO dao;
    String action="";
    String forward="";
    String role ="";
    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        dao = new bookingDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");

		
		if (action.equalsIgnoreCase("addBooking")) {
			forward ="passenger/AddBooking.jsp";
			int uid = Integer.parseInt(request.getParameter("id"));
			String flightid = request.getParameter("flightid");
			request.setAttribute("pass", passengerDAO.getPassengerByUId(uid)); 
			request.setAttribute("fli", FlightDAO.getFlightById(flightid)); 
		}
		if (action.equalsIgnoreCase("listBooking")) {
			
			forward = "staff/ListBookingStaff.jsp";
			request.setAttribute("bookings", bookingDAO.getAllBookings());

		}
		
		if (action.equalsIgnoreCase("listBook")) {
			forward = "passenger/ListBooking.jsp";
			int uid = Integer.parseInt(request.getParameter("id"));
			var passB = passengerDAO.getPassengerByUId(uid);
			int passid = passB.getPassengerid();
			request.setAttribute("booking", bookingDAO.getAllBookingsByPatients(passid));
		}
		
		if (action.equalsIgnoreCase("viewBooking")) {
			forward = "passenger/ViewBooking.jsp";
			int bookid = Integer.parseInt(request.getParameter("bookingid"));
			request.setAttribute("book", bookingDAO.getBookingById(bookid));

		}
		
		if (action.equalsIgnoreCase("viewBookingstaff")) {
			forward = "staff/viewbookingstaff.jsp";
			int bookid = Integer.parseInt(request.getParameter("bookingid"));
			request.setAttribute("book", bookingDAO.getBookingById(bookid));
		}
		
		if(action.equalsIgnoreCase("deleteBooking")) {
			forward = "staff/ListBookingStaff.jsp";
			int bookid = Integer.parseInt(request.getParameter("bookingid"));
			dao.deleteBooking(bookid);
			request.setAttribute("bookings", bookingDAO.getAllBookings());
		}
		
		if (action.equalsIgnoreCase("updateBooking")) {
            forward = "staff/UpdateBooking.jsp";
            int bookid = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("book", bookingDAO.getBookingById(bookid));
        }

        if (action.equalsIgnoreCase("update")) {
            forward = "staff/viewbookingstaff.jsp";
            int bookid = Integer.parseInt(request.getParameter("id"));
            String stat = request.getParameter("statusBook");
            dao.updateBooking(stat,bookid);
            request.setAttribute("book", bookingDAO.getBookingById(bookid));
        }
        
		 view = request.getRequestDispatcher(forward);
	     view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		booking book = new booking();
		System.out.println(request.getParameter("datebookingmade"));
		String fid = request.getParameter("fid");
		int passid = Integer.parseInt(request.getParameter("passid"));
		int num = Integer.parseInt(request.getParameter("NumOfPass"));
		double tprice = Double.parseDouble(request.getParameter("tprice"));
		String paymenttype = request.getParameter("paymenttype");
		Date datebookingmade = Date.valueOf(request.getParameter("datebookingmade"));
		
		
		book.setFlightid(fid);
		book.setPassengerid(passid);
		book.setTotalPassenger(num);
		book.setPaymenttype(paymenttype);
		book.setFare(tprice);
		book.setDatebookingmade(datebookingmade);
		
		dao.add(book);
		
		RequestDispatcher view = request.getRequestDispatcher("passenger/successBooking.jsp");
	    view.forward(request, response);
	}

}
