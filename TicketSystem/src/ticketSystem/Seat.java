package ticketSystem;

public class Seat {
	private int seatNumber;
	private int numberOfSeats;
	
	
	public Seat(int seatNumber) {
		
		this.seatNumber = seatNumber;
		
	}
	public Seat(int numberOfSeats, int seatNumber) {
		this.numberOfSeats = numberOfSeats;
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Seat [seatNumber=" + seatNumber + "]";
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	

}
