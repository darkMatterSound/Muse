package com.armthedillo.muse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	/*Called when activity is first created*/

	@Override
	public void onCreate(Bundle Splash) {
		super.onCreate(Splash);
		setContentView(R.layout.splash);
		Thread splashTimer = new Thread(){
			public void run(){
				try{
					sleep(5);
					Intent loginIntent = new Intent("com.armthedillo.muse.LOGIN");
					startActivity(loginIntent);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				finally{
					finish();
				}
			}
		};
		splashTimer.start();
	}
}