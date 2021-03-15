package ticketSystem;

public class SeatClass extends Seat{
	private SeatTypes seatTypes;
	
	public SeatClass(int seatNumber, SeatTypes seatTypes) {
		super(seatNumber);
		this.seatTypes = seatTypes;
		
	}

	public SeatTypes getSeatTypes() {
		return seatTypes;
	}

	public void setSeatTypes(SeatTypes seatTypes) {
		this.seatTypes = seatTypes;
	}

	@Override
	public String toString() {
		return "SeatNumber: " + super.getSeatNumber()+", "+ seatTypes;
	}
	
	
}
