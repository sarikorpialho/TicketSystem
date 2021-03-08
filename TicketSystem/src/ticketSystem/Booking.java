package ticketSystem;

import java.util.HashMap;

public class Booking {
	private int bookingNumber;
	private Flight flight;
	private HashMap<Customer,Seat> seat;
	
	public Booking(int bookingNumber, Flight flight) {
		this.bookingNumber = bookingNumber;
		seat = new HashMap<>();
	}
	

}
