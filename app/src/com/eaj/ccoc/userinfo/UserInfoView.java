package com.eaj.ccoc.userinfo;

import java.util.HashMap;
import java.util.Map;

import android.widget.TextView;

import com.eaj.ccoc.R.id;
import com.eaj.ccoc.dal.dao.Person;
import com.eaj.ccoc.dal.dao.UserInfo;
import com.eaj.ccoc.dal.dao.UserInfo.PhoneType;

public class UserInfoView {

	private UserInfoActivity userInfoActivity;
	private TextView tvName;
	private TextView tvEmail;
	private Map<PhoneType, TextView> tvPhones;

	public UserInfoView(UserInfoActivity userInfoActivity) {
		this.userInfoActivity = userInfoActivity;
		attachViews();
	}

	private void attachViews() {
		this.tvName = (TextView) this.userInfoActivity.findViewById(id.tv_name);
		this.tvEmail = (TextView) this.userInfoActivity
				.findViewById(id.tv_email);
		tvPhones = new HashMap<UserInfo.PhoneType, TextView>();
		this.tvPhones.put(PhoneType.MOBILE, (TextView) this.userInfoActivity
				.findViewById(id.tv_phone_mobile));
		this.tvPhones
				.put(PhoneType.HOME, (TextView) this.userInfoActivity
						.findViewById(id.tv_phone_home));
		this.tvPhones
				.put(PhoneType.WORK, (TextView) this.userInfoActivity
						.findViewById(id.tv_phone_work));
	}

	public void showPerson(Person person) {
		tvName.setText(person.toString());
		tvEmail.setText(person.getUserInfo().getEmail());
		for (PhoneType type : tvPhones.keySet())
			tvPhones.get(type).setText(person.getUserInfo().getPhone(type));
	}

}
