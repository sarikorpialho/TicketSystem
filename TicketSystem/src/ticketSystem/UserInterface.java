package ticketSystem;

import java.util.Scanner;

public class UserInterface {
	private Scanner reader;
	
	public UserInterface(Scanner reader) {
		
	}
	
	
	public void startBooking() {
		
		
		System.out.println("Welcome to booking service of Flights.");
		System.out.println();
		System.out.println();
		System.out.println("Please use numbers of your keyboard.");
		System.out.println();
		System.out.println("1 - Make new reservation.");
		System.out.println("2 - Search your trip.");
		System.out.println("3 - Cancel your trip.");
	}

}
