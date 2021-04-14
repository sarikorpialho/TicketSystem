package ticketSystem;
/**Represent a flight
 * 
 * @author korpi
 *
 */
public class Flight {
	private String target;
	private String date;
	private int numberOfSeats;
	private int flightnumber;		
	/**Creates a flight.
	 * 
	 * @param flightnumber
	 * @param date
	 * @param target
	 * @param numberOfSeats
	 */
	public Flight(int flightnumber,String date, String target, int numberOfSeats) {
		this.target = target;
		this.date = date;
		this.numberOfSeats = numberOfSeats;
		this.flightnumber = flightnumber;			
	}
	/** Create new flight.
	 * 
	 * @param flightnumber
	 * @param date
	 * @param target
	 */
	public Flight(int flightnumber,String date, String target) {
		this.target = target;
		this.date = date;
		this.flightnumber = flightnumber;			
	}
	/** Create new flight.
	 * 
	 */
	public Flight() {
	}
	/** Gets flight number.
	 * 
	 * @return Integer value of flight number.
	 */
	public int getFlightnumber() {
		return flightnumber;
	}
	/** Sets flight number.
	 * 
	 * @param flightnumber
	 */
	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}
	/** Gets target of the flight.
	 * 
	 * @return Integer value of flight number.
	 */
	public String getTarget() {
		return target;
	}
	/** Sets target of the flight.
	 * 
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/** Gets date of flight.
	 * 
	 * @return A String format of date.
	 */
	public String getDate() {
		return date;
	}
	/** Sets date of flight.
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/** Gets flight seats.
	 * 
	 * @return Integer value of seats.
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	/** Sets flight seats.
	 * 
	 * @param numberOfSeats
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}	
	@Override
	public String toString() {
		
		return "Flight number: " + flightnumber +", "+ "Flight date: " + date +
				", "+"Target: " + target;
	}

	

}
