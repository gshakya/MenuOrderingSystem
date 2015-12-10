package businessLayer.userManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import dataAccessLayer.UserFileReader;

public class UsersOperation{
	private ArrayList<User> users = new ArrayList<>();

	public UsersOperation() throws IOException {
		users = getUserList();
	
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
	
	private ArrayList<User> getUserList() throws IOException{
		return (UserFileReader.getUsers());
		
	}

}
