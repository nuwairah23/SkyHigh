package airlines.model;

public class airport {
	String airportcode;
	String airportname;
	String cityname;
	
	public airport() {}
	public airport(String airportcode, String airportname, String cityname) {
		super();
		this.airportcode = airportcode;
		this.airportname = airportname;
		this.cityname = cityname;
	
	}
	
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getAirportcode() {
		return airportcode;
	}
	public void setAirportcode(String airportcode) {
		this.airportcode = airportcode;
	}
	public String getAirportname() {
		return airportname;
	}
	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}
	
	

}
