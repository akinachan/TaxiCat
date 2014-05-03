package com.tomatocat.taxicat;

import com.parse.ParseUser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	protected final static String TAG = MainActivity.class.getSimpleName();
	private SharedPreferences pref;
	String MyPREFERENCES = "MyPref";
	String logKey = "user_log";
	boolean login_status = false;;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ParseUser currentUser = ParseUser.getCurrentUser();

		if (currentUser == null) {
			navigateToLogin();
		} else {
			Log.d(TAG, "username" + currentUser.getUsername());
		}
	}

	private void navigateToLogin() {

		Intent intent = new Intent(this, LoginActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		switch (id) {
		case R.id.action_settings:
			return true;
		case R.id.action_logout:
			ParseUser.logOut();
			navigateToLogin();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

		// return super.onOptionsItemSelected(item);
	}


}
