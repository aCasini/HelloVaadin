package com.example.services;

public class MockLogin {
	private static final String userName = "alessio.casini";
	private static final String passWord = "Pippo123";
	
	public static Boolean loginAction(String username, String password){
		if(userName.equalsIgnoreCase(username)
				&& passWord.equalsIgnoreCase(password)){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
}
