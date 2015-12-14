package businessLayer.userManagement;

import java.util.ArrayList;
import java.util.Iterator;

import dataAccessLayer.GetUserFromDB;
import dataAccessLayer.SendUserToDB;
import dataAccessLayer.dbInterface.SendToDB;

public class UsersOperation {
	/**
	 * Operation that can be done on Users are added in the class
	 */
	private static ArrayList<User> users = new ArrayList<>();
	private static User currentUser = new User();

	public UsersOperation() {
		getUserList();
	}

	public String toString() {
		String result = null;
		Iterator<User> usrItr = users.iterator();
		while (usrItr.hasNext()) {
			result = result + usrItr.next();
		}
		return result;

	}

	public static int insertUserToDB(User u) {
		String fName = u.getFirstName();
		String lName = u.getLastName();
		String pass = u.getPassword();
		String uName =u.getUserName();
		String query = "INSERT INTO `users` (`id`, `First_Name`, `Last_Name`, `user_name`,`Password`) VALUES (NULL, \'" + fName
				+ "\', \'" + lName + "\', \'"+uName +"\', \'" + pass + "\')";
		SendUserToDB sendUsr = new SendUserToDB();
		users.add(u);
		return sendUsr.runInsertQuery(query);
	}

	public static boolean isValidUser(String uName){
		GetUserFromDB usersDBObject = new GetUserFromDB();
		ArrayList<User> res = usersDBObject
				.runSelectQuery("select * from users where user_name ='" + uName + "'");
		
		if (res.size() == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean checkPassword(String uName, String password) {
		
		// Iterator<User> itr = users.iterator();
		// while (itr.hasNext()) {
		// User element = itr.next();
		// if (element.getId()==id && element.getPassword().equals(password))
		// return true;
		// }
		GetUserFromDB usersDBObject = new GetUserFromDB();
		ArrayList<User> res = usersDBObject
				.runSelectQuery("select * from users where user_name ='" + uName + "' and password =\"" + password + "\"");
		
		if (res.size() == 0) {
			return false;
		}
		currentUser = res.get(0);
		return true;
	}

	public void addUser(User newUser) {
		users.add(newUser);
	}

	private void getUserList() {
		GetUserFromDB usersDBObject = new GetUserFromDB();
		users = usersDBObject.runSelectQuery("select * from users");

	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}
}
