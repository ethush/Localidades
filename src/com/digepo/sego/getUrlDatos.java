package com.digepo.sego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class getUrlDatos extends AsyncTask<String, String, String> {

	/** Variable para recibir la respuesta del servidor. */
	String data = null;
	
	/** Variable para formar la URL de petición. */
	String req = null;
	
	int rubro;
	protected String doInBackground(String... param) {
		
		// Servidor de producción.
		String _HOST = "";
				
		//if uses android emulator also in hardware device
		//String _HOST = "http://10.0.2.2/";
		
		//if uses Genymotion emulator
		//String _HOST = "http://10.0.3.2/";
			
		String _ROOT = "digepo_SIG";
		
		
		String _SCRIPT = null;
			

		/** MCrypt mcrypt_a: Clase para codificación de valores. @see MCrypt */
		//MCrypt mcrypt_a = new MCrypt();
		
		/*
		 * Encripta los valores a pasar por la URL, ocasionalmente los municipios solicitados no
		 * son devueltos con vecindarios, en caso de venir vacios se les asigna el valor "Dalvik"
		 * tambien es posible que el municipio esta vacío y ocurre la misma asignación, asi 
		 * se previene una malformación de datos en la url o una petición errónea.
		 *
		 *  1. Poblacion --se incluye marginación
		 *  2. Vivienda
		 *  3. Educacion
		 *  4. Economia -- Esto incluye el script economia_distribución
		 *  5. Mortalidad
		 *  6. Limitaciones
		 *  7. Salud (derechoabiencia)
		 *  8. Religion
		 *  9. Lengua indigena
		 *  10. Migracion.
		 *  11. Situacion Conyugal
		 */
		
		switch(Integer.parseInt(param[1])) {
			case 1: _SCRIPT = "poblacion.php";
				break;
			case 2: _SCRIPT = "vivienda.php";
				break;
			case 3: _SCRIPT = "educacion.php";
				break;
			case 4: _SCRIPT = "economia.php"; 
				break; 
			case 5: _SCRIPT = "natalidad_mortalidad.php";
				break;
			case 6: _SCRIPT = "limitaciones.php";
				break;
			case 7: _SCRIPT ="derechohabiencia.php";
				break; 
			case 8: _SCRIPT = "religion.php";
				break;
			case 9: _SCRIPT = "lengua.php";
				break;
			case 10: _SCRIPT = "migracion.php";
				break;	
			case 11: _SCRIPT = "situacion.php";
				break;	
		}
		//Log.e("parametros", param[0].toString());
		req = _HOST + "/" + _ROOT + "/" + _SCRIPT + "?id="+param[0].toString();
		//Log.e("URL_datos", req);
				
		try { 
			data = getHTTPJSON(req);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	
	/**
	 * Se obtiene JSON de los detalles del municipio.
	 *
	 * @param strUrl String. URL de petición de datos
	 * @return String. Cadena JSON en formato plano para convertir a JSONObject
	 * @throws IOException Alerta de I/O por si ocurre un error durante el proceso de petición.
	 * @exception Exception Puede ocurrir si el servidor no esta disponible o no responde, fallas en la conexion, 
	 *            o no se tiene conexión a internet.
	 */
	protected String getHTTPJSON(String strUrl) throws IOException{
    	/**String data: Variable para almacenar la respuesta JSON en formato plano */
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
