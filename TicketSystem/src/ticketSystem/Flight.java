package ticketSystem;



public class Flight {
	private String target;
	private String date;
	private int numberOfSeats;
	private String flightnumber;

	
	
	
	//Create new flight
	public Flight(String flightnumber,String date, String target, int numberOfSeats) {
		this.target = target;
		this.date = date;
		this.numberOfSeats = numberOfSeats;
		this.flightnumber = flightnumber;			
	}
	public Flight(String flightnumber,String date, String target) {
		this.target = target;
		this.date = date;
		this.flightnumber = flightnumber;			
	}
	public Flight() {
	}
	
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	/*public Flight(String date, String target) {
		this.date=date;
		this.target=target;
	}*/
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	

	@Override
	public String toString() {
		
		return "Flight number: " + flightnumber +" "+ "Flight date: " + date + " target: " + target;
	}

	

}
