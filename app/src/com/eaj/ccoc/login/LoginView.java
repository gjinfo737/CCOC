package com.eaj.ccoc.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.eaj.ccoc.R.id;

public class LoginView {

	private LoginActivity activity;
	private EditText etUsername;
	private EditText etPassword;
	private Button btnLogin;

	public LoginView(final LoginActivity activity) {
		this.activity = activity;
		this.etUsername = (EditText) activity.findViewById(id.et_username);
		this.etPassword = (EditText) activity.findViewById(id.et_password);
		this.btnLogin = (Button) activity.findViewById(id.btn_login);
		this.btnLogin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				activity.onLoginPress();
			}
		});
	}

	public String getUsername() {
		return etUsername.getText().toString();
	}

	public String getPassword() {
		return etPassword.getText().toString();
	}

	public void clearPassword() {
		etPassword.setText("");
	}

}
