package businessLayer.userManagement;

public class User {
	private String user;
	private String password;
	private int id;
	private String address;
	

	
	public User(String user, String password, int id, String address) {
		super();
		this.user = user;
		this.password = password;
		this.id = id;
		this.address = address;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
