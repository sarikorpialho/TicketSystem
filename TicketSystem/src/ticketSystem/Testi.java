package ticketSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Testi {

	public static void main(String[] args) {
		ArrayList<Integer> freeSeats = new ArrayList<>();
		// TODO Auto-generated method stub
		Scanner r = new Scanner(System.in);
		UserInterface i = new UserInterface(r);
		
		
		Flight b = new Flight("1","25.5.2021","Uusi-Seelanti", 30);
		b.getNumberOfSeats();
		
		
		
		
		
		Customer sari = new Customer("Sari","Korpialho");
		Seat s = new SeatClass(17);
		Booking d = new Booking(b,sari,s);
		//System.out.println(a.toString());
		
		
		
		//d.removeSeat(15);
		
		
		//System.out.println(d.equals(c));
	
		
		
		//System.out.println(c.toString());
		Trip Korpialho = new Trip();
		//Korpialho.addTrip(c);
		Korpialho.addTrip(d);
		//Korpialho.removeTrip(c);
		System.out.println(Korpialho.getBookings());
		
		
		i.startBooking();
		
	}
/*
 * 
 * public void removeSeat(int number) {
		
		for(Integer n:freeSeats) {
			if(n == number) {
				freeSeats.remove(n);
				reservedSeats.add(n);
			}
		}
	}
	public ArrayList<Integer> getFreeSeats() {
		freeSeats.removeAll(reservedSeats);
		return freeSeats;
	}

	public void setFreeSeats(ArrayList<Integer> freeSeats) {
		this.freeSeats = freeSeats;
	}*/
	/*public void addSeats(int numberOfSeats) {
		
		for(int i = 1;i<numberOfSeats;i++) {
			freeSeats.add(i);
		}
	}*/

}
