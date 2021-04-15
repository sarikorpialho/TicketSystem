package ticketSystem;
/** Represents seat class
 * 
 * @author korpi
 *
 */
public class SeatClass extends Seat{
	/**Create seat class.
	 * 
	 * @param seatNumber
	 */	
	public SeatClass(int seatNumber) {
		super(seatNumber);
		
	}
	/** Gets seat type.
	 * 
	 * @param seatnumber
	 * @return SeatTypes FirstClass or EconomyClass based seat number.
	 */
	public SeatTypes getSeatTypes(int seatnumber) {
		
		if (seatnumber <= 18) {
			return SeatTypes.FIRSTCLASS;
		}
		return SeatTypes.ECONOMYCLASS;
	}	
	@Override
	public String toString() {
		return "SeatNumber: " + super.getSeatNumber()+", "+ getSeatTypes(super.getSeatNumber());
	}
	
	
}
