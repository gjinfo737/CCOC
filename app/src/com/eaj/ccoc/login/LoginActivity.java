package com.eaj.ccoc.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.eaj.ccoc.R.layout;
import com.eaj.ccoc.home.HomeActivity;

public class LoginActivity extends Activity {

	private LoginView loginView;
	private Login login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout.activity_login);
		login = new Login(this);
		loginView = new LoginView(this);
	}

	public void onLoginPress() {
		login.attemptLogin();
	}

	public void onLoginAttemptComplete(boolean successful) {
		startHome();
		finish();
	}

	private void startHome() {
		Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(intent);
	}
}
