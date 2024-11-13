package com.FoodApp.UserModel;

public class Menu {
	int menuId;
	int restaurantId;
	String name;
	String description;
	int price;
	int rating;
	String isAvailable;
	String image;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Menu(int menuId, int restaurantId, String name, String description, int price, int rating,
			String isAvailable, String image) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.image = image;
	}
	public Menu(int menuId, String name) {
		super();
		this.menuId = menuId;
		this.name = name;
	}
	
	public Menu() {
		super();
	}
	
	public Menu(int menuId) {
		super();
		this.menuId = menuId;
	}
	@Override
	public String toString() {
//		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", name=" + name + ", description="
//				+ description + ", price=" + price + ", rating=" + rating + ", isAvailable=" + isAvailable + ", image="
//				+ image + "]";
		
		return menuId+" "+restaurantId+" "+name+" "+description+" "+price+" "+rating+" "+  isAvailable+" "+image;
	}
}
