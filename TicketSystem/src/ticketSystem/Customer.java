package ticketSystem;

public class Customer {
	private String firstname;
	private String lastname;
	
	public Customer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return " " + firstname + " " + lastname;
	}
	
	
	
}
