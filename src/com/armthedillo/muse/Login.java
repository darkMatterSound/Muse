package com.armthedillo.muse;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

public class Login extends FragmentActivity {

	ImageView profile_pic;
	private LoginFragment loginFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	    if (savedInstanceState == null) {
	        // Add the fragment on initial activity setup
	        loginFragment = new LoginFragment();
	        getSupportFragmentManager()
	        .beginTransaction()
	        .add(android.R.id.content, loginFragment)
	        .commit();
	    } else {
	        // Or set the fragment from restored state info
	        loginFragment = (LoginFragment) getSupportFragmentManager()
	        .findFragmentById(android.R.id.content);
	    }
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
		
}
