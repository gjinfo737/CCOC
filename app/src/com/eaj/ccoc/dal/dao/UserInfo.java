package com.eaj.ccoc.dal.dao;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.telephony.PhoneNumberUtils;

public class UserInfo {
	private final String email;

	private final Map<PhoneType, String> phones;

	public enum PhoneType {
		MOBILE, HOME, WORK
	}

	public UserInfo(String email, Map<PhoneType, String> phones) {
		this.email = email;
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone(PhoneType phoneType) {
		try {
			String phoneNumber = phones.get(phoneType);
			if (phoneNumber != null)
				return PhoneNumberUtils.formatNumber(phoneNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static UserInfo fromJson(JSONObject jsonObject) throws JSONException {

		UserInfo userInfo = null;
		if (jsonObject == null) {
			userInfo = new UserInfo("", new HashMap<UserInfo.PhoneType, String>());
		} else {
			Map<PhoneType, String> phonesNumbers = new HashMap<UserInfo.PhoneType, String>();
			phonesNumbers.put(PhoneType.HOME, jsonObject.getString("phone_home"));
			phonesNumbers.put(PhoneType.MOBILE, jsonObject.getString("phone_mobile"));
			phonesNumbers.put(PhoneType.WORK, jsonObject.getString("phone_work"));
			userInfo = new UserInfo(jsonObject.getString("email"), phonesNumbers);
		}
		return userInfo;
	}
}
