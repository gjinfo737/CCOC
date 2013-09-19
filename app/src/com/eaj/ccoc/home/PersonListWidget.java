package com.eaj.ccoc.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.eaj.ccoc.R.layout;

public class PersonListWidget {

	private ListView listView;
	private PersonListAdapter adapter;
	private RelativeLayout view;

	public PersonListWidget(Activity activity, Directory directory) {
		LayoutInflater layoutInflater = activity.getLayoutInflater();
		view = (RelativeLayout) layoutInflater.inflate(
				layout.person_list_widget, null);
		adapter = new PersonListAdapter(layoutInflater, directory);
		listView = new ListView(activity);
		listView.setAdapter(adapter);
		view.addView(listView);
		refresh();
	}

	public void refresh() {
		adapter.refresh();
	}

	public View getView() {
		return view;
	}
}
