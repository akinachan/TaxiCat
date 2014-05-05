package com.tomatocat.taxicat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;

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
		context = rootView.getContext();

		iSender = (EditText) rootView.findViewById(R.id.txtSenderName);
		iAnimal = (EditText) rootView.findViewById(R.id.txtPetName);
		iPhone = (EditText) rootView.findViewById(R.id.txtSenderPhone);
		iAddress = (EditText) rootView.findViewById(R.id.txtPAddress);
		iTime = (EditText) rootView.findViewById(R.id.txtPTime);
		iDestination = (EditText) rootView.findViewById(R.id.txtDAddress);
		iContact = (EditText) rootView.findViewById(R.id.txtContactPhone);
		iSubmit = (Button) rootView.findViewById(R.id.btnBook);

		iSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bookingTaxi();
				AlertDialog.Builder builder = new AlertDialog.Builder(context);

				builder.setTitle("Success!")
						.setMessage("Taxi book, please wait for the confirmation.")
						.setCancelable(false)
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// do things
									}
								});
				AlertDialog alert = builder.create();
				alert.show();

				clearInput();

			}

			private void bookingTaxi() {
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

				ParseObject book = new ParseObject("Booking");
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

	public void clearInput() {
		iSender.setText("");
		iAnimal.setText("");
		iPhone.setText("");
		iAddress.setText("");
		iTime.setText("");
		iContact.setText("");
		iDestination.setText("");
	}
}
