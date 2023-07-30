package airlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import airlines.connection.ConnectionManager;
import airlines.model.airport;

public class airportDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	String airportcode;
	String airportname;
	
	//get all airport
	public static List<airport> getAllAirport(){
		List<airport> airports = new ArrayList<airport>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement(); 
			//4. execute query
			rs = stmt.executeQuery("select * from airport");
			
			while (rs.next()) { 
				airport airport = new airport();
				airport.setAirportcode(rs.getString("airportcode"));
				airport.setAirportname(rs.getString("airportname"));
				airport.setCityname(rs.getString("cityname"));
				airports.add(airport);
			}
		
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return airports;
	}
	//get airportname for flights from_f
			public static airport getAirportById(String airportcode) {
				
				airport airport = new airport();
				
				try {
					//call getConnection() method
					con = ConnectionManager.getConnection();
					//3. create statement
					String sql = "SELECT * from airport where airportcode=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, airportcode);
					rs = ps.executeQuery();
					
					if (rs.next()) { 
						airport.setAirportcode(rs.getString("airportcode"));
						airport.setAirportname(rs.getString("airportname"));
						airport.setCityname(rs.getString("cityname"));
					}
				
				con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return airport;
			}
			
	}
