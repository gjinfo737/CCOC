package com.eaj.ccoc.dal.dao;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo {
	private final String email;

	public UserInfo(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public static UserInfo fromJson(JSONObject jsonObject) throws JSONException {
		return new UserInfo(jsonObject.getString("email"));
	}
}
