package ticketSystem;

import java.util.ArrayList;

public class Booking {
	private int bookingNumber;
	private Flight flight;
	private Customer customer;
	private Seat SeatClass;
	private ArrayList<Flight> flights;
	
	//Create new booking
	public Booking(int bookingNumber,Customer customer, Flight flight, 
			Seat SeatClass) {
		this.bookingNumber = bookingNumber;
		this.flight = flight;
		this.customer = customer;
		this.SeatClass = SeatClass;	
		
	}
	public Booking() {
		this.flights = new ArrayList<>();
	}
	public void addFlight(Flight f) {
		flights.add(f);
	}
	public void removeFlight(Flight f) {
		flights.remove(f);
	}
	public boolean validFlightNumber(int number){
		
		for(Flight f:flights) {
			if(number == f.getFlightnumber()) {
				return true;
			}
		}
		return false;	
	}
	
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	public void printAllFlights() {
		
		
		for(Flight f:flights) {
			
			System.out.println(f.toString());
		}
	}
	
	public String csvFile() {
		return ""+this.bookingNumber+","+flight.getFlightnumber()+","+flight.getDate()+","
				+flight.getTarget()+","+customer.getFirstname()+","+customer.getLastname()+
				","+SeatClass.getSeatNumber();
	}
	
	public int getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	
	public Seat getSeatClass() {
		return SeatClass;
	}
	public void setSeatClass(Seat seatClass) {
		SeatClass = seatClass;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "Booking number: "+this.bookingNumber+" "+"Customer:" + customer + 
				", "+flight +  ", "+"\n"
				+ SeatClass+"\n";
	}
	
	

}
