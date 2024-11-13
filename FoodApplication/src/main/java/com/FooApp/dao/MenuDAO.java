package com.FooApp.dao;

import java.util.List;

import com.FoodApp.UserModel.Menu;


public interface MenuDAO {
	void insert(Menu m);
	List<Menu> fetchAll(int restId);
	Menu fetchSpecific(int menuId);
	int update(Menu m);
	int delete(int menuId);
	List<Menu> fetchMenu(Menu m); 
}
