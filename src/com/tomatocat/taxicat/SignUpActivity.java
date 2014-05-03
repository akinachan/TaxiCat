package com.tomatocat.taxicat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity {
	protected EditText mFirstName;
	protected EditText mLastName;
	protected EditText mEmail;
	protected EditText mAddress;
	protected EditText mPhone;
	protected EditText mUsername;
	protected EditText mPassword;
	protected Button mSignUpButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		mFirstName = (EditText) findViewById(R.id.txtfName);
		mLastName = (EditText) findViewById(R.id.txtlName);
		mEmail = (EditText) findViewById(R.id.txtEmail);
		mAddress = (EditText) findViewById(R.id.txtAddress);
		mPhone = (EditText) findViewById(R.id.txtPhone);
		mUsername = (EditText) findViewById(R.id.txtUsername);
		mPassword = (EditText) findViewById(R.id.txtPassword);
		mSignUpButton = (Button) findViewById(R.id.buttonSubmit);

		mSignUpButton.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				String firstname = mFirstName.getText().toString();
				String lastname = mLastName.getText().toString();
				String email = mEmail.getText().toString();
				String address = mAddress.getText().toString();
				String username = mUsername.getText().toString();
				String phone = mPhone.getText().toString();
				String password = mPassword.getText().toString();
		
				
				firstname = firstname.trim();
				lastname = lastname.trim();
				email = email.trim();
				address = address.trim();
				phone = phone.trim();
				username = username.trim();
				password = password.trim();
				
						
				if(username.isEmpty() || password.isEmpty()){
					AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
					builder.setMessage(R.string.signup_error_message)
					.setTitle(R.string.signup_error_title)
					.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show();
				}
				else{
					//create new user
					setProgressBarIndeterminateVisibility(true);
					ParseUser newUser = new ParseUser();
					newUser.setUsername(username);
					newUser.setPassword(password);
					newUser.signUpInBackground(new SignUpCallback() {
						
						@Override
						public void done(ParseException e) {
							setProgressBarIndeterminateVisibility(false);
							if(e==null){
								//Success!!
								Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
								startActivity(intent);
							}
							else{
								AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
								builder.setMessage(e.getMessage())
								.setTitle(R.string.signup_error_title)
								.setPositiveButton(android.R.string.ok, null);
								AlertDialog dialog = builder.create();
								dialog.show();
							}
								
							
						}
					});
				}
				
			}
		});
	
	}
}
