package com.eaj.ccoc.home;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.eaj.ccoc.R.id;
import com.eaj.ccoc.R.layout;
import com.eaj.ccoc.dal.Directory;
import com.eaj.ccoc.dal.HTTPRequester;
import com.eaj.ccoc.dal.dao.Person;
import com.eaj.ccoc.home.PersonListWidget.IOnPersonSelectedListener;
import com.eaj.ccoc.userinfo.UserInfoActivity;

public class HomeActivity extends Activity implements IOnPersonSelectedListener {

	private PersonListWidget personListWidget;
	private Directory directory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout.activity_home);
		directory = new Directory(new HTTPRequester(), this);
		try {
			directory.refresh();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		personListWidget = new PersonListWidget(this, directory, this);
		RelativeLayout mainContainer = (RelativeLayout) findViewById(id.home_main_container);
		mainContainer.addView(personListWidget.getView());
	}

	public void notifyDataListeners() {
		runOnUiThread(new Runnable() {
			public void run() {
				personListWidget.refresh();
			}
		});
	}

	@Override
	public void onSelectPerson(Person person) {
		UserInfoActivity.setPerson(person);
		Intent intent = new Intent(getApplicationContext(),
				UserInfoActivity.class);
		startActivity(intent);
	}
}
