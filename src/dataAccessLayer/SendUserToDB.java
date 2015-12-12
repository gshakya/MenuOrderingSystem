package dataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.SendToDB;;

public class SendUserToDB implements SendToDB {

	@Override
	public int runInsertQuery(String query) {
		// TODO Auto-generated method stub
		int querySucess = 0;
		Connection connect = ConnectToDB.getConnection();
		System.out.println(query);
		Statement statement = null;
		try {
			statement = (Statement) connect.createStatement();
			querySucess = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return querySucess;
	}

}
