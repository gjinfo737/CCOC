package com.eaj.ccoc.home;

public class UserInfo {
	private final String phone;
	private final String email;

	public UserInfo(String phone, String email) {
		this.phone = phone;
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
}
