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
	private Animal animal;
	
	
	/**Create a new booking
	 * 
	 * @param bookingNumber Booking number 
	 * @param customer Customer
	 * @param flight Flight
	 * @param SeatClass SeatClass
	 */
	public Booking(int bookingNumber,Customer customer, Flight flight, 
			Seat SeatClass, Animal animal) {
		this.bookingNumber = bookingNumber;
		this.flight = flight;
		this.customer = customer;
		this.SeatClass = SeatClass;
		this.animal = animal;
	}
	/**Create ArrayList for flights.
	 * 
	 */
	public Booking() {
		this.flights = new ArrayList<>();
	}
	/**Add flight to ArrayList.
	 * 
	 * @param f Flight
	 */
	public void addFlight(Flight f) {
		flights.add(f);
	}
	/**Remove flight from ArrayList flights.
	 * 
	 * @param f Flight
	 */
	public void removeFlight(Flight f) {
		flights.remove(f);
	}
	/**Check flight number validity.
	 * 
	 * @param number Flight number
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
	/** Print all flights.
	 * 
	 */
	public void printAllFlights() {	
		
		for(Flight f:flights) {
			System.out.println();
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
	 * @param bookingNumber this bookingnumber
	 */
	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	/** Gets seat class.
	 * 
	 * @return Seat class FirstClass or EconomyClass.
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
	 * @return This flight.
	 */
	public Flight getFlight() {
		return flight;
	}
	/** Sets flight.
	 * 
	 * @param flight Flight
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	@Override
	public String toString() {
		return "Booking number: "+this.bookingNumber+" "+"Customer:" + customer + 
				", "+flight +  ", "+"\n"
				+ SeatClass+"\n";
	}
	
	

}
