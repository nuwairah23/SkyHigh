package airlines.model;

import java.sql.Date;

public class booking {

	 	private int bookingid;
	    private String flightid;
	    private String paymenttype;
	    private double fare;
	    private int passengerid;
	    private int totalPassenger;
	    private flight flight;
	    private String status;
	    private Date datebookingmade;

	    
	    public Date getDatebookingmade() {
			return datebookingmade;
		}

		public void setDatebookingmade(Date datebookingmade) {
			this.datebookingmade = datebookingmade;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public flight getFlight() {
			return flight;
		}

		public void setFlight(flight flight) {
			this.flight = flight;
		}

		public booking() {}

	    public String getPaymenttype() {
	        return paymenttype;
	    }

	    public void setPaymenttype(String paymenttype) {
	        this.paymenttype = paymenttype;
	    }

	    public int getPassengerid() {
	        return passengerid;
	    }

	    public void setPassengerid(int passengerid) {
	        this.passengerid = passengerid;
	    }

	    public int getTotalPassenger() {
	        return totalPassenger;
	    }

	    public void setTotalPassenger(int totalPassenger) {
	        this.totalPassenger = totalPassenger;
	    }

	    public int getBookingid() {
	        return bookingid;
	    }

	    public void setBookingid(int bookingid) {
	        this.bookingid = bookingid;
	    }

	    public String getFlightid() {
	        return flightid;
	    }

	    public void setFlightid(String flightid) {
	        this.flightid = flightid;
	    }

	    public double getFare() {
	        return fare;
	    }

	    public void setFare(double fare) {
	        this.fare = fare;
	    }
	public float getsmtg() {
		
		float baki = 0;
		boolean clean=false;
		if(clean==true) 
		{
			
		}
		if (flightid=="1") {
			
		}
		return baki;
	}
}
