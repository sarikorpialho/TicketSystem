package ticketSystem;

import java.io.IOException;
import java.util.Scanner;
/** Represents main class.
 * 
 * @author korpi
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner r = new Scanner(System.in);
		UserInterface i = new UserInterface(r);		
		
		i.startBooking();
	}

}
