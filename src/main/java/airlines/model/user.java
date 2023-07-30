package airlines.model;

public class user {

	int userid;
	String email;
	String password;
	String role; 
	boolean valid;

	public user(int user, String email, String password, String role) {
		super();
		this.userid = user;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public user() {
		super();
		email = null;
		password = null;
		role = null;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getUser() {
		return userid;
	}
	public void setUser(int user) {
		this.userid = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
