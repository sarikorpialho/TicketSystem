package ticketSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/** Represents user interface
 * 
 * @author korpi
 *
 */
public class UserInterface {
	private Scanner s;
	private ArrayList<Booking> bookings;
	private ArrayList<Integer> freeSeats;
	private ArrayList<Integer> reservedSeats;
	private ArrayList<Integer> bookingNumber;
	/** Create new user interface.
	 * 
	 * @param s
	 */
	public UserInterface(Scanner s) {
		this.s = s;
		this.freeSeats = new ArrayList<>();
		this.reservedSeats = new ArrayList<>();
		this.bookings = new ArrayList<>();
		this.bookingNumber = new ArrayList<>();
	}
	/** Start a new booking.
	 * 
	 * @throws IOException
	 */
	public void startBooking() throws IOException {
		
		System.out.println("Welcome to booking service of Flights.");
		
		while(true) {
			
			bookings.clear();
			readAllLines();
			
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
			int command = 0;
			try {
			command = Integer.valueOf(s.nextLine());
			if (command >= 5) {
				System.out.println("Invalid number. Please try again.");
			}
			}catch (Exception e) {
				System.out.println("Invalid number.");
			}
			
			if(command == 4) {
				System.out.println();
				System.out.println("Thanks for using our booking system.");
				clearTextFile();
				break;		
			}
			if(command == 3) {
				cancelReservation();
			}
			if(command == 2) {
				findReservation();
			}
			
			if(command == 1) {
				newReservation();
			}	
		}
			
	}
	/** Make new reservation.
	 * 
	 */
	public void newReservation()  {
		
		//Create new flights 
		Booking newFlight = new Booking();
		Flight p = new Flight(1,"5.6.2021","Paris", 40);
		newFlight.addFlight(p);
		
		Flight r = new Flight(2,"9.6.2021","Rome",30);
		newFlight.addFlight(r);
		
		Flight l = new Flight(3,"15.6.2021", "London",20);
		newFlight.addFlight(l);
		
		//Print all available flights
		System.out.println("Available flights: ");
		newFlight.printAllFlights();
		System.out.println();
		
		
		int number = 0;
		//Check flight number validity
		while(newFlight.validFlightNumber(number)==false) {
			try {
				number = Integer.valueOf(s.nextLine());
			}catch (Exception e) {
				System.out.println("Invalid number.");
			}
		}		
		//Get free seats of selected flight
		System.out.println("Free seats: ");
		System.out.println();
		
		//Create new selected flight.
		Flight a = new Flight();
		if (p.getFlightnumber() == number) {
			addSeats(p.getNumberOfSeats());
			System.out.println(freeSeats(p));
			a = new Flight(p.getFlightnumber(),p.getDate(),p.getTarget());
		}else if(r.getFlightnumber() == number) {
			a = new Flight(r.getFlightnumber(),r.getDate(),r.getTarget());
			addSeats(r.getNumberOfSeats());
			System.out.println(freeSeats(r));
		}else {
			a = new Flight(l.getFlightnumber(),l.getDate(),l.getTarget());
			System.out.println(a);
			addSeats(l.getNumberOfSeats());
			System.out.println(freeSeats(l));			
		}
		// Check if flight is full
		if (fullFlight()== true) {
			System.out.println("Flight is full.");
			return;
		}
		int seatNumber = 0;
		//Check the seat number
		while(validSeat(seatNumber)==false) {
			
			try {
				seatNumber = Integer.valueOf(s.nextLine());
				}catch (Exception e) {
					System.out.println("Invalid number.");
				}
		}
		
		System.out.println("Firstname: ");
		String firstname = s.nextLine();
		System.out.println("Lastname: ");
		String lastname = s.nextLine();
		//Create new customer
		Customer customer = new Customer(firstname,lastname);
		//Create new seat
		Seat seat = new SeatClass(seatNumber);				
		//Create new Booking
		Booking o = new Booking(createBookingNumber(),customer,a,seat);
		try {
			// 
			write(o.csvFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Animals on board
		System.out.println("Do you have animals? Please select Y/N");
		String letter = s.nextLine();
		if(letter.toUpperCase().equals("Y")) {
			System.out.println("Animals name?");
			String aName = s.nextLine();
			System.out.println("Age?");
			int aAge = Integer.valueOf(s.nextLine());
			System.out.println("Animals breed?");
			String breed = s.nextLine();
			Animal x = new Animal(aName,aAge,breed);
		}
		
		
		
		//Print the booked trip.
		System.out.println();
		System.out.println("Your booking: ");
		System.out.println(o.toString());
	
	}
	/**Validate chosen seat number
	 * 
	 * @param number seat number
	 * @return true if seat number exist else false
	 */
	public boolean validSeat(int number) {
		
		for(int i = 0;i<freeSeats.size();i++) {
			if(freeSeats.get(i)==number){
				return true;
			}
		}
		System.out.println();
		System.out.print("Please, choose your seat number: ");
		System.out.println("Numbers 1-18 FirstClass and 19- EconomyClass. ");
		return false;
	}
	/**Find your reservation.
	 * 
	 */
	public void findReservation() {	
		
		int number = 0;
		while(findBooking(number)==false) {
			try {
				number = Integer.valueOf(s.nextLine());
				}catch (Exception e) {
					System.out.println("Invalid number.");
				}			
			}
		
	}	
	/**Cancel reservation.
	 * 
	 * @throws IOException If Exception occurs.
	 */
	public void cancelReservation() throws IOException {
			
		if(bookings.isEmpty()) {
			System.out.println("No bookings available");
			return;
		}
		 
		int number = 0;
		//find selected booking
		while(findBooking(number)==false) {
		try {
			number = Integer.valueOf(s.nextLine());
			}catch (Exception e) {
				System.out.println("Invalid number.");
			}
		
		}
		//Cancel the selected booking
		System.out.println("Do you want to cancel this booking? Press Y = Yes N = No");
		String a = s.nextLine();
		//Check if line is empty
		if(a.trim().equals("")) {
			System.out.println("Your booking has not been canceled.");
		}else if(a.toUpperCase().equals("N")){
			System.out.println("Your booking has not been canceled.");
		}else if(a.toUpperCase().equals("Y")) {
			if(!bookings.isEmpty()) {
				//Can't remove from the list without creating an object. Why?
				Booking r = null;
				for(Booking b:bookings) {
					if(b.getBookingNumber()==number) {
						r=b;
					}					
				}
				bookings.remove(r);
				//Update bookings.txt file
				clearTextFile();
				for(Booking j:bookings) {
					write(j.csvFile());
				}
				readAllLines();
				
				System.out.println("The booking has been canceled.");				
			}else {
				System.out.println("No bookings available.");				
			}						
		}else {
			System.out.println("Your booking has not been canceled.");
		}
	}
	/** Create booking numbers.
	 * 
	 * @return Always return a booking number that does not exist.
	 */
	public int createBookingNumber() {
		int number = 0;
		
		if(!bookings.isEmpty()) {
			for (Booking b:bookings) {
				bookingNumber.add(b.getBookingNumber());
			}
			Collections.sort(bookingNumber);
			number = bookingNumber.get(bookingNumber.size()-1)+1;
		}else {
			number = 1000;
		}	
		return number;
	}
	/** Add seats to the flight.
	 * 
	 * @param numberOfSeats All seats of the flight.
	 */
	public void addSeats(int numberOfSeats) {
		
		// Clear list
		freeSeats.clear();
		for(int i = 1;i<numberOfSeats+1;i++) {
			freeSeats.add(i);
		}	
	}
	
	/** Free seats on the flight
	 * 
	 * @param f Flight
	 * @return A list of free seats.
	 */
	public ArrayList<Integer> freeSeats(Flight f){
		
		// Clear list
		reservedSeats.clear();
		for (Booking b: bookings) {
			if(f.getFlightnumber()==b.getFlight().getFlightnumber()){
				reservedSeats.add(b.getSeatClass().getSeatNumber());				
			}
		}
		freeSeats.removeAll(reservedSeats);
		return freeSeats;
	}
	/**Find booking
	 * 
	 * @param number booking number
	 * @return 
	 */
	public boolean findBooking(int number) {
		
		System.out.println();
		//Check if list is empty
		if(bookings.isEmpty()) {
			System.out.println("There are no bookings available.");
			return true;
		}else {	
			for(Booking b:bookings) {
				if(b.getBookingNumber()==number) {
					System.out.println("Your booking: ");
					System.out.println(b.toString());
					return true;
				}
			}
		}
		System.out.print("Please enter booking number: ");
		return false;
	}
	
	/** Check if flight has no seats.
	 * 
	 * @return True if flight is full else false.
	 */
	public boolean fullFlight() {
		if(freeSeats.isEmpty()) {
			return true;
		}
		return false;
	}
	/** Write text to .txt file.
	 * 	
	 * @param booking String format of booking.
	 * @throws IOException If Exception occurs.
	 */
	public void write(String booking)throws IOException{
		
		FileWriter fw = new FileWriter("saveBooking/bookings.txt",true);
		
		fw.write(booking+"\n");
		fw.flush();
		fw.close();
	}
	/** Clear .txt file.
	 * 
	 * @throws IOException If Exception occurs.
	 */
	public void clearTextFile() throws IOException {
		
		FileWriter fw = new FileWriter("saveBooking/bookings.txt");
		
		fw.flush();
		fw.close();
	}
	/** Read all lines from text file.
	 * 
	 */
	public void readAllLines() {
		
		ArrayList<String> lines = new ArrayList<>();
		
		if("saveBooking/bookings.txt".length()==0) {
			System.out.println("Tyhjä");
		}
		
		try(Scanner reader = new Scanner(new File("saveBooking/bookings.txt"))){
			
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				lines.add(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		addBookingsToList(lines);
		
		}
	/** Create Booking object and add to bookings list.
	 * 
	 * @param lines A list of all bookings read from the text file.
	 */
	public void addBookingsToList(ArrayList<String> lines) {
		
		if (lines.isEmpty()||lines==null) {
			return;
		}else {
			for(String l:lines) {
				String[] pieces = l.split(",");
				int bookingNumber = Integer.valueOf(pieces[0]);
				int flightNumber = Integer.valueOf(pieces[1]);
				String date = pieces[2];
				String target = pieces[3];
				String firstname = pieces[4];
				String lastname = pieces[5];
				int seatnumber = Integer.valueOf(pieces[6]);
				//Create new customer
				Customer c = new Customer(firstname,lastname);
				//Create new Flight
				Flight f = new Flight(flightNumber,date,target);
				//Create new Seat
				Seat s = new SeatClass(seatnumber);
				//Create new Booking
				Booking b = new Booking(bookingNumber,c,f,s);
				bookings.add(b);
			}
		}
	}
	public void validCommand(){
		/*tee yleinen metodi, joka tarkistaa, onko sy�te validi*/
	}
	
}

