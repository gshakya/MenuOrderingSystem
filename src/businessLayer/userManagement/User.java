package businessLayer.userManagement;

public class User {
	@Override
	public String toString() {
		return "User [ id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", Admin = " + isAdmin +"]";
	}

	/**
	 * Class for the user
	 */
	private int id;
	private String firstName;	
	private String lastName;
	private String password;
	private boolean isAdmin;

	public User() {

	}

	public User(int id, String firstName, String lastName, String password , boolean isAdmin) {
		super();
		this.firstName = firstName;
		this.password = password;
		this.id = id;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
}
