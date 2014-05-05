package com.digepo.localidades;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import android.widget.TextView;

public class MainActivity extends Activity{
	//declaraciones de mapas y posicionamiento
	boolean back;
	boolean isGPSenabled = false;

	GoogleMap mapa;
	
    LocationManager locacionMngr = null;
    NetworkInfo netInfo = null;
    //coordenadas y cariable de posicion para mapa
    Double latitude, longitude;
    //Variables para obtencion de informacion de la localidad 
    String localidad = "", vecindario = "";
    ProgressDialog pDialog;
    Button btnmenu;
    
    Timer timer = null;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        btnmenu = (Button)findViewById(R.id.showMenu);
        btnmenu.setVisibility(View.GONE);
        btnmenu.setVisibility(0);
        ConnectivityManager conMngr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		netInfo = conMngr.getActiveNetworkInfo();
		
		//Si es una red 3G usamos GPS
		timer = new Timer();
		TimerTask muestraFinder = new TimerTask() {
			
			@Override
			public void run() {
				Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
				startActivity(intent);
			}
		};
		timer.schedule(muestraFinder, 10000);
		//Si existe una conexion 
		if(netInfo != null  && netInfo.isConnectedOrConnecting()) {
			
			locacionMngr = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
			
			if(netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
				Toast.makeText(this, "Usando 3G - GPS", Toast.LENGTH_SHORT).show();
				
				if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
					locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				} 
				
				else if(locacionMngr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {	
					
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
					locacionMngr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				}
				
				else if(locacionMngr.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
					
					
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, listener);
				}
				
				else{ //Validamos los mensajes en caso de que el GPS este apagado
					Toast.makeText(this, R.string.no_gps, Toast.LENGTH_SHORT).show();
					AlertDialog.Builder alert = new AlertDialog.Builder(this);
					alert.setMessage(R.string.no_gps_alert)
					.setCancelable(false)
					.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
							isGPSenabled = true;
						}
						
					})
					.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
							startActivity(intent);
						}
					});
					//En caso de estar apagado mostramos un mensaje de invitación para encenderlo
					AlertDialog popup = alert.create();
					popup.show();
					
				}
			}
			//Si es una red WIFI intentamos acceder a la ubicación por medio de IP
			if(netInfo.getType() == ConnectivityManager.TYPE_WIFI){
				Toast.makeText(this, "Usando WIFI", Toast.LENGTH_SHORT).show();
			
				if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					
					LocationListener listener = new myLocListener();
					Toast.makeText(this, "usando GPS", Toast.LENGTH_SHORT).show();
					locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
					locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				}
				
				else if(locacionMngr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
					
					Toast.makeText(this, "usando WIFI", Toast.LENGTH_SHORT).show();
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
					locacionMngr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				}
				
				else if(locacionMngr.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
					
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, listener);
				}
				
				else{ //Validamos los mensajes en caso de que el GPS este apagado
					Toast.makeText(this, R.string.no_gps, Toast.LENGTH_SHORT).show();
					AlertDialog.Builder alert = new AlertDialog.Builder(this);
					alert.setMessage(R.string.no_gps_alert)
					.setCancelable(false)
					.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
							isGPSenabled = true;
						}
						
					})
					.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
							startActivity(intent);
						}
					});
					//En caso de estar apagado mostramos un mensaje de invitación para encenderlo
					AlertDialog popup = alert.create();
					popup.show();
					
				}
	
			}
		}
		else{
			Toast.makeText(this, R.string.no_data_connection, Toast.LENGTH_LONG).show();
		}

    }
	
	@Override
	public void onBackPressed() {
		if(back){
			super.onBackPressed();
			finish();
			return;
		}
		else {
			back = true;
			Toast.makeText(this, R.string.exit_message, Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	protected void onResume() {
		if(isGPSenabled){
			super.onResume();
			getPosicion();
			isGPSenabled = false;
		}
		else{
			super.onResume();
			
			back= false;
		}
	}
	
	 @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    return false;
	}
	 
	/*
	 * Funcion para mostrar la actividad de menu*/
	public void showMenu(View v){
		Intent intent = new Intent(this,PoliticalMenuActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}
	
	public void showMenuMunicipio(View v){
		Intent intent = new Intent(this,MenuActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	
	/*
	 * Funcion para obtener latitud y longitud
	 * */
	public void getPosicion(){
		//locacionMngr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		//Si es una red 3G usamos GPS
		if(netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			Toast.makeText(this, "Usando 3G - GPS", Toast.LENGTH_SHORT).show();
			
			if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
				locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			} 
			
			else if(locacionMngr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {	
				
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
				locacionMngr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			}
			
			else if(locacionMngr.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
				
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, listener);
				locacionMngr.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
			}
			
			else{ //Validamos los mensajes en caso de que el GPS este apagado
				Toast.makeText(this, R.string.no_gps, Toast.LENGTH_SHORT).show();
				AlertDialog.Builder alert = new AlertDialog.Builder(this);
				alert.setMessage(R.string.no_gps_alert)
				.setCancelable(false)
				.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
						isGPSenabled = true;
					}
					
				})
				.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
						startActivity(intent);
					}
				});
				//En caso de estar apagado mostramos un mensaje de invitación para encenderlo
				AlertDialog popup = alert.create();
				popup.show();
				
			}
		}
		//Si es una red WIFI intentamos acceder a la ubicación por medio de IP
		if(netInfo.getType() == ConnectivityManager.TYPE_WIFI){
			Toast.makeText(this, "Usando WIFI", Toast.LENGTH_SHORT).show();
		
			if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
				locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			}
			
			else if(locacionMngr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
				
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
				locacionMngr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			}
			
			else if(locacionMngr.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
				
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, listener);
				locacionMngr.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
			}
			
			else{ //Validamos los mensajes en caso de que el GPS este apagado
				Toast.makeText(this, R.string.no_gps, Toast.LENGTH_SHORT).show();
				AlertDialog.Builder alert = new AlertDialog.Builder(this);
				alert.setMessage(R.string.no_gps_alert)
				.setCancelable(false)
				.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
						isGPSenabled = true;
					}
					
				})
				.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
						startActivity(intent);
					}
				});
				//En caso de estar apagado mostramos un mensaje de invitación para encenderlo
				AlertDialog popup = alert.create();
				popup.show();
				
			}

		}
	}
	
	private class myLocListener implements LocationListener {
		@Override
		public void onLocationChanged(Location location) {
			
			LatLng posicion = null;
			//variales a usar para la obtencion de datos de geolocalización.
			try {
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				
				DataHandler.latitude = latitude;
				DataHandler.longitude = longitude;
				
				posicion = new LatLng(latitude, longitude);
			}
			catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Sin Latitud" + e.getCause().toString(), Toast.LENGTH_SHORT).show();
			}
			
			//Obtencion de datos de googleapis/maps
			try {
				if (latitude == null && longitude == null) {
					Toast.makeText(getApplicationContext(), R.string.no_position, Toast.LENGTH_LONG).show();
					Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
					startActivity(intent);
				}
				
					getLocalidad();
					timer.cancel();
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			//obtenemos e inicializamos el mapa
			try{
				if(mapa==null) {
					mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapa)).getMap();
					
					if(mapa!=null){
						//mapa.setMyLocationEnabled(true);
						
						//posicionamos la camara del mapa
						mapa.moveCamera(CameraUpdateFactory.newLatLng(posicion));
						CameraPosition cameraPosition = new CameraPosition.Builder()
						.target(posicion)
						.zoom(14)
						.bearing(0)
						.build();
						//efecto de zoom si la version de android la soporta.
						mapa.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
						
					}
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
				Log.e("Error render" , ex.toString());
			}
			//deshabilitamos la actualización de posición para evitar mayor consumo de datos al encontrar 
			locacionMngr.removeUpdates(this);
			//if(pDialog.isShowing()) pDialog.dismiss();
		}

		@Override
		public void onProviderDisabled(String provider) {}

		@Override
		public void onProviderEnabled(String provider) {}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	} //end myLocListener
	
	/*
	 * Funcion para obtener el nombre de la localidad*/
	public void getLocalidad() throws IOException {
		
		TextView nomLocalidad;
		
		//Generamos una asynctask 
		getNombre peticion = new getNombre();
		//y la ejecutamos
		peticion.execute(latitude.toString(),longitude.toString());
		String data = null;
		try { //Se realiza una funcion asincrona para peticion de datos http por restricciones de threads en ejecucion de la aplicacion
			data = peticion.get();
			//Log.e("Respuesta completa", data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		try{
			/*tras obtener los datos los convertimos en un objeto JSon para su tratamiento*/
			JSONObject jObj = new JSONObject(data.toString());
			/* Obtenemos la coleccion de valores de las direcciones para averiguar el nombre de la localidad o municipio y cotejarlas 
			 * en la base de datos en un servidor */
			JSONArray array = ((JSONArray)jObj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components"));
			/*
			 * Proceso de busqueda en el arreglo addres_components para buscar la informacion relacionana al nombre de la localidad
			 * en dos campos de nombre locality o neighborhood y en algunos casos de centro del estado administrative_area_level_1(pendiente)
			 * */
			
			vecindario = getLocalidades(array,"neighborhood");
			localidad = getLocalidades(array,"locality");
			
			/*Validacion en caso que no se encuentre una localidad o vecindario se lanza la busqueda manual*/
			Log.d("Valores", localidad + " - " + vecindario);
			if(vecindario.isEmpty() && localidad.isEmpty())
			{
				Toast.makeText(getApplicationContext(), "No se ha logrado adquirir un municipio. \n Intente de forma manual", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
				startActivity(intent);
			}
			/*
			 * Agrega el nombre de la localidad en la cabecera del mapa
			 * 
			 * */
			this.setTitle(localidad);
			nomLocalidad = (TextView) findViewById(R.id.localidad);
			nomLocalidad.setText("Vecindario: "+ vecindario);
			/*Get detalis info for remote server, returns a URL array*/
			getDetalles();
		}
		catch(JSONException ex){
			ex.printStackTrace();
			Log.d("JSON Exception Address", ex.toString());
		}
		
	}
	/*
	 * Parsea el nombre de localidad y vecindario si existiese en el JSON devuelto por Geocode API
	 * */
	private String getLocalidades(JSONArray array, String param ) throws JSONException{
		int i=0;
		String value = "";
		
		for(i=0;i<array.length();i++){
			JSONObject item = (JSONObject) array.getJSONObject(i);
			if(item.getJSONArray("types").getString(0).equals(param)){
				value = item.getString("long_name");
				break;	
			}	
		}
		return value;
	}
	
	

    public void getDetalles(){
    	
    	/*Obtiene JSON de detalles municipio*/
		//getDetallesMunicipio detMunicipio = new getDetallesMunicipio();
		//detMunicipio.execute();
		getDetallesMunicipio detMunicipio = new getDetallesMunicipio();
		
		detMunicipio.execute(this.localidad,this.vecindario);
    	String detalles = null;
		
		try {
			detalles= detMunicipio.get();
			detMunicipio = null;
			//Log.e("JSON original",detalles);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		MyUtils utils = new MyUtils();
		utils.parseJSON(getApplicationContext(), detalles);
    }


}
