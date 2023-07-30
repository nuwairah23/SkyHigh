package airlines.dao;

import airlines.connection.ConnectionManager;
import airlines.model.passenger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class passengerDAO {
	
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;

	int passengerid;
	 String firstname;
	 String lastname;
	 String address;
	 String contactnumber;
	 String passport_ic;
	 int userid;
	
	//get passenger by userid
	public static passenger getPassengerById1(int uid) {
		passenger pass = new passenger();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("select * from passenger where userid=?");
			ps.setInt(1, uid);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				pass.setPassengerid(rs.getInt("passengerid"));	  
				pass.setFirstname(rs.getString("firstname"));
				pass.setLastname(rs.getString("lastname"));
				pass.setAddress(rs.getString("address"));
				pass.setContactnumber(rs.getString("contactnumber"));
				pass.setPassport_ic(rs.getString("passport_ic"));
				pass.setUserid(rs.getInt("userid"));
			}
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return pass;
	}
	
			//add passenger register
			public void add(passenger bean){		
				firstname = bean.getFirstname();
				lastname = bean.getLastname();
				address = bean.getAddress();
				contactnumber = bean.getContactnumber();
				passport_ic = bean.getPassport_ic();
				userid = bean.getUserid();

				try {
					//call getConnection() method //3. create statement //4. execute query
					con = ConnectionManager.getConnection();
					//3. create statement
					ps=con.prepareStatement("INSERT into passenger(firstname,lastname,contactnumber,userid)values(?,?,?,?)");
				
					ps.setString(1,firstname);
					ps.setString(2,lastname);
					ps.setString(3,contactnumber);
					ps.setInt(4,userid);
					
					//4. execute query
					ps.executeUpdate();
					//5. close connection
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				
				}
			}
			
			//UPDATE passenger by user id
			public void updatePassenger(passenger bean) {
				//get passenger
				
				firstname = bean.getFirstname();
				System.out.println(passengerid);
				
				lastname = bean.getLastname();
				address = bean.getAddress();
				contactnumber = bean.getContactnumber();
				passport_ic = bean.getPassport_ic();
				userid = bean.getUserid();
				System.out.println(userid);
				
				try {

					// call getConnection() method from ConnectionManager class
					con = ConnectionManager.getConnection();

					// 3. create statement
					String sql = "UPDATE passenger SET firstname=? , lastname=?, address =?, contactnumber=?, passport_ic=? WHERE userid=?";
					ps= con.prepareStatement(sql);
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					ps.setString(3, address);
					ps.setString(4,contactnumber);
					ps.setString(5,passport_ic);
					ps.setInt(6,userid);
					
					// 4. execute query
					ps.executeUpdate();

					// 5. close connection
					con.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//VIEW | get passenger by id
			public static passenger getPassengerById(int passengerid) {
				passenger passenger = new passenger();
				try {

					// call getConnection() method from ConnectionManager class
					con = ConnectionManager.getConnection();

					// 3. create statement
					String sql = "SELECT* FROM passenger WHERE passengerid =? ";
					ps = con.prepareStatement(sql);
					ps.setInt(1, passengerid);
					
					
					// 4. execute query
					rs = ps.executeQuery();
					if(rs.next()) {
						passenger.setPassengerid(rs.getInt("passengerid"));
						passenger.setFirstname(rs.getString("firstname"));
						passenger.setLastname(rs.getString("lastname"));
						passenger.setAddress(rs.getString("address"));
						passenger.setContactnumber(rs.getString("contactnumber"));
						passenger.setPassport_ic(rs.getString("passport_ic"));
						passenger.setUserid(rs.getInt("userid"));
					}
					// 5. close connection
					con.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
				return passenger;
			}
	
			//VIEW | get passenger by userid
			public static passenger getPassengerByUId(int userid) {
				passenger passenger = new passenger();
				try {

					// call getConnection() method from ConnectionManager class
					con = ConnectionManager.getConnection();

					// 3. create statement
					String sql = "SELECT * FROM passenger WHERE userid =? ";
					ps = con.prepareStatement(sql);
					ps.setInt(1, userid);
					
					
					// 4. execute query
					rs = ps.executeQuery();
					if(rs.next()) {
						passenger.setPassengerid(rs.getInt("passengerid"));
						passenger.setFirstname(rs.getString("firstname"));
						passenger.setLastname(rs.getString("lastname"));
						passenger.setAddress(rs.getString("address"));
						passenger.setContactnumber(rs.getString("contactnumber"));
						passenger.setPassport_ic(rs.getString("passport_ic"));
						passenger.setUserid(rs.getInt("userid"));
					}
					// 5. close connection
					con.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
				return passenger;
			}
			
			public static List<passenger> getAllpassenger() {
				List<passenger> passe = new ArrayList<passenger>();
				try {
					//call getConnection() method
					con = ConnectionManager.getConnection();
					//3. create statement
					stmt = con.createStatement(); 
					//4. execute query
					rs = stmt.executeQuery("select * from passenger");
					
					while (rs.next()) { 
						passenger pass = new passenger();
						
						pass.setUserid(rs.getInt("userid"));
						pass.setPassengerid(rs.getInt("passengerid"));
						pass.setFirstname(rs.getString("firstname"));
						pass.setLastname(rs.getString("lastname"));
						pass.setPassport_ic(rs.getString("passport_ic"));
						pass.setContactnumber(rs.getString("contactnumber"));
						pass.setAddress(rs.getString("address"));
						passe.add(pass);
				}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				return passe;
			}
}

