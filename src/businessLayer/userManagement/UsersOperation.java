package businessLayer.userManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import dataAccessLayer.GetUserFromDB;
import dataAccessLayer.UserFileReader;

public class UsersOperation{
	/**
	 * Operation that can be done on Users are added in the class
	 */
	private static ArrayList<User> users = new ArrayList<>();

	public String toString(){
		String result = null;
		Iterator<User> usrItr= users.iterator();
		while (usrItr.hasNext()) {
			result=result+usrItr.next();
		}
		return result;
 
	}
	public static boolean checkPassword(int id, String password) {
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
		
		GetUserFromDB users = new GetUserFromDB();
		return (users.runSelectQuery("select"));
		
	}

}
