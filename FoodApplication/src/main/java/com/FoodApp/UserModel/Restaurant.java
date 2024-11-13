package com.FoodApp.UserModel;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String cuisaneType;
	private String address;
	private int ratings;
	private String deliveryTime;
	private String inactive;
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
	public String getCuisaneType() {
		return cuisaneType;
	}
	public void setCuisaneType(String cuisaneType) {
		this.cuisaneType = cuisaneType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getInactive() {
		return inactive;
	}
	public void setInactive(String inactive) {
		this.inactive = inactive;
	}
	public Restaurant(int restaurantId, String name, String cuisaneType, String address, int ratings, String deliveryTime,
			String inactive) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisaneType = cuisaneType;
		this.address = address;
		this.ratings = ratings;
		this.deliveryTime = deliveryTime;
		this.inactive = inactive;
	}
	
	public Restaurant(int restaurantId) {
		super();
		this.restaurantId = restaurantId;
	}
	public Restaurant(int restaurantId, String cuisaneType ) {
		this.restaurantId=restaurantId;
		this.cuisaneType=cuisaneType;
	}
	@Override
	public String toString() {
//		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisaneType=" + cuisaneType
//				+ ", address=" + address + ", ratings=" + ratings + ", deliveryTime=" + deliveryTime + ", inactive="
//				+ inactive + "]";
		return restaurantId+" "+name+" "+cuisaneType+" "+address+" "+ratings+" "+deliveryTime+" "+inactive;
	}
}
