package com.armthedillo.muse;

import de.voidplus.soundcloud.SoundCloud;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Tutorial extends Activity{
	/*Called when activity is first created*/

	Button lastfm_login;
	Button soundcloud_login;
	
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
    
    	soundcloud_login = (Button) findViewById(R.id.soundcloud_login);
    	soundcloud_login.setOnClickListener(new SoundCloud());
    }
}
