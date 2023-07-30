package airlines.dao;

import java.security.NoSuchAlgorithmException; 
import java.sql.Connection;
import java.util.*;
import airlines.connection.ConnectionManager;
import airlines.model.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class userDAO {
	
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static int userid;
	static String email;
	static String password;
	static String role; 
	
	//get user details
	public static user login(user bean) throws NoSuchAlgorithmException{
		email = bean.getEmail();
		password = bean.getPassword();
		
		
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			
		    //4. execute query
			String sql = "select * from user where email='" + email + "'AND password='" + password + "'";
			rs = stmt.executeQuery(sql);
			System.out.println(email+" "+password);
			
			if (rs.next()) {
				int userid = rs.getInt("userid");
				String role = rs.getString("role");
				bean.setUser(userid);
				bean.setRole(role);

				System.out.println(role);
				bean.setValid(true);
			}
			
			else if (!rs.next()) {
				bean.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return bean;
	}
	
	//register
		public void add(user bean){
			
			email = bean.getEmail();
			password = bean.getPassword();
			role = bean.getRole();

			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				
				//3. create statement  
				String sql = "insert into user(email,password,role)values(?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setString(1,email);
				ps.setString(2,password);
				ps.setString(3,role);
				System.out.println(" records inserted");  
				//4. execute query
				ps.executeUpdate();			
				System.out.println(" records added");  
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

		}

		//get user by id
		public static user getUser(user bean)  {   
			
			userid = bean.getUser();
			
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//execute statement
				String sql = "select * from user where userid='" + userid + "'";
				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					int userid = rs.getInt("userid");
					bean.setUser(userid);
					bean.setValid(true);
				}
				
				else if (!rs.next()) {
					bean.setValid(false);
				}
				//5. close connection
				con.close();	
			}catch(Exception e) {
				e.printStackTrace();		
			}
			return bean;
		}

		//get user by email
		public static user getUserByEmail(String email) {
			user us = new user();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				String sql = "select * from user where email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, email);
				
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {	            
					us.setUser(rs.getInt("userid"));
					us.setEmail(rs.getString("email"));				
					us.setPassword(rs.getString("password"));

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return us;
		}
		
		//get user by email
				public int getUserBysesEmail(String email) {
					user us = new user();
					int uid=0;
					try {
						//call getConnection() method 
						con = ConnectionManager.getConnection();
						//3. create statement  
						String sql = "select * from user where email=?";
						ps=con.prepareStatement(sql);
						ps.setString(1, email);
						
						//4. execute query
						rs = ps.executeQuery();

						if (rs.next()) {	            
							uid = rs.getInt("userid");
						}
						//5. close connection
						con.close();
					}catch(Exception e) {
						e.printStackTrace();		
					}

					return uid;
				}
		
		//get user by email | just user id return
				public int getUserByEmailID(String email) {
					user us = new user();
					int uid=0;
					try {
						//call getConnection() method 
						con = ConnectionManager.getConnection();
						//3. create statement  
						String sql = "select * from user where email=?";
						ps=con.prepareStatement(sql);
						ps.setString(1, email);
						
						//4. execute query
						rs = ps.executeQuery();

						if (rs.next()) {	            
							  uid = rs.getInt("userid");
						}
						//5. close connection
						con.close();
					}catch(Exception e) {
						e.printStackTrace();		
					}
					return uid;
				}

		//get user by id
		public static user getUserById(int id) {
			user us = new user();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				String sql = "select * from user where userid=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, userid);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {
					us.setUser(rs.getInt("userid"));
					us.setPassword(rs.getString("password"));

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return us;
		}
		
		//get all user by id
		public static List<user> getUserId() {
			List<user> users = new ArrayList<user>();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//4. execute query
				String sql="select userid from user";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					user us = new user();
					us.setUser(rs.getInt("userid"));
					users.add(us);

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return users;
		}
		
		//edit user
			public void editUser(user bean) {
				
				userid = bean.getUser();
				password = bean.getPassword();
				
				try {
					//call getConnection() method  
					con = ConnectionManager.getConnection();
					//3. create statement
					String sql = "update user set password=? where userid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1, password);
					ps.setInt(2, userid);
					
					//4. execute query
					ps.executeUpdate();

					//5. close connection
					con.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		//get all user role passenger
		public static List<user> getUserPassenger() {
			List<user> users = new ArrayList<user>();
			
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//4. execute query
				rs = stmt.executeQuery("SELECT * FROM user u INNER JOIN passenger s ON u.userid = s.userid");

				while (rs.next()) {
					user us = new user();
					us.setUser(rs.getInt("userid"));
					//us.setPassengerid(passengerDAO.getPassengerById(rs.getInt("userid"))); //in user no passenger
					users.add(us);

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return users;
		}
		
		//delete user
        public void deleteUser(int uid) {
            try {
            con = ConnectionManager.getConnection();
            ps=con.prepareStatement("delete from user where userid=?");
            ps.setInt(1, uid);
            ps.executeUpdate();
            con.close();
            }
            catch(Exception e) {e.printStackTrace();}
        }










}
