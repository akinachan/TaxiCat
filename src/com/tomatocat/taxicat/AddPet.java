package com.tomatocat.taxicat;

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

		petName = (EditText) findViewById(R.id.txtPetName);
		petType = (EditText) findViewById(R.id.txtPetType);
		petColor = (EditText) findViewById(R.id.txtPetColor);
		petAge = (EditText) findViewById(R.id.txtPetAge);
		petGender = (EditText) findViewById(R.id.txtPetGender);
		petAdd = (Button) findViewById(R.id.btnAddPet);

		petAdd.setOnClickListener(new View.OnClickListener() {
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
				Intent intent = new Intent(AddPet.this, MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				intent.putExtra("navigate", 1);
				startActivity(intent);

			}

		});
	}
}
