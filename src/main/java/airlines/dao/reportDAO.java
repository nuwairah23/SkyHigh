package airlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import airlines.model.report;
import airlines.connection.ConnectionManager;


public class reportDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public static List<report> mostVisited(){
  		List <report> report = new ArrayList<report>();
  		
  		try {
	  		
	  		con = ConnectionManager.getConnection();
	  		stmt = con.createStatement();
	  		String sql = "SELECT airport.cityname, count(booking.bookingid), sum(booking.fare) from airport left join flight on airport.airportcode = flight.to_f left join booking on flight.flightid = booking.flightid group by airport.cityname ORDER by count(booking.bookingid) DESC LIMIT 5;";
	  		rs = stmt.executeQuery(sql);
	  		while (rs.next()){
	  			report r = new report();
	  			r.setCity(rs.getString("airport.cityname"));
	  			r.setBookings(rs.getInt("count(booking.bookingid)"));
	  			r.setTotalsales( rs.getDouble("SUM(booking.fare)"));
	  			
	  			report.add(r);
	  		
	  			
	  		}
	  		
	  		con.close();
	  		
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
  		return report;
  	}
	
	public static List<report> salesEachFlight(){
  		List <report> report = new ArrayList<report>();
  		
  		try {
	  		
	  		con = ConnectionManager.getConnection();
	  		stmt = con.createStatement();
	  		String sql = "SELECT flight.flightid, SUM(booking.fare) from flight left join booking on flight.flightid=booking.flightid GROUP BY flight.flightid LIMIT 5;";

	  		rs = stmt.executeQuery(sql);
	  		while (rs.next()){
	  			report r = new report();
	  			r.setFlightid( rs.getString("flight.flightid"));
	  			r.setTotalsales( rs.getDouble("SUM(booking.fare)"));
	  			
	  			report.add(r);
	  		
	  			
	  		}
	  		
	  		con.close();
	  		
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
  		return report;
  	}
	public static List<report> passengersEachFlight(){
  		List <report> report = new ArrayList<report>();
  		
  		try {
	  		
	  		con = ConnectionManager.getConnection();
	  		stmt = con.createStatement();
	  		String sql = "SELECT flight.flightid, SUM(booking.totalPassenger) from flight left join booking on flight.flightid= booking.flightid GROUP BY flight.flightid LIMIT 5;";

	  		rs = stmt.executeQuery(sql);
	  		while (rs.next()){
	  			report r = new report();
	  			r.setFlightid( rs.getString("flight.flightid"));
	  			r.setPassengers( rs.getInt("SUM(booking.totalPassenger)"));
	  			
	  			report.add(r);
	  		
	  			
	  		}
	  		
	  		con.close();
	  		
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
  		return report;
  	}
	public static List<report> bookingsMadeByMonth(){
  		List <report> report = new ArrayList<report>();
  		
  		try {
	  		
	  		con = ConnectionManager.getConnection();
	  		stmt = con.createStatement();
	  		String sql = "select count(bookingid), MONTHNAME(datebookingmade),SUM(booking.fare) from booking GROUP BY MONTHNAME(datebookingmade) LIMIT 5;";

	  		rs = stmt.executeQuery(sql);
	  		while (rs.next()){
	  			report r = new report();
	  			r.setBookings( rs.getInt("count(bookingid)"));
	  			r.setTotalsales( rs.getDouble("SUM(booking.fare)"));
	  			r.setMonth(rs.getString("MONTHNAME(datebookingmade)"));
	  			report.add(r);
	  		
	  			
	  		}
	  		
	  		con.close();
	  		
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
  		return report;
  	}
	public static List<report> salesEachFlightFull(){
  		List <report> report = new ArrayList<report>();
  		
  		try {
	  		
	  		con = ConnectionManager.getConnection();
	  		stmt = con.createStatement();
	  		String sql = "SELECT flight.flightid, SUM(booking.fare) from flight left join booking on flight.flightid=booking.flightid GROUP BY flight.flightid;";

	  		rs = stmt.executeQuery(sql);
	  		while (rs.next()){
	  			report r = new report();
	  			r.setFlightid( rs.getString("flight.flightid"));
	  			r.setTotalsales( rs.getDouble("SUM(booking.fare)"));
	  			
	  			report.add(r);
	  		
	  			
	  		}
	  		
	  		con.close();
	  		
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
  		return report;
  	}
	public static List<report> passengersEachFlightFull(){
  		List <report> report = new ArrayList<report>();
  		
  		try {
	  		
	  		con = ConnectionManager.getConnection();
	  		stmt = con.createStatement();
	  		String sql = "SELECT flight.flightid, SUM(booking.totalPassenger) from flight left join booking on flight.flightid= booking.flightid GROUP BY flight.flightid ;";

	  		rs = stmt.executeQuery(sql);
	  		while (rs.next()){
	  			report r = new report();
	  			r.setFlightid( rs.getString("flight.flightid"));
	  			r.setPassengers( rs.getInt("SUM(booking.totalPassenger)"));
	  			
	  			report.add(r);
	  		
	  			
	  		}
	  		
	  		con.close();
	  		
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
  		return report;
  	}
	public static List<report> bookingsMadeByMonthFull(){
  		List <report> report = new ArrayList<report>();
  		
  		try {
	  		
	  		con = ConnectionManager.getConnection();
	  		stmt = con.createStatement();
	  		String sql = "select count(bookingid), MONTHNAME(datebookingmade),SUM(booking.fare) from booking GROUP BY MONTHNAME(datebookingmade);";

	  		rs = stmt.executeQuery(sql);
	  		while (rs.next()){
	  			report r = new report();
	  			r.setBookings( rs.getInt("count(bookingid)"));
	  			r.setTotalsales( rs.getDouble("SUM(booking.fare)"));
	  			r.setMonth(rs.getString("MONTHNAME(datebookingmade)"));
	  			report.add(r);
	  		
	  			
	  		}
	  		
	  		con.close();
	  		
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
  		return report;
  	}
	public static List<report> search1(String q){
		List <report> report = new ArrayList<report>();
		try {
		
		con = ConnectionManager.getConnection();
		
		stmt = con.createStatement();
		String sql = q;
		String data=null;
		
		System.out.println(q);
		if(sql!=null)
		{
			data ="SELECT flight.flightid, SUM(booking.fare) from flight left join booking on flight.flightid=booking.flightid where flight.flightid like '%"+sql+"%' GROUP BY flight.flightid ;";
			
		}
		
		rs = stmt.executeQuery(data);
		if(rs.next()){
			
			report r = new report();
  			r.setFlightid( rs.getString("flight.flightid"));
  			r.setTotalsales( rs.getDouble("SUM(booking.fare)"));
  			
  			report.add(r);
		
		}
		
		con.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	public static List<report> search2(String q){
		List <report> report = new ArrayList<report>();
		try {
		
		con = ConnectionManager.getConnection();
		
		stmt = con.createStatement();
		String sql = q;
		String data=null;
		
		System.out.println(q);
		if(sql!=null)
		{
			data ="SELECT flight.flightid, SUM(booking.totalPassenger) from flight left join booking on flight.flightid= booking.flightid where flight.flightid like '%"+sql+"%' GROUP BY flight.flightid ;";
			
		}
		
		rs = stmt.executeQuery(data);
		if(rs.next()){
			
			report r = new report();
  			r.setFlightid( rs.getString("flight.flightid"));
  			r.setPassengers( rs.getInt("SUM(booking.totalPassenger)"));
  			
  			report.add(r);
		
		}
		
		con.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	public static List<report> search3(String q){
		List <report> report = new ArrayList<report>();
		try {
		
		con = ConnectionManager.getConnection();
		
		stmt = con.createStatement();
		String sql = q;
		String data=null;
		
		System.out.println(q);
		if(sql!=null)
		{
			data ="select count(bookingid), MONTHNAME(datebookingmade),SUM(booking.fare) from booking where MONTHNAME(datebookingmade) like '%"+sql+"%'  GROUP BY MONTHNAME(datebookingmade);";
		}
		
		rs = stmt.executeQuery(data);
		if(rs.next()){
			
			report r = new report();
  			r.setBookings( rs.getInt("count(bookingid)"));
  			r.setTotalsales( rs.getDouble("SUM(booking.fare)"));
  			r.setMonth(rs.getString("MONTHNAME(datebookingmade)"));
  			report.add(r);
		
		}
		
		con.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}
  	
}
