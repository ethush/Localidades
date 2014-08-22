/*
 * 
 */
package com.digepo.localidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Clase: getDetallesMunicipio. Obtiene las rutas de datos del servidor en formato JSON plano para convertir en JSONObject.
 * 
 */
public class getDetallesMunicipio extends AsyncTask<String, String, String>{
	
	/** Variable para recibir la respuesta del servidor. */
	String data = null;
	
	/** Variable para formar la URL de peticiÛn. */
	String req = null;
	
	/** Variable para almacenar los valores encriptados de municipio. */
	String xLocalidad="";

	/** Variable para almacenar los valores encriptados de vecindario. */
	String xVecindario="";
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	/**
	 * @param url String. Recibe los nombres de municipio y vecindario para codificar
	 * @return data String. devuelve cadena JSON para convertir en JSONObject
	 * 
	 */
	@Override 
	protected String doInBackground(String... url) {
		// Servidor de producciÛn.
		//String _HOST = "http://www.gioax.com.mx";
		
		//if uses android emulator also in hardware device
		//String _HOST = "http://10.0.2.2/";
		
		//if uses Genymotion emulator
		String _HOST = "http://10.0.3.2/";
		
		String _ROOT = "digepo_SIG";
		String _SCRIPT = "data.php";
		

		/** MCrypt mcrypt_a: Clase para codificaciÛn de valores. @see MCrypt */
		MCrypt mcrypt_a = new MCrypt();
		
		/*
		 * Encripta los valores a pasar por la URL, ocasionalmente los municipios solicitados no
		 * son devueltos con vecindarios, en caso de venir vacios se les asigna el valor "Dalvik"
		 * tambien es posible que el municipio esta vacÌo y ocurre la misma asignaciÛn, asi 
		 * se previene una malformaciÛn de datos en la url o una peticiÛn errÛnea.
		 */
		try { 
			if(!url[1].isEmpty()) {
				xVecindario = MCrypt.bytesToHex(mcrypt_a.encrypt(sin_acentos(url[1])));
				//xVecindario = MCrypt.bytesToHex(mcrypt_a.encrypt(url[1].toString()));
				//Log.e("sin acentos_1", url[1]);
			}
			else {
				xVecindario = MCrypt.bytesToHex(mcrypt_a.encrypt("Dalvik"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{ 
			if(!url[0].isEmpty()) {
				xLocalidad = MCrypt.bytesToHex(mcrypt_a.encrypt(sin_acentos(url[0])));
				//xLocalidad = MCrypt.bytesToHex(mcrypt_a.encrypt(url[0].toString()));
				//Log.e("sin acentos_0", url[0]);
			}
			else {
				xLocalidad = MCrypt.bytesToHex(mcrypt_a.encrypt("Dalvik"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		/*
		 * Se forma la URL con las variables codificadas antes de procesar la solicitud con la funcion getHTTPJSON
		 */
		
		req = _HOST + "/" + _ROOT + "/" + _SCRIPT + "?";
		req +="localidad="+xLocalidad+"&vecindario="+xVecindario;
		Log.e("URL_MUNICIPIOS", req);
		
		try { 
			data = getHTTPJSON(req);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * Sanitiza una cadena de texto que contenga acentos o tildes.
	 *
	 * @param  input String. Cadena a tratar 
	 * @return output String. Cadena limpia
	 */
	private String sin_acentos(String input) {
		String original = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘uÒ¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹—Á«";
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
	
	/**
	 * Se obtiene JSON de los detalles del municipio.
	 *
	 * @param strUrl String. URL de peticiÛn de datos
	 * @return String. Cadena JSON en formato plano para convertir a JSONObject
	 * @throws IOException Alerta de I/O por si ocurre un error durante el proceso de peticiÛn.
	 * @exception Exception Puede ocurrir si el servidor no esta disponible o no responde, fallas en la conexion, 
	 *            o no se tiene conexiÛn a internet.
	 */
	protected String getHTTPJSON(String strUrl) throws IOException{
    	/**String data: Variable para almacenar la respuesta JSON en formato plano */
    	String data = "";
    	
    	/** HttpURLConnection urlconnection: Variable de tipo HttpURLConnection para hacer la peticiÛn */
    	HttpURLConnection urlconnection = null;
    	
    	/** InputStream inputStream: Variable para almacenar la respuesta del servidor */
    	InputStream inputStream = null;
    	
    	/** BufferedReader br: Variable para almacenar y tratar la respuesta.*/
		BufferedReader br = null;
		
		try {
			/* Creamos la conexiÛn y se ejecuta la peticiÛn */
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
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{ 
			/* Cerramos las conexiones. */
			inputStream.close();
			urlconnection.disconnect();
		}
    	
		return data;
    }
}