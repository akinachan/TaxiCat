package com.tomatocat.taxicat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

<<<<<<< HEAD
public class PetsFragment extends Fragment {
=======


public class PetsFragment extends Fragment {
	Context context;
	protected Button mAddPet;
>>>>>>> d08dabb28101e8b892316b0553e71144109632ea
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_pets, container,
				false);
		context= rootView.getContext();
		
		
		mAddPet = (Button) rootView.findViewById(R.id.buttonAddPet);
		mAddPet.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Intent i = new Intent(context, AddPet.class);
				startActivity(i);
			}
		});
		return rootView;
		
		
	}
	
}
