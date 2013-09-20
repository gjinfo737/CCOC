package com.eaj.ccoc.login;

import com.eaj.ccoc.dal.HTTPRequester;

public class Login {

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
				try {
					boolean loginResult = httpRequester.login(Login.this);
					activity.onLoginAttemptComplete(loginResult);
				} catch (Exception e) {
					e.printStackTrace();
					activity.onLoginAttemptComplete(false);
				}
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
