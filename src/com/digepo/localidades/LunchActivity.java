package com.digepo.localidades;

import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.widget.Toast;

public class LunchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_lunch);
		
		
		int resCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		
		Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resCode, this,10);
		Log.e("codigo", String.valueOf(resCode));
		switch (resCode) {
			case ConnectionResult.SUCCESS:
				Toast.makeText(this, R.string.play_services_on, Toast.LENGTH_SHORT).show();
				TimerTask task = new TimerTask() {
					
					@Override
					public void run() {
						
						Intent intent = new Intent().setClass(LunchActivity.this, MainActivity.class);
						startActivity(intent);
						overridePendingTransition(R.anim.zoom_splash_out, R.anim.zoom_splash);
						finish();
					}
				};
	
				Timer timer = new Timer();
				timer.schedule(task, 3000);
				break;
			case ConnectionResult.SERVICE_MISSING:
				dialog.show();
				break;
			case ConnectionResult.SERVICE_DISABLED:
				dialog.show();
				break;
			case ConnectionResult.SERVICE_INVALID:
				dialog.show();
				break;
			default:
				Toast.makeText(this, R.string.error_google_services, Toast.LENGTH_SHORT).show();
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lunch, menu);
		return false;
	}

}
