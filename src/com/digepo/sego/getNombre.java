package com.digepo.sego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;


/**
 * Clase para peticion de datos que hereda propiedades AsyncTAsk para peticion de datos y obtener 
 * datos de la API de Google para obtencion de nombre de municipio.
 **/

public class getNombre extends AsyncTask<String, String, String> {
    	
		/* (non-Javadoc)
		 * @see android.os.AsyncTask#doInBackground(Params[])
		 */
		/**
		 * Ejecución de petición HTTP para consulta de nombre de municipio 
		 * datos de la API de Google para obtencion de nombre de municipio (pendiente probar opcion nativa con Geocoder).
		 *  
		 * @param coordenadas String. Arreglo de valores que recibe AsyncTask (latitud y longitud)
		 * @return data String. JSON en texto plano para convertirlo a JSONObject.
		 * */
		@Override 
		protected String doInBackground(String... coordenadas) {
			
			/** String req: Variable para definir URL de API de Google. */
			String req = "https://maps.googleapis.com/maps/api/geocode/json?";
			
			/** String lat: Variable para formar los parametros. */
			String lat = "latlng="+coordenadas[0]+","+coordenadas[1];
			
			/** String sensor: Definimos si se esta usando un sensor GPS. */
			String sensor = "sensor=false";
			
			req = req + lat + "&" + sensor;
			//Log.e("Datos",req);
			
			/** String data: Variable para tratar los datos recuperados de la peticion. */
			String data = null;
			
			
			try { //Procesamos la peticion con la funcion externa getInfo()
				data = getHTTPJSON(req);
				
			} catch (IOException e) {
				e.printStackTrace();
				//Log.d("Error de peticion", e.toString());
			}
			
			return data;
		}
    
    /**
     * Obtiene la información de petición al servidor de GoogleAPIS.
     *
     * @param strUrl String. URL de petición de datos
	 * @return String. Cadena JSON en formato plano para convertir a JSONObject
	 * @throws IOException Alerta de I/O por si ocurre un error durante el proceso de petición.
	 * @exception Exception Puede ocurrir si el servidor no esta disponible o no responde, fallas en la conexion, 
	 *            o no se tiene conexión a internet.
     */
     protected String getHTTPJSON(String strUrl) throws IOException{
    	
    	/** String data: Variable para almacenar la respuesta JSON en formato plano */
    	String data = "";
    	
    	/** HttpURLConnection urlconnection: Variable de tipo HttpURLConnection para hacer la petición */
    	HttpURLConnection urlconnection = null;
    	
    	/** InputStream inputStream: Variable para almacenar la respuesta del servidor */
    	InputStream inputStream = null;
    	
    	/** BufferedReader br: Variable para almacenar y tratar la respuesta.*/
		BufferedReader br = null;
		
		try {
			/* Creamos la conexión y se ejecuta la petición */
			URL url = new URL(strUrl);
			urlconnection = (HttpURLConnection)url.openConnection();
			urlconnection.connect();
						
			inputStream = urlconnection.getInputStream();
			
			/* Se tratan los datos devueltos y se traducen a String. */
			br = new BufferedReader(new InputStreamReader(inputStream));
			
			StringBuffer sb = new StringBuffer();
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				sb.append(linea + "\n");
			}
			
			br.close();
			
			/* Hecho el tratamiento se almacena en una variable de tipo String. */
			data = sb.toString();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally { 
			/* Cerramos las conexiones. */
			inputStream.close();
			urlconnection.disconnect();
		}

		return data;
    }
}
