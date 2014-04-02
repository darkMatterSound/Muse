package com.armthedillo.muse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import de.voidplus.soundcloud.SoundCloud;

public class Tutorial extends Activity{
	/*Called when activity is first created*/

	Button lastfm_login;
	
	@Override
	public void onCreate(Bundle Tutorial) {
		super.onCreate(Tutorial);
		setContentView(R.layout.tut_1);
        addButtonListener();
    }
    public void addButtonListener() {
        lastfm_login = (Button) findViewById(R.id.lastfm_login);
        lastfm_login.setOnClickListener(new OnClickListener() {
        	
            @Override
            public void onClick(View view) {
                Toast.makeText(Tutorial.this,"You have activated Last FM",Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    SoundCloud login = new SoundCloud(
    	    "APP_CLIENT_ID",
    	    "APP_CLIENT_SECRET",
    	    "LOGIN_NAME",
    	    "LOGIN_PASS"
    	);
}
