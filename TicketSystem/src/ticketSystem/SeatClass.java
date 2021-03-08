package ticketSystem;

public class SeatClass extends Seat{
	private SeatTypes seatTypes;
	
	public SeatClass(int seatNumber, SeatTypes seatTypes) {
		super(seatNumber);
		this.seatTypes = seatTypes;
		
	}

	public SeatTypes getSeatTypes(int seatNumber) {
		if(seatNumber < 19) {
			return SeatTypes.FIRSCLASS;
		}
		return SeatTypes.ECONOMYCLASS;
	}
	
}
