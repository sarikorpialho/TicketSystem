package ticketSystem;

import java.util.ArrayList;

public class Trip {
	
	private Customer customer;
	private Seat SeatClass;
	private ArrayList<Booking> bookings;
	private ArrayList<Booking> removed;
	
	public Trip() {
		//this.customer = customer;
		//this.SeatClass = SeatClass;
		this.bookings = new ArrayList<>();
		this.removed = new ArrayList<>();
	}
	//add new booking to list
	public void addTrip(Booking booking){
		bookings.add(booking);
	}
	//remove booking from list
	public void removeTrip(Booking booking) {
		
		if(bookings.isEmpty()) {
			System.out.println("No bookings.");
		}
		else {
			for(Booking b : bookings) {
				if(b.equals(booking)) {
					//siirret‰‰n varaus poistettujen listalle
					removed.add(b);
				}
			}
			//poistetaan varaus
			bookings.removeAll(removed);
		}
	}
	//
	public ArrayList<Booking> getBookings() {
		if(bookings.isEmpty()) {
			System.out.println("No bookings.");
		}
		return bookings;
	}
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Trip " + bookings;
	}
	
	
}
