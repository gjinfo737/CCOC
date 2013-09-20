package com.eaj.ccoc.login;

import com.eaj.ccoc.home.HTTPRequester;

public class Login {

	public static final String TEST_PASSWORD = "7u8i9o0p";
	public static final String TEST_USERNAME = "granjam";
	private LoginActivity activity;
	private HTTPRequester httpRequester;
	private String username;
	private String password;

	public Login(final LoginActivity activity, HTTPRequester httpRequester) {
		this.activity = activity;
		this.httpRequester = httpRequester;
	}

	public void attemptLogin(String username, String password) {
		this.username = username;
		this.password = password;
		Thread loginThread = new Thread(new Runnable() {
			public void run() {
				boolean loginResult = httpRequester.login(Login.this);
				activity.onLoginAttemptComplete(loginResult);
			}
		});
		loginThread.start();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
