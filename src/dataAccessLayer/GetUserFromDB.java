package dataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import businessLayer.userManagement.User;
import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.ReceiveFromDB;

public class GetUserFromDB implements ReceiveFromDB {

	@Override
	public ArrayList<User> runSelectQuery(String query) {
		Connection connect = ConnectToDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> users = new ArrayList<>();
		try {
			statement = (Statement) connect.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				User tmpUser = new User();
				tmpUser.setId(resultSet.getInt("id"));
				tmpUser.setFirstName(resultSet.getString("first_name"));
				tmpUser.setLastName(resultSet.getString("last_name"));
				tmpUser.setPassword(resultSet.getString("password"));
				System.out.println(Integer.parseInt(resultSet.getString("is_admin")));
				tmpUser.setAdmin(Integer.parseInt(resultSet.getString("is_admin")) > 0 ? true : false);
				users.add(tmpUser);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(connect != null) try { connect.close(); } catch (SQLException e) { e.printStackTrace(); }
		}

		return users;
	}

}
