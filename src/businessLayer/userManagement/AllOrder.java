package businessLayer.userManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dataAccessLayer.dbInterface.ConnectToDB;
import dataAccessLayer.dbInterface.ReceiveFromDB;
import dataAccessLayer.dbInterface.SendToDB;

public class AllOrder  implements SendToDB {
	//public class AllOrder implements ReceiveFromDB  {
	
/*	@Override
	public ArrayList<OrderOperation> runSelectQuery(String query) {
		Connection connect = ConnectToDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<OrderOperation> totOrder = new ArrayList<>();
		try {
			statement = (Statement) connect.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				OrderOperation tmpOrder = new OrderOperation();
				tmpOrder.setCount(resultSet.getInt("COUNT"));
				tmpOrder.setDishName(resultSet.getString("DISHNAME"));
				totOrder.add(tmpOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totOrder;
	}
	*/
	
	public int runSelectQuery(String query) {
		Connection connect = ConnectToDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		int totOrder=0;
		//ArrayList<OrderOperation> totOrder = new ArrayList<>();
		try {
			statement = (Statement) connect.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				totOrder=resultSet.getInt("COUNT");
				/*
				OrderOperation tmpOrder = new OrderOperation();
				tmpOrder.setCount(resultSet.getInt("COUNT"));
				tmpOrder.setDishName(resultSet.getString("DISHNAME"));
				totOrder.add(tmpOrder);
				*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totOrder;
	}

	public int getOrders(String dish) {
		//public ArrayList<OrderOperation> getOrders(int i) {
		System.out.println(dish);
		String query = "SELECT count(*) COUNT from orders A join dishes B on a.DISH_ID=b.DISH_ID WHERE A.CURRENT='Y' AND B.DISH_NAME='"+dish+"' GROUP BY DISH_NAME ";
		//ArrayList<OrderOperation> totOrdr = new ArrayList<>();
		int totOrder=0;
		totOrder = runSelectQuery(query);

		return totOrder;
	}
	
//	public static String totalOrders(String dishName) {
//		
//		return getOrders;
//	}

	
	class OrderOperation
	{
		String dishName;
		int count;
		
		public OrderOperation()
		{
			
		}
		
		public OrderOperation(String dishName, int count)
		{
			this.dishName=dishName;
			this.count=count;
		}
		
		public String getDishName() {
			return dishName;
		}
		public void setDishName(String dishName) {
			this.dishName = dishName;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
	}
	
	public void showMenu(char enable)
	{
		String query="";
		if(enable == 'Y')
		{
			query = "UPDATE DISHES SET CURRENT ='Y' ";
		}
		else
		{
			query = "UPDATE DISHES SET CURRENT ='N' ";
		}
		runInsertQuery(query);
	}
	public int runInsertQuery(String query)
	{
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
