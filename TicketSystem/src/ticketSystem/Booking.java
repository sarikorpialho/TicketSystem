package ticketSystem;

import java.util.ArrayList;

public class Booking {
	private Flight flight;
	private Customer customer;
	private Seat SeatClass;
	private ArrayList<Flight> flights;
	private ArrayList<Integer> freeSeats;
	private ArrayList<Integer> reservedSeats;
	
	
	
	//Create new booking
	public Booking(Flight flight, Customer customer, Seat SeatClass) {
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
	public void addSeats() {
		int numberOfSeats = flight.getNumberOfSeats();
		
		for(int i = 1;i<numberOfSeats;i++) {
			freeSeats.add(i);
		}
	}
	public void removeSeat(int number) {
		
		for(Integer n:freeSeats) {
			if(n == number) {
				freeSeats.remove(n);
				reservedSeats.add(n);
			}
		}
	}
	public ArrayList<Integer> getFreeSeats() {
		freeSeats.removeAll(reservedSeats);
		return freeSeats;
	}
	
	public void setFreeSeats(ArrayList<Integer> freeSeats) {
		this.freeSeats = freeSeats;
}
	
	

	@Override
	public String toString() {
		return "Customer:" + customer + ", "+flight +  ", "+"\n"
				+ SeatClass+"\n";
	}
	
	

}
