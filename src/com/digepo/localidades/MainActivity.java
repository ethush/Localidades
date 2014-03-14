package com.digepo.localidades;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import android.os.AsyncTask;
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
    LatLng posicion;
    LocationManager locacionMngr = null;
    //coordenadas y cariable de posicion para mapa
    Double latitude, longitude;
    //Variables para obtencion de informacion de la localidad 
    String localidad = "", vecindario = "";
    ProgressDialog pDialog;
    Button btnmenu;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        btnmenu = (Button)findViewById(R.id.showMenu);
        btnmenu.setVisibility(View.GONE);
        btnmenu.setVisibility(0);
        ConnectivityManager conMngr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = conMngr.getActiveNetworkInfo();
		
		if(netInfo != null  && netInfo.isConnectedOrConnecting()) {
			if(netInfo.getType() == ConnectivityManager.TYPE_MOBILE)
				Toast.makeText(this, "Usando 3G", Toast.LENGTH_SHORT).show();
			if(netInfo.getType() == ConnectivityManager.TYPE_WIFI)
				Toast.makeText(this, "Usando WiFi", Toast.LENGTH_SHORT).show();
			
			LocationManager locacionMngr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			//Build the string provider
			if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)){
				//get and show map
					getPosicion();
					
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
						System.exit(0);
					}
				});
				//En caso de estar apagado mostramos un mensaje de invitaciÛn para encenderlo
				AlertDialog popup = alert.create();
				popup.show();
				
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
			Log.e("resume", "cargando");
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
	    // Inflate the menu; this adds items to the action bar if it is present.
	    getMenuInflater().inflate(R.menu.main, menu);
	    return false;
	}
	 
	/*
	 * Funcion para mostrar la actividad de menu*/
	public void showMenu(View v){
		Intent intent = new Intent(this,PoliticalMenuActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}
	
	
	/*
	 * Funcion para obtener latitud y longitud
	 * */
	public void getPosicion(){
		locacionMngr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				
		//btnmenu.setActivated(true);
		 btnmenu.setVisibility(View.VISIBLE);
		//Build the string provider
		if(locacionMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)){
				
				pDialog = ProgressDialog.show(this, "Cargando mapa y datos.", "Por favor, espere.");
				LocationListener listener = new myLocListener();
				locacionMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
				
				
		}
	}
	
	private class myLocListener implements LocationListener{
		@Override
		public void onLocationChanged(Location location) {
			//variales a usar para la obtencion de datos de geolocalizaciÛn.
			latitude = location.getLatitude();
			longitude = location.getLongitude();
			
			DataHandler.latitude = latitude;
			DataHandler.longitude = longitude;
			
			posicion = new LatLng(latitude, longitude);
			
			try{
				if(mapa==null) { //obtenemos e inicializamos el mapa
					mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapa)).getMap();
					
					if(mapa!=null){
						//mapa.setMyLocationEnabled(true);
						
						//posicionamos la camara del mapa
						mapa.moveCamera(CameraUpdateFactory.newLatLng(posicion));
						CameraPosition cameraPosition = new CameraPosition.Builder()
						.target(posicion)
						.zoom(14)
						.bearing(90)
						.build();
						//efecto de zoom si la version de android la soporta.
						mapa.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
					
					}
				}
				//Obtencion de datos de googleapis/maps
				try {
					getLocalidad();
					if (latitude == null && longitude == null){
						Toast.makeText(getApplicationContext(), R.string.no_position, Toast.LENGTH_LONG).show();
						//si existe un error en la obtencion de datos deshabilitamos el boton de informacion
						btnmenu.setVisibility(View.GONE);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
				Log.e("Error render" , ex.toString());
			}
			//deshabilitamos la actualizaciÛn de posiciÛn para evitar mayor consumo de datos al encontrar 
			locacionMngr.removeUpdates(this);
			if(pDialog.isShowing()) pDialog.dismiss();
		}

		@Override
		public void onProviderDisabled(String provider) {}

		@Override
		public void onProviderEnabled(String provider) {}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	}
	
	/*
	 * Funcion para obtener el nombre de la localidad*/
	public void getLocalidad() throws IOException {
		
		TextView nomLocalidad;
		
		//Generamos una asynctask 
		getNombre peticion = new getNombre();
		//y la ejecutamos
		peticion.execute();
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
			
			DataHandler.localidad = localidad;
			DataHandler.vecindario = vecindario;
			/*
			 * if the query does'n return*/
			if(DataHandler.localidad.isEmpty() || DataHandler.vecindario.isEmpty() ){
				
			}
			Log.d("Localidad", "Localidad: " + DataHandler.localidad);
			Log.d("Vecindario", "Vecindario: " + DataHandler.vecindario);
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
	
	/*
	 * Clase para peticion de datos que hereda propiedades AsyncTAsk para peticion de datos y obtener 
	 * datos de la API de Google para obtencion de nombre de municipio (pendiente probar opcion nativa con Geocoder)*/
    private class getNombre extends AsyncTask<String, Integer, String>{
    	
		@Override //Obtenemos los datos de geolocalizacion proporcionados por la api de google en formato JSON
		protected String doInBackground(String... url) {
			String req = "https://maps.googleapis.com/maps/api/geocode/json?";
			String lat = "latlng="+latitude.toString()+","+longitude.toString();
			String sensor = "sensor=false";
			req = req + lat + "&" + sensor;
			//Log.e("Datos",req);
			/*
			 * Formamos la url y la procesamos en una peticion HTTPURLConnection*/
			
			String data = null;
			try { //Procesamos la peticion con la funcion externa getInfo()
				data = getHTTPJSON(req);
				
			} catch (IOException e) {
				e.printStackTrace();
				Log.d("Error de peticion", e.toString());
			}
			//Retornamos los valores ya que la funcion exige un retorno para ser tratado.
			return data;
		}
    }
    
    /*
     * Funcion para peticion HTTP y obtener la informacion, 
     * se obtiene un HTTPResponse y se transformaa cadena.*/
    private String getHTTPJSON(String strUrl) throws IOException{
    	/*
    	 * Variables para manejo y control de la peticion y respuesta*/
    	String data = "";
    	HttpURLConnection urlconnection = null;
    	InputStream inputStream = null;
		BufferedReader br = null;
		try {
			//Encapsulamos la peticion y asi controlar las excepciones de malformacion de datos o de respuesta.
			URL url = new URL(strUrl);
			urlconnection = (HttpURLConnection)url.openConnection();
			urlconnection.connect();
			//Si ha sifo exitoso recolectamos la informacion en un stream generico
			inputStream = urlconnection.getInputStream();
			//y lo pasamos a un buffer de lectura por lineas
			br = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer sb = new StringBuffer();
			String linea = "";
			//Leemos la respuesta
			while((linea = br.readLine()) != null){
				sb.append(linea + "\n");
			}
			//Transformamos los datos a formato String
			br.close();
			data = sb.toString();
		}
		catch(Exception ex){
			ex.printStackTrace();
			Log.d("Error getInfo", ex.toString());
		}
		finally{ //Cerramos y liberamos las conexiones y buffer de lectura.
			inputStream.close();
			urlconnection.disconnect();
		}
    	//Retornamos el valor
		return data;
    }

    public void getDetalles(){
    	
    	/*Obtiene JSON de detalles municipio*/
		getDetallesMunicipio detMunicipio = new getDetallesMunicipio();
		detMunicipio.execute();
		String detalles = null;
		
		try {
			detalles= detMunicipio.get();
			//Log.e("JSON original",detalles);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		try{/*Get and assing to Static Class DataHandler*/
			JSONObject jObjDet = new JSONObject(detalles);
			MCrypt mcrypt = new MCrypt();
			Log.e("PETICION RESULT",jObjDet.getString("result").toString());
			
			String result = jObjDet.getString("result").toString();
			if(result.equals("OK")){ //validation result OK
				//String doc1 = null;
				try {
					DataHandler.doc1 = new String(mcrypt.decrypt(jObjDet.getString("doc1").toString()));
					DataHandler.doc2 = new String(mcrypt.decrypt(jObjDet.getString("doc2").toString()));
					DataHandler.doc3 = new String(mcrypt.decrypt(jObjDet.getString("doc3").toString()));
					DataHandler.doc4 = new String(mcrypt.decrypt(jObjDet.getString("doc4").toString()));
					DataHandler.doc5 = new String(mcrypt.decrypt(jObjDet.getString("doc5").toString()));
					DataHandler.doc6 = new String(mcrypt.decrypt(jObjDet.getString("doc6").toString()));
					DataHandler.doc7 = new String(mcrypt.decrypt(jObjDet.getString("doc7").toString()));
					DataHandler.doc8 = new String(mcrypt.decrypt(jObjDet.getString("doc8").toString()));
					DataHandler.doc9 = new String(mcrypt.decrypt(jObjDet.getString("doc9").toString()));
					DataHandler.doc10 = new String(mcrypt.decrypt(jObjDet.getString("doc10").toString()));
					
					DataHandler.region1 = new String(mcrypt.decrypt(jObjDet.getString("region1").toString()));
					DataHandler.region2 = new String(mcrypt.decrypt(jObjDet.getString("region2").toString()));
					DataHandler.region3 = new String(mcrypt.decrypt(jObjDet.getString("region3").toString()));
					DataHandler.region4 = new String(mcrypt.decrypt(jObjDet.getString("region4").toString()));
					DataHandler.region5 = new String(mcrypt.decrypt(jObjDet.getString("region5").toString()));
					DataHandler.region6 = new String(mcrypt.decrypt(jObjDet.getString("region6").toString()));
					DataHandler.region7 = new String(mcrypt.decrypt(jObjDet.getString("region7").toString()));
					DataHandler.region8 = new String(mcrypt.decrypt(jObjDet.getString("region8").toString()));
					
					DataHandler.url_state = new String(mcrypt.decrypt(jObjDet.getString("url_state").toString()));
					
					DataHandler.municipio= new String(mcrypt.decrypt(jObjDet.getString("municipio").toString()));
					DataHandler.region = new String(mcrypt.decrypt(jObjDet.getString("region")));
					this.setTitle(this.getTitle()+" - "+DataHandler.region);
				} catch (Exception e) {
					e.printStackTrace();
					Log.e("Error decrypt",e.getMessage());
				}
				Log.e("IN DATAhANDLER",DataHandler.doc1);
			}
			else if(result.equals("ERROR")){
				Toast.makeText(this, jObjDet.getString("msg_error"), Toast.LENGTH_SHORT).show();
			}
			else{ 
				Toast.makeText(this, R.string.no_location, Toast.LENGTH_SHORT).show();
			}
				
		}
		catch(JSONException ex){
			ex.printStackTrace();
			Log.d("JSON Exception Municipio", ex.toString());
		}	
    }
    
private class getDetallesMunicipio extends AsyncTask<String, String, String>{
    			
		@Override //Obtenemos los datos de geolocalizacion proporcionados por la api de google en formato JSON
		protected String doInBackground(String... url) {
			String data = null;
			String req = null;
			String xLocalidad="",xVecindario="";
						
			MCrypt mcrypt_a = new MCrypt();
			
			Log.e("dataHandler", DataHandler.localidad);
			//Proceso de encriptaciÛn  de parametros a enviar por la URL
			try { //algunas localidades no tienen vecindario 
				if(!DataHandler.vecindario.isEmpty())
					xVecindario = MCrypt.bytesToHex(mcrypt_a.encrypt(sin_acentos(DataHandler.vecindario)));
				else
					xVecindario = MCrypt.bytesToHex(mcrypt_a.encrypt("Dalvik"));
			} catch (Exception e) {
				e.printStackTrace();
				Log.e("Vecindario", e.getMessage());
			}
			
			try{ //Valida entrada vacia
				if(!DataHandler.localidad.isEmpty())
					xLocalidad = MCrypt.bytesToHex(mcrypt_a.encrypt(sin_acentos(DataHandler.localidad)));
				else
					xLocalidad = MCrypt.bytesToHex(mcrypt_a.encrypt("Dalvik"));
			} catch(Exception e){
				e.printStackTrace();
				Log.e("Localidad", e.getMessage());
			}
			/*
			 * Formamos la url y la procesamos en una peticion HTTPURLConnection*/
			req = DataHandler._HOST + "/" + DataHandler._ROOT + "/" + DataHandler._SCRIPT + "?";
			req +="localidad="+xLocalidad+"&vecindario="+xVecindario;
			Log.e("Datos Peticion",req);
			
			try { //Procesamos la peticion
				data = getHTTPJSON(req);
			} catch (IOException e) {
				e.printStackTrace();
				Log.d("Error de peticion", e.toString());
			}
			//Retornamos los valores ya que la funcion exige un retorno para ser tratado.
			return data;
		}
		/*
		 * FunciÛn para reemplazar caracteres con acentos, el modulo MCrypt no soporta caracteres con acentos
		 * por seguridad de codificaciÛn.
		 * */
		private String sin_acentos(String input) {
			String original = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘uÒ¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹—Á«";
		    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		    String output = input;
		    
		    for (int i=0; i<original.length(); i++) {
		        // Reemplazamos los caracteres especiales.
		        output = output.replace(original.charAt(i), ascii.charAt(i));
		    }
		    
		    //Log.e("Sin acentos", output);
		    return output;
		}
    }
}
