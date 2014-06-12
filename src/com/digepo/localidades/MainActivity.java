package com.digepo.localidades;

import java.io.IOException;
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
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import android.widget.TextView;

/**
 * Class MainActivity.
 */
public class MainActivity extends Activity{

	/* The back. */
	boolean back;
	
	/* The is gp senabled. */
	boolean isGPSenabled = false;

	/* The mapa. */
	GoogleMap mapa;
	
    /* The locacion mngr. */
    LocationManager locacionMngr = null;
    
    /* The net info. */
    NetworkInfo netInfo = null;
    
    /* The longitude. */
    Double latitude , longitude;
    
    /* The vecindario. */
    String localidad = "", vecindario = "";
    
    /* The p dialog. */
    ProgressDialog pDialog;
    
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*
         * Aquiere los recursos para localizacion y de red
         * */
        ConnectivityManager conMngr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		netInfo = conMngr.getActiveNetworkInfo();
		locacionMngr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		/* Si existe una conexion iniciamos los procedimientos necesarios para busqueda y renderizado del mapa. */ 
		if(netInfo != null  && netInfo.isConnectedOrConnecting()) {
			
			if(netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
				Toast.makeText(this, "Usando 3G - GPS", Toast.LENGTH_SHORT).show();
				Log.d("CONEXION", "POR GPS");
				if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
					locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				} 
				
				else{ 
					/** Validamos los mensajes en caso de que el GPS este apagado. */
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
					/* En caso de estar apagado mostramos un mensaje de invitación para encenderlo */
					AlertDialog popup = alert.create();
					popup.show();
					
				}
			}
			/* Si es una red WIFI intentamos acceder a la ubicación por medio de IP */
			else if(netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
				Toast.makeText(this, "Usando WIFI", Toast.LENGTH_SHORT).show();
				//Log.d("CONEXION", "POR WIFI");
				
				 if(locacionMngr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
				
					 if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
							
							LocationListener listener = new myLocListener();
							locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
							locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					 }
					 else {
							LocationListener listener = new myLocListener();
							locacionMngr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 200, listener);
							locacionMngr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
					 }
				}
				else {
					Toast.makeText(getApplicationContext(), "No se encontro el servicio de localizaicón activo. \n Intente de forma manual.", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
					startActivity(intent);
				}
			}
		}
		else{
			Toast.makeText(this, R.string.no_data_connection, Toast.LENGTH_LONG).show();
		}

    }
	/*
	 * Validación de doble pulsación en el boton "back" para cerrar la aplicación
	 * y para evitar cierres accidentales.
	 * */
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
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
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		/*
		 * Si la aplicación detecta que el GPS esta apagado, y este se activa se reanuda la busqueda por GPS
		 * la validación comprueba si el GPS esta activo para realizar funciones de geolocalización.
		 * */
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
	
	 /* (non-Javadoc)
 	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
 	 */
 	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    return false;
	}
	 
	
	/**
	 * Muestra el menu politico: Pais, estado, regiones y buscador de municipios.
	 *
	 * @param v the v
	 */
	public void showMenu(View v){
		Intent intent = new Intent(this,PoliticalMenuActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}
	
	
	/**
	 * Muestra el menu municipio.
	 *
	 * @param v Requerido para el contexto de la aplicacion
	 */
	public void showMenuMunicipio(View v){
		Intent intent = new Intent(this,MenuActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	
	
	/**
	 * Obtiene la posición geografica ya sea por GPS o WIFI al momento de reiniciar la pantalla.
	 *
	 * @return void.
	 */
	public void getPosicion(){
				
		/** Si esta usando red movil se usa GPS. */
		if(netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			Toast.makeText(this, "Usando 3G - GPS", Toast.LENGTH_SHORT).show();
			
			if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
				locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			} 
			
			else { //Validamos los mensajes en caso de que el GPS este apagado
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
				
				AlertDialog popup = alert.create();
				popup.show();
				
			}
		}
		
		if(netInfo.getType() == ConnectivityManager.TYPE_WIFI){
			Toast.makeText(this, "Usando WIFI", Toast.LENGTH_SHORT).show();
		/*
			
			*/
			if(locacionMngr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
				if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);	
					locacionMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				}
				else {
					LocationListener listener = new myLocListener();
					locacionMngr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 200, listener);
					locacionMngr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				}
			}
			else {
				Toast.makeText(getApplicationContext(), "No se encontro el servicio de localizaicón activo. \n Intente de forma manual.", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
				startActivity(intent);
			}
		}		
	}
	
	/**
	 * Interface creada para manipular eventos de la clase LocationListener .
	 * 
	 * Clase hecha para controlar eventos y registros de localización
	 * GPS ó WIFI, esta registra los componentes usados por LocationListener
	 * Cuando un evento de localización ocurre se inicia la funcion apropiada
	 * @see LocationListener
	 */
	private class myLocListener implements LocationListener {
		/* Valida si se tienen las coordenadas para no volverlas a solicitar. */
		Boolean LatLongAcq = false;
		Integer intentos = 0;
		
		/* (non-Javadoc)
		 * @see android.location.LocationListener#onLocationChanged(android.location.Location)
		 */
		@Override
		public void onLocationChanged(Location location) {
			
			/* Variable usada para almacenar geoposicionamiento y usarlo para el componente GoogleMaps */
			LatLng posicion = null;
			
			try {
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				
				if(latitude !=null && longitude !=null) {
					LatLongAcq = true;
					//Toast.makeText(getApplicationContext(), latitude +" --- "+ longitude, Toast.LENGTH_SHORT).show();
					Log.e("Posicion", latitude +" --- "+ longitude);
					DataHandler.latitude = latitude;
					DataHandler.longitude = longitude;
				
					posicion = new LatLng(latitude, longitude);
					
					/* Cancela las peticiones y libera la variable. */
					locacionMngr.removeUpdates(this);
					locacionMngr = null;
				}
				else {
					intentos++;
					//Log.d("Intentos", "Intentos: "+intentos.toString());
					if(intentos==10){
						Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
						startActivity(intent);
					}
				}
			}
			catch (Exception e) {
				Toast.makeText(getApplicationContext(), "No se ha logrado adquirir una ubicación." + e.getCause().toString(), Toast.LENGTH_SHORT).show();
			}
			
			/* Se renderiza el mapa. */
			try{
				if(mapa==null && LatLongAcq) {
					mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapa)).getMap();
					
					if(mapa!=null) {
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
				Log.e("Error al renderizar mapa." , ex.toString());
			}
			
			try {
				if(LatLongAcq) {
					/*
					 * Obtencion de datos de googleapis/maps en caso de no tener las variables
					 * de latitud y longitud se inicia la pantalla para busqueda manual.
					 * */
					
					getLocalidad();
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			/* Deshabilitamos la actualización de posición para evitar mayor consumo de datos y bateria. */
			
			
		}

		/* (non-Javadoc)
		 * @see android.location.LocationListener#onProviderDisabled(java.lang.String)
		 */
		@Override
		public void onProviderDisabled(String provider) {}

		/* (non-Javadoc)
		 * @see android.location.LocationListener#onProviderEnabled(java.lang.String)
		 */
		@Override
		public void onProviderEnabled(String provider) {}

		/* (non-Javadoc)
		 * @see android.location.LocationListener#onStatusChanged(java.lang.String, int, android.os.Bundle)
		 */
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	} //end myLocListener
	
	
	/**
	 * Obtiene el nombre de la localidad usando GoogleApis para geocode.
	 *
	 * @return void
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void getLocalidad() throws IOException {
		
		/* Control para mostrar el vecindario o colonia en la que se encuentra. */
		TextView nomLocalidad;
		
		/* Variable para almacenar el resultado en JSON devuelto por la clase getNombre*/
		String data = null;
		
		/* Se instancia una clase derivada de AsyncTask para obtener el nombre de la localidad. */
		getNombre peticion = new getNombre();
		peticion.execute(latitude.toString(),longitude.toString());
				
		
		try { 
			data = peticion.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		/*
		 * Con el JSON en texto plano se convierte a JSONObject para tratamiento adecuado,
		 * de la seccion [results] -> [address_components] se extraen los valores de los
		 * campos "neighborhood" y "locality", estos se usan para hacer la peticion al
		 * servidor remoto y obtener una ruta de datos correspondientes al municipio. 
		 * */
		try {
			
			JSONObject jObj = new JSONObject(data.toString());
			
			/* Se obtiene la coleccion de valores para extraer el nombre de la localidad y la colonia o vecindario. */
			JSONArray array = ((JSONArray)jObj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components"));
			
			/* Se hace uso de la funcion getLocalidades para buscar de forma dinamica los nombres.*/
			vecindario = getLocalidades(array,"neighborhood");
			localidad = getLocalidades(array,"locality");
			
			/* Si las variables resultaran vacías se inicia una busqueda manual.*/
			//Log.d("Valores", localidad + " - " + vecindario);
			if(vecindario.isEmpty() && localidad.isEmpty())	{
				Toast.makeText(getApplicationContext(), "No se ha logrado adquirir información del municipio.", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getApplicationContext(), FinderActivity.class);
				startActivity(intent);
			}
			else{ 
				 /* Agrega el nombre del municipio al titulo de la pantalla. */
				this.setTitle(localidad);
				nomLocalidad = (TextView) findViewById(R.id.localidad);
				nomLocalidad.setText("Vecindario: "+ vecindario);
				
				/* Obtenemos la información detallada del municipio. */
				getDetalles();
			 }
		}
		catch(JSONException ex) {
			ex.printStackTrace();
			//Log.d("JSON Exception Address", ex.toString());
		}
		
	}

	/**
	 * Obtiene valores especificos de posiciones en arreglos JSON. Nombre de la localidad y vecindario.
	 *
	 * @param array JSONArray. Arreglo JSON.
	 * @param param String. Parametro a filtrar.
	 * @return String. Valor definido por la variable param.
	 * @throws JSONException the JSON exception
	 */
	private String getLocalidades(JSONArray array, String param ) throws JSONException {
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
	
	

    /**
     * Obtiene los detalles del municipio en el servidor y asigna las URL a la clase DataHandler.
     * 
     * @see MyUtils, getDetallesMunicipio
     * @return void
     */
    public void getDetalles(){
    	
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
		
		/* Asigna los datos obtenidos */
		MyUtils utils = new MyUtils();
		utils.parseJSON(getApplicationContext(), detalles);
    }

}
