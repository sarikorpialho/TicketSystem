package ticketSystem;

public class Testi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flight a = new Flight("Kaukasus", "23.3.2021");
		Flight b = new Flight("Uusi-Seelanti","25.5.2021");
		a.addFlight(a);
		Customer sari = new Customer("Sari","Korpialho");
		Seat s = new SeatClass(2,SeatTypes.FIRSTCLASS);
		//System.out.println(a.toString());
		
		Booking c= new Booking(a,sari,s);
		Booking d = new Booking(b,sari,s);
		System.out.println(d.equals(c));
	
		
		
		//System.out.println(c.toString());
		Trip Korpialho = new Trip();
		Korpialho.addTrip(c);
		Korpialho.addTrip(d);
		Korpialho.removeTrip(c);
		System.out.println(Korpialho.getBookings());
		
	}

}
