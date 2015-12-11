package dataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import businessLayer.userManagement.User;

public class GetUserFromDB implements ReceiveFromDB {

	@Override
	public ArrayList<User> runSelectQuery(String query) {
		Connection connect = ConnectToDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = (Statement) connect.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Result set get the result of the SQL query
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<User> users = new ArrayList<>();
		try {
			while (resultSet.next()) {
				User tmpUser = new User();
				tmpUser.setId(resultSet.getInt("id"));
				tmpUser.setFirstName(resultSet.getString("first_name"));
				tmpUser.setLastName(resultSet.getString("last_name"));
				tmpUser.setPassword(resultSet.getString("password"));

				users.add(tmpUser);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

}
