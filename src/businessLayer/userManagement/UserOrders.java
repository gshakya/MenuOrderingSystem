package businessLayer.userManagement;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

//import dataAccessLayer.SendToDB;
import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.SendToDB;;

public class UserOrders implements SendToDB {
	private User currUser;
	private ArrayList<Dish> currUserDishes;

	public UserOrders() {
		currUser = (new UsersOperation()).getCurrentUser();
	}

	public void placeorder(String selected, Component contentPane) {
		String query = "";
		int dishID = 0;
		if (selected == "") {
			JOptionPane.showMessageDialog(contentPane, "No Orders");
		}
		/*
		 * else if (orderType == 'U') {
		 * JOptionPane.showMessageDialog(contentPane, "Please Select the Time."
		 * ); }
		 */ else {
			char chrSelectedOrders[] = selected.toCharArray();
			for (int i = 0; i < chrSelectedOrders.length; i++) {

				if (chrSelectedOrders[i] != ',')
					query += "(" + currUser.getId() + "," + chrSelectedOrders[i] + " ), \n";
			}
			query = query.substring(0, query.length() - 3);
			// query+=") a";
			query = "INSERT INTO ORDERS (USER_ID,DISH_ID) VALUES\n" + query;
			// System.out.println(query);
			// SendToDB insertOrders = new SendToDB();
			runInsertQuery(query);
		}
	}

	public static void publishOrders(Component contentPane, String dishName) {
		JOptionPane.showMessageDialog(contentPane, dishName);
	}

	public ArrayList<Dish> getCurrUserOrderdDishes() {

		Connection connect = ConnectToDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Dish> currUsrDishes = new ArrayList<>();
		String query = "select a.* from dishes a , orders b where a.dish_id = b.dish_id  and b.User_id = "
				+ currUser.getId() + " and b.current='Y'";
		// ArrayList<OrderOperation> totOrder = new ArrayList<>();
		try {
			statement = (Statement) connect.createStatement();

			resultSet = statement.executeQuery(query);
			System.out.println(query);
			while (resultSet.next()) {
				Dish tmpDish = new Dish();
				tmpDish.setDishID(resultSet.getInt("DISH_ID"));
				tmpDish.setName(resultSet.getString("DISH_NAME"));
				currUsrDishes.add(tmpDish);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currUsrDishes;

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
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return querySucess;
	}

}
