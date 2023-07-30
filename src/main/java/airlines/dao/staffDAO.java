package airlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import airlines.connection.ConnectionManager;
import airlines.model.staff;

public class staffDAO {
	
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	
	int staffid;
	String staffname;
	int userid;
	
	//get staff by userid
	public static staff getStaffById1(int uid) {
		staff staf = new staff();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			ps = con.prepareStatement("SELECT * FROM staff where userid=?");
			ps.setInt(1, uid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				staf.setStaffid(rs.getInt("staffid"));
				staf.setStaffname(rs.getString("staffname"));
				staf.setUserid(rs.getInt("userid"));
			}
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return staf;
	}
	
	//add staff
	public void addStaff(staff bean) {
		staffname = bean.getStaffname();
		userid = bean.getUserid();
		
		try {
			//call getConnection() method //3. create statement //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			String sql = "INSERT INTO staff(staffname, userid)VALUES(?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, staffname);
			ps.setInt(2, userid);
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//update staff by user id
	public void updateStaff(staff bean) {
		
		staffname = bean.getStaffname();
		userid = bean.getUserid();
		
		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
					
			//create statement
			String sql = "UPDATE staff SET staffname=? WHERE userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, staffname);
			ps.setInt(2, userid);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//view staff by id
	public static staff getStaffById(int staffid) {
		staff staff = new staff();
		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
			
			//create statement
			String sql = "SELECT * FROM staff WHERE staffid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, staffid);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				staff.setStaffid(rs.getInt("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setUserid(rs.getInt("userid"));
			}
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return staff;
	}
	
	//view staff by userid
	public static staff getStaffByUId(int userid) {
		staff staff = new staff();
		try {
			con = ConnectionManager.getConnection();
			
			String sql = "SELECT * FROM staff WHERE userid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				staff.setStaffid(rs.getInt("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setUserid(rs.getInt("userid"));
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return staff;
	}
	
	
	//list
	public static List<staff> getAllStaff(){
		List<staff> sta = new ArrayList<staff>();
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM staff");
			
			while(rs.next()) {
				staff staf = new staff();
				staf.setUserid(rs.getInt("userid"));
				staf.setStaffid(rs.getInt("staffid"));
				staf.setStaffname(rs.getString("staffname"));
				sta.add(staf);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sta;
	}
}
