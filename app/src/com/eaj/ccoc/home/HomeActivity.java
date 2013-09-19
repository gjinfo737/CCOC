package com.eaj.ccoc.home;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.eaj.ccoc.R.id;
import com.eaj.ccoc.R.layout;

public class HomeActivity extends Activity {

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
		personListWidget = new PersonListWidget(this, directory);
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
}
