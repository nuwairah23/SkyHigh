package airlines.model;

public class flight {
	private String flightid;
	private String departuredate;
	private String departuretime;
	private String arrivaldate;
	private String arrivaltime;
	private String from_f;
	private String to_f;
	private String flighttype;
	private double price;
	private String returndate;
	private String returntime;
	private String arrivalreturndate;
	private String arrivalreturntime;
	
	
	public flight() {}
	
	
	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getReturntime() {
		return returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}

	public String getArrivalreturndate() {
		return arrivalreturndate;
	}

	public void setArrivalreturndate(String arrivalreturndate) {
		this.arrivalreturndate = arrivalreturndate;
	}

	public String getArrivalreturntime() {
		return arrivalreturntime;
	}

	public void setArrivalreturntime(String arrivalreturntime) {
		this.arrivalreturntime = arrivalreturntime;
	}

	public String getFlightid() {
		return flightid;
	}
	
	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}
	
	public String getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	public String getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}

	public String getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getFrom_f() {
		return from_f;
	}

	public void setFrom_f(String from_f) {
		this.from_f = from_f;
	}

	public String getTo_f() {
		return to_f;
	}

	public void setTo_f(String to_f) {
		this.to_f = to_f;
	}

	public String getFlighttype() {
		return flighttype;
	}

	public void setFlighttype(String flighttype) {
		this.flighttype = flighttype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
