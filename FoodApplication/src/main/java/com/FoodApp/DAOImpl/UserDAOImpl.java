package com.FoodApp.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.FooApp.dao.UserDAO;
import com.FoodApp.UserModel.User;


public class UserDAOImpl implements UserDAO{
	String INSERTQUERY="insert into User(uid,username,email,password,mobile) values(?,?,?,?,?)";
	String FETCHQUERY="Select *from User";
	String FETCHSPECIFIC="Select *from User where uid=?";
	String UPDATEQUERY="update User set email=?  where uid=?";
	String FETCHBYEMAIL = "Select * from User where email=?";
	String DELETE="delete from User where uid=?";
	List<User> userList=new ArrayList<User>();
	User user;

	private String url="jdbc:mysql://localhost:3306/spb";
	private String username="root";
	private String password="root";
	private Connection con;

	private PreparedStatement pstmt;

	private int status;
	private ResultSet result;
	private Statement stmt;
	private User u;

	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(User u) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1, u.getUid());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getMobile());

			status = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public List<User> fetchAll(User u) {
		// TODO Auto-generated method stub
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FETCHQUERY);
			//			while(result.next()) {
			//				userList.add(new User(result.getInt("uid"),result.getString("Username"),result.getString("email"),
			//		result.getInt("password"),result.getInt("mobile")));		
			//			}

			userList=extractUserfromResult(result);

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	List<User> extractUserfromResult(ResultSet result) {
		try {
			while(result.next()) {
				userList.add(new User(result.getInt("uid"),result.getString("Username"),result.getString("email"),
						result.getString("password"),result.getString("mobile")));		
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	@Override
	public User fetchSpecific(int uid) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(FETCHSPECIFIC);
			pstmt.setInt(1,uid);

			result=pstmt.executeQuery();

			//			while(result.next()) {
			//				u=new User(
			//						result.getInt("uid"),
			//						result.getString("Username"),
			//						result.getString("email"),
			//					result.getInt("password"),
			//					result.getInt("mobile"));
			//			}

			userList=	extractUserfromResult(result);
			if(!userList.isEmpty()) {
				u=userList.get(0);
			}
			else {
				System.out.println("No records");
				//System.exit(0);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public int update(User u) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(UPDATEQUERY);
			pstmt.setString(1,u.getEmail());
			pstmt.setInt(2,u.getUid());	

			status=pstmt.executeUpdate();


		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int delete(int uid) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, uid);
			status=pstmt.executeUpdate();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public User getUser(String email) { 
//		User user = null;
		try { 
			pstmt = con.prepareStatement(FETCHBYEMAIL); 
			pstmt.setString(1, email);
			result = pstmt.executeQuery();
			if (result.next()) {
				user = new User( result.getInt("uid"), 
						result.getString("username"), result.getString("email"), result.getString("password"), result.getString("mobile") );
			} 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
		return user;
	}
	

}

