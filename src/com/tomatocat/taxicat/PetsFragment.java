package com.tomatocat.taxicat;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.tomatocat.taxicat.AppointmentFragment.AppointmentAsyncTask;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost.OnTabChangeListener;

public class PetsFragment extends Fragment {
	protected final static String TAG = PetsFragment.class.getSimpleName();
	Context context;
	protected Button mAddPet;
	ListView mListPets;
	ProgressBar mProgressBar;
	PetsAsyncTask as;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_pets, container,
				false);
		context = rootView.getContext();
		mListPets = (ListView) rootView.findViewById(R.id.list_pets);
		mProgressBar = (ProgressBar) rootView
				.findViewById(R.id.pets_progressbar);

		mAddPet = (Button) rootView.findViewById(R.id.buttonAddPet);
		mAddPet.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(context, AddPet.class);
				startActivity(i);
			}
		});

		//new PetsAsyncTask().execute();

		return rootView;

	}

	public class PetsAsyncTask extends
			AsyncTask<Object, Void, List<ParseObject>> {

		@Override
		protected List<ParseObject> doInBackground(Object... params) {
			mProgressBar.setVisibility(View.VISIBLE);
			List<ParseObject> pets = new ArrayList<ParseObject>();
			ParseQuery<ParseObject> query = ParseQuery.getQuery("Pets");

			try {
				pets = query.find();

			} catch (ParseException e) {
				Log.e(TAG, "Caught Exception : " + e.getMessage(), e);

			}
			return pets;
		}

		@Override
		protected void onPostExecute(List<ParseObject> pets) {
			mProgressBar.setVisibility(View.INVISIBLE);
			ArrayList<String> arrayPets = new ArrayList<String>();
			for (int i = 0; i < pets.size(); i++) {
				arrayPets.add(pets.get(i).getString("Name"));
			}

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
					android.R.layout.simple_list_item_1, android.R.id.text1,
					arrayPets);
			mListPets.setAdapter(adapter);
		}
	}
}
