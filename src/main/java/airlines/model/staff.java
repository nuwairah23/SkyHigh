package airlines.model;

public class staff {
	
	int staffid;
	String staffname;
	int userid;
	
	
	public staff(int staffid, String staffname, int userid) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.userid = userid;
	}
	
	public staff() {
		super();
		this.staffid = 0;
		this.staffname = null;
		this.userid = 0;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
