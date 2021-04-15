package ticketSystem;
/**Represents a seat
 * 
 * @author korpi
 *
 */
public class Seat {
	private int seatNumber;
	/**Create Seat with seat number.
	 * 	
	 * @param seatNumber This is seat number
	 */
	public Seat(int seatNumber) {
		
		this.seatNumber = seatNumber;		
	}
	/** Gets seat number.
	 *  
	 * @return this seat number.
	 */
	public int getSeatNumber() {
		return seatNumber;
	}
	/** Set seat number.
	 * 
	 * @param seatNumber Sets seat number.
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}	
}
