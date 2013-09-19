package com.eaj.ccoc.home;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.util.Log;

public class Directory {
	private HTTPRequester httpRequester;
	private List<Person> persons;
	private HomeActivity homeActivity;

	public Directory(HTTPRequester httpRequester, HomeActivity homeActivity) {
		this.httpRequester = httpRequester;
		this.homeActivity = homeActivity;
		persons = new ArrayList<Person>();
	}

	public List<Person> getPersons() {
		Log.i("getPersons", "" + persons.size());
		return persons;
	}

	public void refresh() throws JSONException, IOException, URISyntaxException {
		Log.i("refresh", "refresh");
		httpRequester.getDirectory(this);
	}

	public void onDirectoryRetrieved(List<Person> persons) {
		this.persons = persons;
		homeActivity.notifyDataListeners();
	}

}
