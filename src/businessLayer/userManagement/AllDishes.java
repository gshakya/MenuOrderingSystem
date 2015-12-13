package businessLayer.userManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.ReceiveFromDB;

public class AllDishes implements ReceiveFromDB {
	static Dishes[] dishArray;

//	public static void setDishes() {
//		dishArray = new Dishes[] { new Dishes(1, "Pizza", false), new Dishes(2, "Pasta", false),
//				new Dishes(3, "Rice", false), new Dishes(4, "Chicken", false), new Dishes(5, "Steak", false),
//				new Dishes(6, "Burger", false), new Dishes(7, "Noddles", false), new Dishes(8, "Soup", false) };
//
//	}

	@Override
	public ArrayList<Dishes> runSelectQuery(String query) {
		Connection connect = ConnectToDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Dishes> dishes = new ArrayList<>();
		try {
			statement = (Statement) connect.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Dishes tmpDish = new Dishes();
				tmpDish.setDishID(resultSet.getInt("DISH_ID"));
				tmpDish.setName(resultSet.getString("DISH_NAME"));
				dishes.add(tmpDish);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dishes;
	}

	public ArrayList<Dishes> getDishes() {
		String query = "SELECT * FROM DISHES WHERE CURRENT='Y'";
		ArrayList<Dishes> dishes = new ArrayList<>();
		dishes = runSelectQuery(query);

		return dishes;
	}

}
