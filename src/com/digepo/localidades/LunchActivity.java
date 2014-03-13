package com.digepo.localidades;

import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.widget.Toast;

public class LunchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_lunch);
		
		//variable para revision de disponibilidad de Google Play Services
		int resCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		
		Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resCode, this,10);
		switch (resCode) {
			case ConnectionResult.SUCCESS: //si es correcto accesamos a la aplicación
				Toast.makeText(this, R.string.play_services_on, Toast.LENGTH_SHORT).show();
				TimerTask task = new TimerTask() {
					
					@Override
					public void run() {
						//Iniciamos la actividad de mapa y obtencion de datos
						Intent intent = new Intent().setClass(LunchActivity.this, MainActivity.class);
						startActivity(intent);
						overridePendingTransition(R.anim.zoom_splash_out, R.anim.zoom_splash);
						finish();
					}
				};
				//Se inicia un timer para proporcionar el efecto de carga de la aplicación
				Timer timer = new Timer();
				timer.schedule(task, 3000);
				break;
			//En caso de servicios perdidos, deshabilitados o inválidos se advierte y la aplicacion se detiene
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
