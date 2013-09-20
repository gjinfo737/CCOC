package com.eaj.ccoc.userinfo;

import android.app.Activity;
import android.os.Bundle;

import com.eaj.ccoc.R.layout;
import com.eaj.ccoc.dal.dao.Person;

public class UserInfoActivity extends Activity {
	private UserInfoView view;
	private static Person person;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout.activity_user_info);
		view = new UserInfoView(this);
		view.showPerson(person);
	}

	public static void setPerson(Person person) {
		UserInfoActivity.person = person;
	}

}
