package airlines.model;

public class passenger {

	int passengerid;
	String firstname;
	String lastname;
	String address;
	String contactnumber;
	String passport_ic;
	int userid;
	
	public passenger(int passengerid, String firstname, String lastname, String address, String contactnumber,
			String passport_ic, int userid) {
		super();
		this.passengerid = passengerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.contactnumber = contactnumber;
		this.passport_ic = passport_ic;
		this.userid = userid;
	}
	
	public passenger() {
		super();
		this.passengerid = 0;
		this.firstname = null;
		this.lastname = null;
		this.address = null;
		this.contactnumber = null;
		this.passport_ic = null;
		this.userid = 0;
	}
	
	public int getPassengerid() {
		return passengerid;
	}
	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getPassport_ic() {
		return passport_ic;
	}
	public void setPassport_ic(String passport_ic) {
		this.passport_ic = passport_ic;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
