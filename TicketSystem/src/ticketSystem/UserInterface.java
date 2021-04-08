package ticketSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
	private Scanner s;
	private ArrayList<Booking> bookings;
	private ArrayList<Integer> freeSeats;
	private ArrayList<Integer> reservedSeats;
	
	
	
	public UserInterface(Scanner s) {
		this.s = s;
		this.freeSeats = new ArrayList<>();
		this.reservedSeats = new ArrayList<>();
		this.bookings = new ArrayList<>();
		
	}
	
	
	public void startBooking() throws IOException {
		
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
			
			//Check if command is valid
			validCommand();
				
			int command = Integer.valueOf(s.nextLine());
			
			
			if (command > 4) {
				System.out.println("Invalid number. Please try again.");
				System.out.println();
			}
			
			if(command == 4) {
				System.out.println();
				System.out.println("Thanks for using our booking system.");
				break;		
			}
			if(command == 3) {
				cancelReservation();
			}
			if(command == 2) {
				readAllLines();
			}
			
			if(command == 1) {
				newReservation();
			}		
		}
			
	}
	
	public void newReservation()  {
		
		//Create new flights 
		Booking newFlight = new Booking();
		Flight p = new Flight(1,"5.5.2021","Pariisi", 40);
		newFlight.addFlight(p);
		
		Flight r = new Flight(2,"9.5.2021","Rooma",30);
		newFlight.addFlight(r);
		
		Flight l = new Flight(3,"15.5.2021", "Lontoo",20);
		newFlight.addFlight(l);
		
		//Print all available flights
		System.out.println("Available flights: ");
		newFlight.printAllFlights();
		System.out.println();
		//System.out.print("Your flights date? : ");
		//String date = s.nextLine();
		
		int number = 0;
		//check flight number validity
		while(newFlight.validFlightNumber(number)==false) {
		System.out.print("Your flight number? : ");
		validCommand();
		number = Integer.valueOf(s.nextLine());
		
			System.out.println("Invalid number. Please try again.");
			System.out.println();
		
		}
		
		//get free seats of chosen flight
		System.out.println("Free seats: ");
		System.out.println();
		Flight a = new Flight();
		if (p.getFlightnumber() == number) {
			a = new Flight(p.getFlightnumber(),p.getDate(),p.getTarget());
			System.out.println(addSeats(p.getNumberOfSeats()));
		}else if(r.getFlightnumber() == number) {
			a = new Flight(r.getFlightnumber(),r.getDate(),r.getTarget());
			System.out.println(addSeats(r.getNumberOfSeats()));
		}else {
			a = new Flight(l.getFlightnumber(),l.getDate(),l.getTarget());
			System.out.println(addSeats(l.getNumberOfSeats()));
		}
		
		System.out.println();
		System.out.print("Please, choose your seat number: ");
		validCommand();
		System.out.println();
		int seatNumber = Integer.valueOf(s.nextLine());
		removeSeat(seatNumber);
		
		System.out.print("Firstname: ");
		String firstname = s.nextLine();
		System.out.print("Lastname: ");
		String lastname = s.nextLine();
		Customer customer = new Customer(firstname,lastname);
		Seat s = new SeatClass(seatNumber);
		
		
		//Create new Trip
		Booking o = new Booking(1002,customer,a,s);
		//Trip t = new Trip(a,customer,s);
		try {
			write(o.csvFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//t.addTrip(o);
		
		System.out.println();
		System.out.println(o.toString());
	
	}
	//Add seats to flight
	public ArrayList<Integer> addSeats(int numberOfSeats) {
			
			for(int i = 1;i<numberOfSeats+1;i++) {
				freeSeats.add(i);
			}
			return freeSeats;
	
	}
	//remove seat from list
	public void removeSeat(int number) {
		
		for(int i = 0;i<freeSeats.size();i++) {
			if(freeSeats.get(i) == number) {
				freeSeats.remove(i);
				reservedSeats.add(i);
			}
		}
	}
	public void cancelReservation() throws IOException {
		
		clearTextFile();
		
	}
	public boolean fullFlight(Flight F) {
		if(freeSeats.isEmpty()) {
			return true;
		}
		return false;
	}
	//check if command is valid
	public void validCommand() {
		
		while (!s.hasNextInt()) {
			s.nextLine();
			System.out.println("Invalid number. Please try again.");
			System.out.println();
		}
	}
	
	public void write(String trip)throws IOException{
		//File f = new File("saveBooking/bookings.txt");
		
		FileWriter fw = new FileWriter("saveBooking/bookings.txt",true);
		
		fw.write(trip+"\n");
		fw.flush();
		fw.close();
	}
	public void clearTextFile() throws IOException {
		
		FileWriter fw = new FileWriter("saveBooking/bookings.txt");
		
		fw.write("");
		fw.flush();
		fw.close();
	}
	public void readAllLines() {
		
		//read all lines in file
		ArrayList<String> lines = new ArrayList<>();
		
		try(Scanner reader = new Scanner(new File("saveBooking/bookings.txt"))){
			
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				lines.add(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//create Booking object and add to list
		for(String l:lines) {
			String[] pieces = l.split(",");
			int bookingNumber = Integer.valueOf(pieces[0]);
			int flightNumber = Integer.valueOf(pieces[1]);
			String date = pieces[2];
			String target = pieces[3];
			String firstname = pieces[4];
			String lastname = pieces[5];
			int seatnumber = Integer.valueOf(pieces[6]);
			Customer c = new Customer(firstname,lastname);
			Flight f = new Flight(flightNumber,date,target);
			Seat s = new SeatClass(seatnumber);
			
			Booking b = new Booking(bookingNumber,c,f,s);
			bookings.add(b);
		}
		System.out.println(bookings);
	}
	
	
	public ArrayList<String> commaSeparateList(String s){
		String[] pieces = s.split(",");
		ArrayList<String> words = new ArrayList<>();
		
		for(String w:pieces) {
			words.add(w);
		}
		System.out.println(words);
		return words;
	}
}

