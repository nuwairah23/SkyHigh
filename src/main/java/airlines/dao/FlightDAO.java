package airlines.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import airlines.connection.ConnectionManager;
import airlines.model.flight;

public class FlightDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	int flightid;
	String aircraft;
	String departuredate;
	String departuretime;
	String arrivaledate;
	String arrivaltime;
	String f_from;
	String f_to;
	String flighttype;
	
	//add flight
	public void add(flight bean){
		departuredate = bean.getDeparturedate();
		departuretime = bean.getDeparturetime();
		arrivaledate = bean.getArrivaldate();
		arrivaltime = bean.getArrivaltime();
		f_from = bean.getFrom_f();
		f_to = bean.getTo_f();
		flighttype = bean.getFlighttype();
		
		try {
			//call getConnection() method //3. create statement //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("insert into flight(aircraft,departuredate,departuretime,arrivaledate,arrivaltime,f_from,f_to,flighttype)values(?,?,?,?,?,?,?,?)");
			ps.setString(1,aircraft);
			ps.setString(2,departuredate);
			ps.setString(3,departuretime);
			ps.setString(4,arrivaledate);
			ps.setString(5,arrivaltime);
			ps.setString(6,f_from);
			ps.setString(7,f_to);
			ps.setString(8,flighttype);
			
			//4. execute query
			ps.executeUpdate();
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete flight
	public void deleteFlight(String fliid) {
		try {
		con = ConnectionManager.getConnection();
		ps=con.prepareStatement("delete from flight where flightid=?");
		ps.setString(1, fliid);
		ps.executeUpdate();
		con.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	
	//get all flight
	public static List<flight> getAllFlight() {
		List<flight> flis = new ArrayList<flight>();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement(); 
			//4. execute query
			rs = stmt.executeQuery("select * from flight");
			
			while (rs.next()) { 
				flight fli = new flight();
				
				fli.setFlightid(rs.getString("flightid"));
				fli.setDeparturedate(rs.getString("departuredate"));
				fli.setDeparturetime(rs.getString("departuretime"));
				fli.setArrivaldate(rs.getString("arrivaldate"));
				fli.setArrivaltime(rs.getString("arrivaltime"));
				fli.setFrom_f(rs.getString("from_f"));
				fli.setTo_f(rs.getString("to_f"));
				fli.setReturndate(rs.getString("returndate"));
				fli.setReturntime(rs.getString("returntime"));
				fli.setArrivalreturndate(rs.getString("arrivalreturndate"));
				fli.setArrivalreturntime(rs.getString("arrivalreturntime"));
				fli.setFlighttype(rs.getString("flighttype"));
				fli.setPrice(rs.getDouble("price"));
				flis.add(fli);
		}
		
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flis;
	}
	//search flights
	public static List<flight> searchFlights(String departuredate, String from_f, String to_f , String flighttype,  String returndate) {
		
		List<flight> flights = new ArrayList<flight>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			
			String sql;
			if(flighttype.equalsIgnoreCase("One-way")) {
				sql = "SELECT * FROM flight WHERE departuredate like '%"+departuredate+"%' and from_f like '%"+from_f+"%' and to_f like '%"+to_f+"%' and flighttype like '%"+flighttype+"%'";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					flight f = new flight();
					f.setFlightid(rs.getString("flightid"));
					f.setDeparturedate(rs.getString("departuredate"));
					f.setDeparturetime(rs.getString("departuretime"));
					f.setArrivaldate(rs.getString("arrivaldate"));
					f.setArrivaltime(rs.getString("arrivaltime"));
					f.setFrom_f(rs.getString("from_f"));
					f.setTo_f(rs.getString("to_f"));
					f.setFlighttype(rs.getString("flighttype"));
					f.setPrice(rs.getDouble("price"));
					flights.add(f);
				}

			}
			if(flighttype.equalsIgnoreCase("Round-trip")) {
				sql = "SELECT * FROM flight WHERE departuredate like '%"+departuredate+"%' and from_f like '%"+from_f+"%' and to_f like '%"+to_f+"%' and flighttype like '%"+flighttype+"%' and returndate like '%"+returndate+"%'";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					flight f = new flight();
					f.setFlightid(rs.getString("flightid"));
					f.setDeparturedate(rs.getString("departuredate"));
					f.setDeparturetime(rs.getString("departuretime"));
					f.setArrivaldate(rs.getString("arrivaldate"));
					f.setArrivaltime(rs.getString("arrivaltime"));
					f.setFrom_f(rs.getString("from_f"));
					f.setTo_f(rs.getString("to_f"));
					f.setFlighttype(rs.getString("flighttype"));
					f.setPrice(rs.getDouble("price"));
					f.setReturndate(rs.getString("returndate"));
					f.setReturntime(rs.getString("returntime"));
					f.setArrivalreturndate(rs.getString("arrivalreturndate"));
					f.setArrivalreturntime(rs.getString("arrivalreturntime"));
					flights.add(f);
				}
			}

			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flights;
	}
	
	//get flight by id
	public static flight getFlightById(String flightid) {
		flight flight = new flight();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("select * from flight where flightid=?");
			ps.setString(1, flightid);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	   
				flight.setFlightid(rs.getString("flightid"));
				flight.setDeparturedate(rs.getString("departuredate"));
				flight.setDeparturetime(rs.getString("departuretime"));
				flight.setArrivaldate(rs.getString("arrivaldate"));
				flight.setArrivaltime(rs.getString("arrivaltime"));
				flight.setFrom_f(rs.getString("from_f"));
				flight.setTo_f(rs.getString("to_f"));
				flight.setFlighttype(rs.getString("flighttype"));
				flight.setPrice(rs.getDouble("price"));
				flight.setReturndate(rs.getString("returndate"));
				flight.setReturntime(rs.getString("returntime"));
				flight.setArrivalreturndate(rs.getString("arrivalreturndate"));
				flight.setArrivalreturntime(rs.getString("arrivalreturntime"));
			}
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}
		
		return flight;
	}
	
	
}
