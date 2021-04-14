package ticketSystem;

import java.util.ArrayList;
/**Represent a booking
 * 
 * @author korpi
 *
 */
public class Booking {
	private int bookingNumber;
	private Flight flight;
	private Customer customer;
	private Seat SeatClass;
	private ArrayList<Flight> flights;
	
	/**Create a booking
	 * 
	 * @param bookingNumber
	 * @param customer
	 * @param flight
	 * @param SeatClass
	 */
	public Booking(int bookingNumber,Customer customer, Flight flight, 
			Seat SeatClass) {
		this.bookingNumber = bookingNumber;
		this.flight = flight;
		this.customer = customer;
		this.SeatClass = SeatClass;	
		
	}
	/**Create ArrayList for flights.
	 * 
	 */
	public Booking() {
		this.flights = new ArrayList<>();
	}
	/**Add flight to ArrayList.
	 * 
	 * @param f
	 */
	public void addFlight(Flight f) {
		flights.add(f);
	}
	/**Remove flight from ArrayList flights.
	 * 
	 * @param f
	 */
	public void removeFlight(Flight f) {
		flights.remove(f);
	}
	/**Check flight number validity.
	 * 
	 * @param number
	 * @return true if number exists.
	 */
	public boolean validFlightNumber(int number){
		
		for(Flight f:flights) {
			if(number == f.getFlightnumber()) {
				return true;
			}
		}
		return false;	
	}
	
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	/** Print all flights.
	 * 
	 */
	public void printAllFlights() {	
		
		for(Flight f:flights) {
			System.out.println(f.toString());
		}
	}
	/** Create csv format
	 * 
	 * @return csv format of booking separated by commas.
	 */
	public String csvFile() {
		return ""+this.bookingNumber+","+flight.getFlightnumber()+","+flight.getDate()+","
				+flight.getTarget()+","+customer.getFirstname()+","+customer.getLastname()+
				","+SeatClass.getSeatNumber();
	}
	/** Gets booking number.
	 * 
	 * @return Integer value containing booking number.
	 */
	public int getBookingNumber() {
		return bookingNumber;
	}
	/** Sets booking number.
	 * 
	 * @param bookingNumber
	 */
	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	/** Gets seat class.
	 * 
	 * @return Seat format of seat class.
	 */
	public Seat getSeatClass() {
		return SeatClass;
	}
	/** Sets seat class.
	 * 
	 * @param seatClass
	 */
	public void setSeatClass(Seat seatClass) {
		SeatClass = seatClass;
	}
	/** Gets flight.
	 * 
	 * @return Flight format of flight.
	 */
	public Flight getFlight() {
		return flight;
	}
	/** Sets flight.
	 * 
	 * @param flight
	 */
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
