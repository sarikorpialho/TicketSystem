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
	 * @param seatNumber
	 */
	public Seat(int seatNumber) {
		
		this.seatNumber = seatNumber;		
	}
	/** Gets seat number.
	 *  
	 * @return Integer value of seat number.
	 */
	public int getSeatNumber() {
		return seatNumber;
	}
	/** Set seat number.
	 * 
	 * @param seatNumber
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}	
}
