package ticketSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Testi {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> freeSeats = new ArrayList<>();
		// TODO Auto-generated method stub
		Scanner r = new Scanner(System.in);
		UserInterface i = new UserInterface(r);
		
		
		Flight b = new Flight(1,"25.5.2021","Uusi-Seelanti", 30);
		b.getNumberOfSeats();
		System.out.println(b);
		
		
		
		
		
		
		//System.out.println(d.equals(c));
	
		
		
		
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
