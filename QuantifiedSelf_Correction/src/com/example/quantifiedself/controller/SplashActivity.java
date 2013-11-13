package com.example.quantifiedself.controller;

import com.example.quantifiedself.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Thread splashScreen = new Thread(){
			
			public void run(){
				try{
					sleep(1000);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					startActivity(new Intent(getApplicationContext(),HomeActivity.class));
					finish();
				}	
			}
		};
		
		splashScreen.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		return false;
	}

}
