package ticketSystem;
/**Represents a customer.
 * 
 * @author korpi
 *
 */

public class Customer {
	private String firstname;
	private String lastname;
	/**Creates a customer.
	 * 
	 * @param firstname
	 * @param lastname
	 */
	public Customer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "" + firstname + " " + lastname;
	}
	
	
	
}
