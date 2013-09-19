package com.eaj.ccoc.home;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eaj.ccoc.R.id;
import com.eaj.ccoc.R.layout;

public class PersonListAdapter extends BaseAdapter {
	private List<Person> persons;
	private LayoutInflater inflater;
	private Directory directory;

	public PersonListAdapter(LayoutInflater inflater, Directory directory) {
		this.inflater = inflater;
		this.directory = directory;
		persons = new ArrayList<Person>();
	}

	public void refresh() {
		this.persons = directory.getPersons();
		PersonSorter.sort(persons);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return persons.size();
	}

	@Override
	public Person getItem(int position) {
		return persons.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = inflater.inflate(layout.li_person, null);
		TextView tvPersonLi = (TextView) view.findViewById(id.tv_li_person);
		tvPersonLi.setText(getItem(position).toString());
		return view;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
