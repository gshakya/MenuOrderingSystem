package dataAccessLayer.dbInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public interface ConnectToDB {
	String host = "jdbc:mysql://localhost/menuordering";
	String username = "menuordering";
	String password = "mysql";

	public static Connection getConnection() {
		
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(host, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}
}
