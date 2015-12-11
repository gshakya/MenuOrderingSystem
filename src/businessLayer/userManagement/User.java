package businessLayer.userManagement;

public class User {
	@Override
	public String toString() {
		return "User [ id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + "]";
	}

	/**
	 * Class for the user
	 */
	private String firstName;
	private String password;
	private int id;
	private String lastName;

	public User() {

	}

	public User(int id, String password, String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.password = password;
		this.id = id;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String user) {
		this.firstName = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String address) {
		this.lastName = address;
	}

}
