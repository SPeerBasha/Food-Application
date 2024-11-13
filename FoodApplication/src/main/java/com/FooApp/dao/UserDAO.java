package com.FooApp.dao;

import java.util.List;

import com.FoodApp.UserModel.User;
public interface UserDAO {
	int insert(User u);
	
	List<User>  fetchAll(User u);

	User fetchSpecific(int uid);
		
	int update(User u);

	int delete(int uid);
	User getUser(String email);
}
