package com.FooApp.dao;

import java.util.List;

import com.FoodApp.UserModel.Restaurant;

public interface RestaurantDAO {
	List<Restaurant> fetchAll();
}
