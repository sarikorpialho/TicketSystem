package ticketSystem;

import java.util.ArrayList;
import java.util.Date;

public class Flight {
	private String target;
	private Date date;
	private ArrayList<Seat> seats;
	
	public Flight(String target, Date date) {
		this.target = target;
		this.date = date;
		seats = new ArrayList<>();
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	

}
