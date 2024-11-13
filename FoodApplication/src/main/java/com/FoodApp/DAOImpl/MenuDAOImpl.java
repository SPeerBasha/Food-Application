package com.FoodApp.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.FooApp.dao.MenuDAO;
import com.FoodApp.UserModel.Menu;


public class MenuDAOImpl implements MenuDAO{
	String url="jdbc:mysql://localhost:3306/spb";
	String username="root";
	String password="root";
	
	String INSERT="insert into Menu(menuId, restaurantId, name, description, price,rating, isAvailable, image) values(?,?,?,?,?,?,?,?)";
	String FETCHALL="select * from menu";
	String FETCHSPECIFIC="select * from menu where menuId=?";
	String UPDATE="update menu set name=? where menuId=?";
	String DELETE="delete from menu where menuId=? ";
	String FETCHALLRESTMENU = "SELECT * FROM MENU where restaurantId=?";
	
	String FETCHRESTAURANTID="select * from menu where restaurantId=?";
		
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet result;
	
	List<Menu> menuList=new ArrayList<Menu>();
	private Menu m;

	
	public MenuDAOImpl() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Menu m) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(INSERT);
			pstmt.setInt(1, m.getMenuId());
			pstmt.setInt(2, m.getRestaurantId());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getDescription());
			pstmt.setInt(5, m.getPrice());
			pstmt.setInt(6, m.getRating());
			pstmt.setString(7, m.getIsAvailable());
			pstmt.setString(8, m.getImage());
			status=pstmt.executeUpdate();
			if(status!=0) {
				System.out.println("Success");
			}
			else {
				System.out.println("Failure");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> fetchAll(int restId) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(FETCHALLRESTMENU);
			pstmt.setInt(1,restId);
			result=pstmt.executeQuery();
//			while(result.next()) {
//			System.out.println( result.getInt("menuId")+" "+result.getInt("restaurantId")+" "+
//					result.getString("name")+" "+
//					result.getString("description")+" "+
//					result.getInt("price")+" "+
//					result.getInt("rating")+" "+
//					result.getString("isAvailable")+" "+
//					result.getString("image"));
//			}
			
			menuList=extractMenufromenuList(result);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
	
	List<Menu> extractMenufromenuList(ResultSet result){
		try {
			while(result.next()) {
				menuList.add(new Menu( result.getInt("menuId"),result.getInt("restaurantId"),
						result.getString("name"),
						result.getString("description"),
						result.getInt("price"),
						result.getInt("rating"),
						result.getString("isAvailable"),
						result.getString("image")));
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public Menu fetchSpecific(int menuId) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(FETCHSPECIFIC);
			pstmt.setInt(1,menuId);
			result=pstmt.executeQuery();
			menuList=extractMenufromenuList(result);
			if(!menuList.isEmpty()) {
				 m=menuList.get(0);
			}
			else {
				System.out.println("No record");
				//System.exit(0);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int update(Menu m) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			try {
				pstmt=con.prepareStatement(UPDATE);
				pstmt.setString(1,m.getName());
				pstmt.setInt(2, m.getMenuId());
				status=pstmt.executeUpdate();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return status;
		}
		

		@Override
		public int delete(int menuId) {
			// TODO Auto-generated method stub
						try {
							pstmt=con.prepareStatement(DELETE);
							pstmt.setInt(1, menuId);
							status=pstmt.executeUpdate();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						return menuId;
		}	
		

		@Override
		public List<Menu> fetchMenu(Menu m) {
			// TODO Auto-generated method stub
			try {
				pstmt=con.prepareStatement(FETCHRESTAURANTID);
				pstmt.setInt(1, m.getRestaurantId());
				result=pstmt.executeQuery();
				menuList=extractMenufromenuList(result);
				if(!menuList.isEmpty()) {
					 m=menuList.get(0);
				}
				else {
					System.out.println("No record");
					System.exit(0);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return menuList;
		}
}
