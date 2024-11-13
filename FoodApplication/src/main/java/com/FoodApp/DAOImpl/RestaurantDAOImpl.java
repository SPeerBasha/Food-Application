package com.FoodApp.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.FooApp.dao.RestaurantDAO;
import com.FoodApp.UserModel.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO{
	String FetchAll="select * from restaurant";
	
	String url="jdbc:mysql://localhost:3306/spb";
	String username="root";
	String password="root";

	List<Restaurant> restaurantList=new ArrayList<Restaurant>();
	private Connection con;

	private Statement stmt;

	private ResultSet result;
	public RestaurantDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	@Override
	public List<Restaurant> fetchAll() {
		
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FetchAll);
			restaurantList=extractUserfromResult(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaurantList;
	}
		// TODO Auto-generated method stub
	List<Restaurant> extractUserfromResult(ResultSet result) {
		try {
			while(result.next()) {
				restaurantList.add(new Restaurant(result.getInt("restaurantId"),result.getString("name"),result.getString("cuisaneType"),
						result.getString("address"),result.getInt("ratings"),result.getString("deliveryTime"),result.getString("inactive")));		
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("ResDAOImp : ");
		System.out.println(restaurantList);
		return restaurantList;
	}
}
