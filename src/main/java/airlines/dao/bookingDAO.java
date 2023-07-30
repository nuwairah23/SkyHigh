package airlines.dao;

import airlines.model.booking;
import airlines.connection.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bookingDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
    private String flightid;
    private double fare;
    private int passengerid;
    private int totalPassenger;
    private String paymenttype;
    private String status;
    private Date datebookingmade;
    
    //add booking
    public void add(booking bean){		
		flightid = bean.getFlightid();
		passengerid = bean.getPassengerid();
		fare = bean.getFare();
		totalPassenger = bean.getTotalPassenger();
		paymenttype = bean.getPaymenttype();
		datebookingmade = bean.getDatebookingmade();
		status = "successful";
		
		try {
			//call getConnection() method //3. create statement //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			String sql = "INSERT INTO booking (flightid,paymenttype, fare, passengerid, totalPassenger,datebookingmade,status)VALUES(?,?,?,?,?,?,?)";

			ps= con.prepareStatement(sql);
			ps.setString(1,flightid);
			ps.setString(2,paymenttype);
			ps.setDouble(3,fare);
			ps.setInt(4,passengerid);
			ps.setInt(5,totalPassenger);
			ps.setDate(6, datebookingmade);
			ps.setString(7, status);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
    
  //list bookings by passenger id
  	public static List<booking> getAllBookingsByPatients(int passid){
  		List <booking> booking = new ArrayList<booking>();
  		
  		try {
  		
  		con = ConnectionManager.getConnection();
  		
  		String sql = "SELECT * FROM booking b INNER JOIN flight f ON b.flightid = f.flightid WHERE passengerid=?";
  		ps = con.prepareStatement(sql);
  		ps.setInt(1, passid);
  		
  		rs = ps.executeQuery();
  		while(rs.next()){
  			
  			booking b = new booking();
  			b.setBookingid(rs.getInt("bookingid"));
  			b.setPassengerid(rs.getInt("passengerid"));
  			b.setFlightid(rs.getString("flightid"));
  			b.setFare(rs.getDouble("fare"));
  			b.setPaymenttype(rs.getString("paymenttype"));
  			b.setTotalPassenger(rs.getInt("totalPassenger"));
  			b.setDatebookingmade(rs.getDate("datebookingmade"));
  			b.setFlight(FlightDAO.getFlightById(rs.getString("flightid")));
  			booking.add(b);
  			System.out.println("BookingDAO (list): "+rs.getInt("bookingid"));
  		
  		}
  		
  		con.close();
  		
  		}catch (Exception e) {
  			e.printStackTrace();
  		}
  		return booking;
  	}
  	
  	//list booking for staff
	public static List<booking> getAllBookings(){
		List<booking> bookings = new ArrayList<booking>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			String sql = "SELECT * FROM booking b INNER JOIN flight f ON b.flightid = f.flightid ORDER BY bookingid";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				booking b = new booking();
				b.setBookingid(rs.getInt("bookingid"));
				b.setFlightid(rs.getString("flightid"));
				b.setPaymenttype(rs.getString("paymenttype"));
				b.setFare(rs.getDouble("fare"));
				b.setPassengerid(rs.getInt("passengerid"));
				b.setTotalPassenger(rs.getInt("totalPassenger"));
				b.setDatebookingmade(rs.getDate("datebookingmade"));
				b.setFlight(FlightDAO.getFlightById(rs.getString("flightid")));
				bookings.add(b);
			}
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookings;
	}
	
	//view booking
	public static booking getBookingById(int bookingid) {
		booking book = new booking();
		
		try {
			con = ConnectionManager.getConnection();
			
	  		String sql = "SELECT * FROM booking b INNER JOIN flight f ON b.flightid = f.flightid WHERE bookingid=?";
	  		ps = con.prepareStatement(sql);
	  		ps.setInt(1, bookingid);
	  		
	  		rs = ps.executeQuery();
	  		
	  		if(rs.next()) {
	  			book.setBookingid(rs.getInt("bookingid"));
	  			book.setPassengerid(rs.getInt("passengerid"));
	  			book.setFlightid(rs.getString("flightid"));
	  			book.setFare(rs.getDouble("fare"));
	  			book.setPaymenttype(rs.getString("paymenttype"));
	  			book.setTotalPassenger(rs.getInt("totalPassenger"));
	  			book.setDatebookingmade(rs.getDate("datebookingmade"));
	  			book.setFlight(FlightDAO.getFlightById(rs.getString("flightid")));
	  			book.setStatus(rs.getString("status"));
	  		}
	  		
	  		con.close();
	  		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	//delete booking
	public void deleteBooking(int bookingid) {
		try {
			con = ConnectionManager.getConnection();
			
			String sql = "DELETE FROM booking WHERE bookingid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookingid);
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE
    public void updateBooking(String status, int bookid) {
        String sql = "UPDATE booking set status=? where bookingid=?";
        System.out.println(status);
        System.out.println(bookid);
        try {
            con = ConnectionManager.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, bookid);
            ps.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
