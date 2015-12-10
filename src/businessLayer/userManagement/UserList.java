package businessLayer.userManagement;

import java.util.ArrayList;
import java.util.Iterator;

public class UserList {
	private ArrayList<User> users = new ArrayList<>();

	public UserList() {
		users = getUserList();
		// getArrayListFromdb
	}

	public boolean checkPassword(int id, String password) {
		if (id == 0 | password == null)
			return false;
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			User element = itr.next();
			if (element.getId() == id && element.getPassword() == password)
				return true;
		}
		return false;
	}

	public void addUser(User newUser) {
		users.add(newUser);
	}
	
	private ArrayList<User> getUserList(){
		ArrayList<User> temp = new ArrayList<>();
		temp.add(new User("Gunjan", "Shakya", 1234, "Nepal"));
		temp.add(new User("Prabhat", "Poudel", 1234, "Nepal"));
		temp.add(new User("Hagos", "Haile", 1234, "Ethiyopia"));
		temp.add(new User("Ahmed", "Amin", 1234, "Eygpt"));
		
		//Need to access file connector or Db connection to access data from 
		
		return temp;
	}

}
