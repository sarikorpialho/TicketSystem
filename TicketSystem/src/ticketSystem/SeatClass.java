package ticketSystem;

public class SeatClass extends Seat{
	
	//private Flight flight;
	
	
	public SeatClass(int seatNumber) {
		super(seatNumber);
		
	}

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
