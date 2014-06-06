package com.digepo.localidades;

import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.widget.Toast;

/**
 * Clase LunchActivity. Imagen tipo "splash" para carga de la aplicacion.
 */
public class LunchActivity extends Activity {

	boolean isGPS;
	boolean isWifi;
		
	boolean isbackPressed;
	
	LocationManager locManager = null;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_lunch);
		
		locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		
		/* Variable para revision de disponibilidad de Google Play Services */
		int resCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		
		Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resCode, this,10);
		switch (resCode) {
			/* Si tiene instalado Google Play o Play Store se muestra la pantalla para localizacion. */
			case ConnectionResult.SUCCESS:
					
				
				iniciaApp();
				
				break;
			/* En caso que no se tenga Google Play o Google Services instalado
			 * se mostrara un popup para invitar a instalar la aplicacion antes 
			 * de pasar a la siguiente pantalla, porque es un requisito indispensable
			 * al momento de hacer las peticiones a GoogleAPIS. 
			 * */
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

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lunch, menu);
		return false;
	}
	
	
	
	@Override
	protected void onResume() {
		super.onResume();
		if(isbackPressed) {
			
			Log.e("onResume", "iniciaApp");
			iniciaApp();
		}
		else {
			
			Log.e("Todo falso","Booleanas negativas");
			
			isbackPressed = false;
			
		}
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Log.e("onBackPressed", "Back");
	}
	
	public void iniciaApp() {
		
		if(locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			Log.e("Iniciando", "GPSservice activo");
			isGPS = true;
		}
		else if(locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			Log.e("Iniciando", "WIFIservice activo");
			isWifi = true;
		}
		else {
			
			Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS); 
	        startActivity(intent);
			Toast.makeText(getApplicationContext(), "No se ha encontrado un proveedor de localizaci�n activo.", Toast.LENGTH_LONG).show();
		}
		
		if (isGPS || isWifi) {
			Log.e("Iniciando", "Lanzando App");
			TimerTask task = new TimerTask() {
				/* Timer para definir tiempo de espera antes de lanzar la pantalla principal. */
				@Override
				public void run() {
					//Iniciamos la actividad de mapa y obtencion de datos
					Intent intent = new Intent().setClass(LunchActivity.this, MainActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.zoom_splash_out, R.anim.zoom_splash);
					finish();
				}
			};
			
			Timer timer = new Timer();
			timer.schedule(task, 3000);
		}
		else {
			Log.e("Error", "No hay servicios");
		}
	}
}
