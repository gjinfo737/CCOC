package com.eaj.ccoc.userinfo;

import android.widget.TextView;

import com.eaj.ccoc.R.id;
import com.eaj.ccoc.dal.dao.Person;

public class UserInfoView {

	private UserInfoActivity userInfoActivity;
	private TextView tvName;
	private TextView tvEmail;
	private TextView tvPhoneMobile;

	public UserInfoView(UserInfoActivity userInfoActivity) {
		this.userInfoActivity = userInfoActivity;
		attachViews();
	}

	private void attachViews() {
		this.tvName = (TextView) this.userInfoActivity.findViewById(id.tv_name);
		this.tvEmail = (TextView) this.userInfoActivity
				.findViewById(id.tv_email);
		this.tvPhoneMobile = (TextView) this.userInfoActivity
				.findViewById(id.tv_phone_mobile);
	}

	public void showPerson(Person person) {
		tvName.setText(person.toString());
		tvEmail.setText(person.getUserInfo().getEmail());
		tvPhoneMobile.setText("phone unknown");
	}

}
