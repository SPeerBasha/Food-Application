package com.FooApp.Security;

import com.FoodApp.Secret.Secret;

public class Encrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//encrypt("rahul@gmail.com");
	}
	public static String encrypt(String str) {
		String newStr="";
		for(int i=0;i<str.length();i++) {
			newStr=newStr+(char)(str.charAt(i)+Secret.getKey());
		}
		return newStr;
	}
}




