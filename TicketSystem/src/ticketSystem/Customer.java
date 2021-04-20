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
	 * @param firstname Customers firstname.
	 * @param lastname Customers lastname.
	 */
	public Customer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/** Gets Customers fistname.
	 * 
	 * @return This firstname.
	 */
	public String getFirstname() {
		return firstname;
	}
	/** Sets Customers firstname.
	 * 
	 * @param firstname Firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/** Gets Customers lastname.
	 * 
	 * @return This Lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/** Sets Customers lastname.
	 * 
	 * @param lastname Lastname.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "" + firstname + " " + lastname;
	}
	
	
	
}
