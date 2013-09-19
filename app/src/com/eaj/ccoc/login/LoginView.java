package com.eaj.ccoc.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.eaj.ccoc.R.id;

public class LoginView {

	private LoginActivity activity;
	private TextView tvUserName;
	private TextView tvPassword;
	private Button btnLogin;

	public LoginView(final LoginActivity activity) {
		this.activity = activity;
		this.tvUserName = (TextView) activity.findViewById(id.tv_username);
		this.tvPassword = (TextView) activity.findViewById(id.tv_password);
		this.btnLogin = (Button) activity.findViewById(id.btn_login);
		this.btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				activity.onLoginPress();
			}
		});
	}
}
