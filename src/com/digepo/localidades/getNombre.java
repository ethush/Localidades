package com.digepo.localidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
/*
 * Clase para peticion de datos que hereda propiedades AsyncTAsk para peticion de datos y obtener 
 * datos de la API de Google para obtencion de nombre de municipio (pendiente probar opcion nativa con Geocoder)*/
public class getNombre extends AsyncTask<String, String, String>{
    	
		@Override //Obtenemos los datos de geolocalizacion proporcionados por la api de google en formato JSON
		protected String doInBackground(String... coordenadas) {
			String req = "https://maps.googleapis.com/maps/api/geocode/json?";
			//String lat = "latlng="+latitude.toString()+","+longitude.toString();
			String lat = "latlng="+coordenadas[0]+","+coordenadas[1];
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
				//Log.d("Error de peticion", e.toString());
			}
			//Retornamos los valores ya que la funcion exige un retorno para ser tratado.
			return data;
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
			//Si es exitoso recolectamos la informacion en un stream generico
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
			//Log.d("Error getInfo", ex.toString());
		}
		finally{ //Cerramos y liberamos las conexiones y buffer de lectura.
			inputStream.close();
			urlconnection.disconnect();
		}
    	//Retornamos el valor
		return data;
    }
}
