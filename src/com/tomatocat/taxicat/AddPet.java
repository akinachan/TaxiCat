package com.tomatocat.taxicat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;

public class AddPet extends Activity {
	protected EditText petName;
	protected EditText petType;
	protected EditText petColor;
	protected EditText petAge;
	protected EditText petGender;
	protected Button petAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_pets);

		Intent intent = getIntent();

		petName = (EditText) findViewById(R.id.inputPetName);
		petType = (EditText) findViewById(R.id.inputPetType);
		petColor = (EditText) findViewById(R.id.inputPetColor);
		petAge = (EditText) findViewById(R.id.inputPetAge);
		petGender = (EditText) findViewById(R.id.inputPetGender);
		petAdd = (Button) findViewById(R.id.buttonAdd);

		petAdd.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				String name = petName.getText().toString();
				String type = petType.getText().toString();
				String color = petColor.getText().toString();
				String age = petAge.getText().toString();
				String gender = petGender.getText().toString();


				name = name.trim();
				type = type.trim();
				color = color.trim();
				age = age.trim();
				gender = gender.trim();

				ParseObject pet = new ParseObject("Pets");
				pet.put("Name", name);
				pet.put("Type", type);
				pet.put("Color", color);
				pet.put("Age", age);
				pet.put("Gender", gender);
				pet.saveInBackground();

				Intent intent = new Intent(AddPet.this, PetsFragment.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(intent);

			}

		});
	}
}
