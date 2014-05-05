package com.tomatocat.taxicat;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BookingFragment extends Fragment {
	protected EditText iSender;
	protected EditText iAnimal;
	protected EditText iPhone;
	protected EditText iAddress;
	protected EditText iTime;
	protected EditText iDestination;
	protected EditText iContact;
	protected Button iSubmit;
	Context context;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_booking, container,
				false);
		context= rootView.getContext();
		
		iSender = (EditText) rootView.findViewById(R.id.inputSender);
		iAnimal = (EditText) rootView.findViewById(R.id.inputAnimal);
		iPhone = (EditText) rootView.findViewById(R.id.inputPhone);
		iAddress = (EditText) rootView.findViewById(R.id.inputAddress);
		iTime = (EditText) rootView.findViewById(R.id.inputTime);
		iDestination = (EditText) rootView.findViewById(R.id.inputDestination);
		iContact = (EditText) rootView.findViewById(R.id.inputContact);
		iSubmit = (Button) rootView.findViewById(R.id.buttonSubmit);

		iSubmit.setOnClickListener(new View.OnClickListener() {

		
			@Override
			public void onClick(View v) {
				String sender = iSender.getText().toString();
				String animal = iAnimal.getText().toString();
				String phone = iPhone.getText().toString();
				String address = iAddress.getText().toString();
				String time = iTime.getText().toString();
				String destination = iDestination.getText().toString();
				String contact = iContact.getText().toString();

				sender = sender.trim();
				animal = animal.trim();
				phone = phone.trim();
				address = address.trim();
				time = time.trim();
				destination = destination.trim();
				contact = contact.trim();
				
				

				ParseObject book = new ParseObject("booking");
				book.put("Sender", sender);
				book.put("Animal", animal);
				book.put("Phone", phone);
				book.put("Address", address);
				book.put("Time", time);
				book.put("Destination", destination);
				book.put("Contact", contact);
				book.saveInBackground();

				
			}		

		});
		
		return rootView;
	}
}
