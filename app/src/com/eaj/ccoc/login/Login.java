package com.eaj.ccoc.login;

public class Login {
	private LoginActivity activity;

	public Login(final LoginActivity activity) {
		this.activity = activity;
	}

	public void attemptLogin() {
		activity.onLoginAttemptComplete(true);
	}

}
