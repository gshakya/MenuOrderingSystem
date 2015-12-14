package businessLayer.userManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.ReceiveFromDB;

public class AllDishes implements ReceiveFromDB {
	static Dish[] dishArray;

//	public static void setDishes() {
//		dishArray = new Dishes[] { new Dishes(1, "Pizza", false), new Dishes(2, "Pasta", false),
//				new Dishes(3, "Rice", false), new Dishes(4, "Chicken", false), new Dishes(5, "Steak", false),
//				new Dishes(6, "Burger", false), new Dishes(7, "Noddles", false), new Dishes(8, "Soup", false) };
//
//	}

	@Override
	public ArrayList<Dish> runSelectQuery(String query) {
		Connection connect = ConnectToDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Dish> dishes = new ArrayList<>();
		try {
			statement = (Statement) connect.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Dish tmpDish = new Dish();
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

	public ArrayList<Dish> getAllDishes() {
		String query = "SELECT * FROM DISHES";
		ArrayList<Dish> dishes = new ArrayList<>();
		dishes = runSelectQuery(query);

		return dishes;
	}
	
	public ArrayList<Dish> getCurrDishes() {
		String query = "SELECT * FROM DISHES WHERE CURRENT = 'Y'";
		ArrayList<Dish> dishes = new ArrayList<>();
		dishes = runSelectQuery(query);

		return dishes;
	}
}
