package com.tomatocat.taxicat;

import com.parse.Parse;

import android.app.Application;

public class TaxiCatApplication extends Application{
	@Override
	public void onCreate() {
		super.onCreate();
		 Parse.initialize(this, "Op86JllENVggEUQlKrLvLFddTVrgJlGHUCPy08xf", "wjeMPG7RjZYFI7PpwDPyUJ5seFTM5qKiFk5z1T40");
		

	}
}
