package menu;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

//import dataAccessLayer.SendToDB;
import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.SendToDB;;

public class Orders implements SendToDB {

	public  void placeorder(String selected, Component contentPane) {
		String query = "";
		int dishID = 0;
		if (selected == "") {
			JOptionPane.showMessageDialog(contentPane, "No Orders");
		} 
		/*else if (orderType == 'U') {
			JOptionPane.showMessageDialog(contentPane, "Please Select the Time.");
		}
		*/ else {
			char chrSelectedOrders[] = selected.toCharArray();
			for (int i = 0; i < chrSelectedOrders.length; i++) {
				if (chrSelectedOrders[i] != ',')
					query += "(1 , " + chrSelectedOrders[i] + " ), \n";
			}
			query = query.substring(0, query.length() - 3);
			// query+=") a";
			query = "INSERT INTO ORDERS (USER_ID,DISH_ID) VALUES\n" + query;
//			System.out.println(query);
			// SendToDB insertOrders = new SendToDB();
			runInsertQuery(query);
		}
	}

	public static void publishOrders(Component contentPane, String dishName) {
		JOptionPane.showMessageDialog(contentPane, dishName);
	}

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
