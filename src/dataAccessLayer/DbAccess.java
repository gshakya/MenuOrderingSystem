package dataAccessLayer;

public class DbAccess {

	public static void main(String[] args) {
		GetUserFromDB users = new GetUserFromDB();
		System.out.println(users.runSelectQuery("select * from users"));

	}

}
