package com.tomatocat.taxicat;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class AppointmentFragment extends Fragment {
	protected final static String TAG = AppointmentFragment.class
			.getSimpleName();
	Context context;
	ListView mListAppointment;
	ProgressBar mProgressBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_appointments,
				container, false);
		context = rootView.getContext();
		mListAppointment = (ListView) rootView.findViewById(R.id.app_list);
		mProgressBar = (ProgressBar) rootView
				.findViewById(R.id.appointment_progressbar);

		new AppointmentAsyncTask().execute();
		
	
		return rootView;
	}

	public class AppointmentAsyncTask extends
			AsyncTask<Object, Void, List<ParseObject>> {

		@Override
		protected List<ParseObject> doInBackground(Object... params) {
			mProgressBar.setVisibility(View.VISIBLE);
			List<ParseObject> appointments = new ArrayList<ParseObject>();
			ParseQuery<ParseObject> query = ParseQuery.getQuery("Booking");

			try {
				appointments = query.find();

			} catch (ParseException e) {
				Log.e(TAG, "Caught Exception : " + e.getMessage(), e);

			}
			return appointments;
		}

		@Override
		protected void onPostExecute(List<ParseObject> appointments) {
			mProgressBar.setVisibility(View.INVISIBLE);
			ArrayList<String> arrayAppointments = new ArrayList<String>();
			for (int i = 0; i < appointments.size(); i++) {
				arrayAppointments.add(appointments.get(i).getString("Sender"));
			}

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
					android.R.layout.simple_list_item_1, android.R.id.text1,
					arrayAppointments);
			mListAppointment.setAdapter(adapter);
		}
	}
}
