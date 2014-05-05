package com.tomatocat.taxicat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.List;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class AppointmentFragment extends Fragment {
	Context context;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_appointments, container,
				false);

		 final ListView lView = (ListView) rootView.findViewById(R.id.listView1);
		 
		// Defined Array values to show in ListView
	        String[] values = new String[] {"YMOB", "Tomato","Cat", "D", "E", "F", "G", "H", "I", 
	        		"J", "K", "L", "M", "N", "O", "P", "YMOB", "Tomato","Cat", "D", "E", "F"};

	        /* Define a new Adapter
	         * First parameter - Context
	         * Second parameter - Layout for the row
	         * Third parameter - ID of the TextView to which the data is written
	         * Forth - the Array of data
	         */ 

	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, values);
	      
	        // Assign adapter to ListView
	        lView.setAdapter(adapter); 
		    /*ParseQuery<ParseObject> query = ParseQuery.getQuery("booking");
		    query.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() {
		      public void done(ParseObject book, ParseException e) {
		        if (e == null) {
		        	String timePickup = book.getString("Time")
		        	
		        } else {
		        }
		      }
		    });*/
		    
		    /*listView= (ListView) findViewById(R.id.listViewAppointment);
		    String[] values = new String[] { "Ubuntu", "Android", "iPhone",
		        "Windows", "Ubuntu", "Android", "iPhone", "Windows" };
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.activity_list_item, values);
			listView.setAdapter(adapter); */
		    
		    /*ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Booking");
		    query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> ParseObject, ParseException e) {
		        if (e == null) {
		            
		        } else {
		            
		        }
		    }
		});
		*/
		 
		return rootView;
	}
}
