package ticketSystem;


public class Booking {
	private Flight flight;
	private Customer customer;
	private Seat SeatClass;
	
	//Create new booking
	public Booking(Flight flight, Customer customer, Seat SeatClass) {
		this.flight = flight;
		this.customer = customer;
		this.SeatClass = SeatClass;	
	}
	

	public Flight getFlight() {
		return flight;
	}
	

	@Override
	public String toString() {
		return "Booking: " +" Customer:" + customer + ", "+flight +  ", "+"\n"
				+ SeatClass+"\n";
	}
	
	

}
