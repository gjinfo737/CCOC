package com.eaj.ccoc.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.eaj.ccoc.R.layout;
import com.eaj.ccoc.dal.HTTPRequester;
import com.eaj.ccoc.home.HomeActivity;

public class LoginActivity extends Activity {

	private LoginView loginView;
	private Login login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		HTTPRequester.disposeClient();
		setContentView(layout.activity_login);
		login = new Login(this, new HTTPRequester());
		loginView = new LoginView(this);
	}

	public void onLoginPress() {
		login.attemptLogin(loginView.getUsername(), loginView.getPassword());
	}

	public void onLoginAttemptComplete(final boolean successful) {

		runOnUiThread(new Runnable() {
			public void run() {
				if (successful) {
					startHome();
					finish();
				} else {
					Log.e("", "login failure");
					loginView.clearPassword();
					Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
				}

			}
		});

	}

	private void startHome() {
		Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
		startActivity(intent);
	}
}
