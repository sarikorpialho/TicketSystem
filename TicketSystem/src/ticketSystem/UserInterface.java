package ticketSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	private Scanner s;
	//private ArrayList<Flight> flights;
	//private Booking booking;
	private ArrayList<Integer> freeSeats;
	private ArrayList<Integer> reservedSeats;
	
	
	
	public UserInterface(Scanner s) {
		this.s = s;
		this.freeSeats = new ArrayList<>();
		this.reservedSeats = new ArrayList<>();
		//this.flights = new ArrayList<>();
		
		
	}
	
	
	public void startBooking() {
		
		while(true) {
		
		
			System.out.println("Welcome to booking service of Flights.");
			System.out.println();
			System.out.println();
			System.out.println("Please use numbers of your keyboard.");
			System.out.println();
			System.out.println("1 - Make new reservation.");
			System.out.println("2 - Search your trip.");
			System.out.println("3 - Cancel your trip.");
			System.out.println("4 - Exit booking system.");
			System.out.println();
			
			
			
			String command = s.nextLine();
			
			if(command.equals("4")) {
				System.out.println();
				System.out.println("Thanks for using our booking system.");
				break;		
			}
			if(command.equals("1")) {
				newReservation();
			}
			
				
		}
			
	}
	
	/*public void readCommand() {
		
	}*/
	
	
	
	public void newReservation() {
		
		Booking newFlight = new Booking();
		Flight p = new Flight("1","5.5.2021","Pariisi", 40);
		newFlight.addFlight(p);
		
		
		Flight r = new Flight("2","9.5.2021","Rooma",30);
		newFlight.addFlight(r);
		
		Flight l = new Flight("3","15.5.2021", "Lontoo",20);
		newFlight.addFlight(l);
		
		System.out.println("Available flights: ");
		newFlight.printAllFlights();
		System.out.println();
		//System.out.print("Your flights date? : ");
		//String date = s.nextLine();
		System.out.print("Your flights number? : ");
		String number = s.nextLine();
		
		System.out.println("Lennon vapaat paikat: ");
		System.out.println();
		Flight a = new Flight();
		if (p.getFlightnumber().equals(number)) {
			a = new Flight(p.getFlightnumber(),p.getDate(),p.getTarget());
			System.out.println(addSeats(p.getNumberOfSeats()));
		}else if(r.getFlightnumber().equals(number)) {
			a = new Flight(r.getFlightnumber(),r.getDate(),r.getTarget());
			System.out.println(addSeats(r.getNumberOfSeats()));
		}else {
			a = new Flight(l.getFlightnumber(),l.getDate(),l.getTarget());
			System.out.println(addSeats(l.getNumberOfSeats()));
		}
		System.out.println();
		System.out.print("Minkä paikkanumeron haluaisit varata? ");
		int seatNumber = Integer.valueOf(s.nextLine());
		removeSeat(seatNumber);
		
		System.out.print("Firstname: ");
		String firstname = s.nextLine();
		System.out.print("Lastname: ");
		String lastname = s.nextLine();
		Customer customer = new Customer(firstname,lastname);
		Seat s = new SeatClass(seatNumber);
		
		
		
		Trip t = new Trip();
		Booking o = new Booking(a,customer,s);
		t.addTrip(o);
		System.out.println(t.toString());
		
		
		
	
	
	}
	public ArrayList<Integer> addSeats(int numberOfSeats) {
			
			for(int i = 1;i<numberOfSeats;i++) {
				freeSeats.add(i);
			}
			return freeSeats;
	
	}
	public void removeSeat(int number) {
		
		for(int i = 0;i<freeSeats.size();i++) {
			if(freeSeats.get(i) == number) {
				freeSeats.remove(i);
				//reservedSeats.add(n);
			}
		}
	}
}
