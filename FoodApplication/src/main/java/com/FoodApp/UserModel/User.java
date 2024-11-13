package com.FoodApp.UserModel;

public class User {
	private int uid;
	private String Username;
	private String email;
	private String password;
	private String mobile;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public User(int uid) {
		super();
		this.uid = uid;
	}
	public User(int uid, String username, String email, String password, String mobile) {
		super();
		this.uid = uid;
		Username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	
	public User(int uid, String email) {
		super();
		this.uid = uid;
		this.email = email;
	}
	
	public User( String username, String email, String password, String mobile) {
		super();
		Username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
//	
//	public User(String email) {
//		super();
//		this.email = email;
//	}
	@Override
	public String toString() {
//		return "User [uid=" + uid + ", Username=" + Username + ", email=" + email + ", password=" + password
//				+ ", mobile=" + mobile + "]";
		
		return uid+" "+Username+" "+email+" "+password+" "+mobile;
	}
	
}

