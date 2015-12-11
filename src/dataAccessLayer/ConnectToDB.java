package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public interface ConnectToDB {
	String host = "jdbc:mysql://localhost/menuordering";
	String username = "menuordering";
	String password = "mysql";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jbdc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/menuordering", "menuordering", "mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}
}
