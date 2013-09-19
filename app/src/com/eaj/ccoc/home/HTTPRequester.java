package com.eaj.ccoc.home;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class HTTPRequester {

	private static final String URL_DIRECTORY = "http://allenjames.net/ccoc_directory/php/svc_user.php?method=get_directory";
	private static final String URL_LOGIN = "http://allenjames.net/ccoc_directory/php/svc_user.php?method=login";
	private static final String TEST_PASSWORD = "7u8i9o0p";
	private static final String TEST_USERNAME = "granjam";

	public void getDirectory(final Directory directory) throws JSONException,
			IOException, URISyntaxException {
		Thread req = new Thread(new Runnable() {
			public void run() {
				boolean error = false;
				try {
					Log.i("", "request thread started");
					final String json = requestDirectory();
					onCompleteGetDirectory(directory, json);
				} catch (MalformedURLException e) {
					error = true;
					e.printStackTrace();
				} catch (IOException e) {
					error = true;
					e.printStackTrace();
				} catch (URISyntaxException e) {
					error = true;
					e.printStackTrace();
				}
				if (error)
					onCompleteGetDirectory(directory, "{}");
				return;
			}
		});
		req.start();
	}

	private void onCompleteGetDirectory(Directory directory, String json) {
		List<Person> persons = new ArrayList<Person>();
		try {
			JSONObject jsonObject = new JSONObject(json);
			Iterator keys = jsonObject.keys();
			while (keys.hasNext()) {
				String next = keys.next().toString();
				if (next.equalsIgnoreCase("total"))
					continue;
				JSONObject jop = jsonObject.getJSONObject(next);
				persons.add(new Person(jop.getString("fname")));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		directory.onDirectoryRetrieved(persons);
	}

	private String requestDirectory() throws MalformedURLException,
			IOException, URISyntaxException {
		Log.i("", "requesting");

		HttpClient httpclient = getLoggedInClient();
		HttpResponse response = httpclient.execute(new HttpGet(new URI(
				URL_DIRECTORY)));
		StatusLine statusLine = response.getStatusLine();
		if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			response.getEntity().writeTo(out);
			out.close();
			String responseString = out.toString();
			return responseString;
		} else {
			// Closes the connection.
			response.getEntity().getContent().close();
			throw new IOException(statusLine.getReasonPhrase());
		}
	}

	private HttpClient getLoggedInClient() throws IllegalStateException,
			IOException {
		HttpClient httpclient = new DefaultHttpClient();

		HttpPost httppost = new HttpPost(URL_LOGIN);
		// Add your data
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		nameValuePairs.add(new BasicNameValuePair("l", TEST_USERNAME));
		nameValuePairs.add(new BasicNameValuePair("p", TEST_PASSWORD));
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		// Execute HTTP Post Request
		HttpResponse response = httpclient.execute(httppost);

		StatusLine statusLine = response.getStatusLine();
		if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			response.getEntity().writeTo(out);
			out.close();
			return httpclient;
		} else {
			// Closes the connection.
			response.getEntity().getContent().close();
			throw new IOException(statusLine.getReasonPhrase());
		}
	}
}
