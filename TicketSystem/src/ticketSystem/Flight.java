package ticketSystem;

import java.util.ArrayList;

public class Flight {
	private String target;
	private String date;
	//private ArrayList<Seat> seats;
	private ArrayList<Flight>flights;
	
	//Create new flight
	public Flight(String target, String date) {
		this.target = target;
		this.date = date;
		//seats = new ArrayList<>();
		flights = new ArrayList<>();
	}
	//Add new flight to list
	public void addFlight(Flight f) {
		flights.add(f);
	}
	//remove flight from list
	public void removeFlight(Flight f) {
		flights.remove(f);
	}
	//get all available flight
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

	@Override
	public String toString() {
		
		return "Flight: " + target + ", date: " + date;
	}

	

}
