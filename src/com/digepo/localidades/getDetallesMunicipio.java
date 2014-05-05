package com.digepo.localidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class getDetallesMunicipio extends AsyncTask<String, String, String>{
	String data = null;
	String req = null;
	String xLocalidad="",xVecindario="";
	
	@Override //Obtenemos los datos de geolocalizacion proporcionados por la api de google en formato JSON
	protected String doInBackground(String... url) {
		String _HOST = "http://www.gioax.com.mx";
		//if uses android emulator also in ahrdware device
		//String _HOST = "http://10.0.2.2/";
		//if uses Genymotion emulator
		//String _HOST = "http://10.0.3.2/";
		String _ROOT = "digepo_SIG";
		String _SCRIPT = "data.php";
					
		MCrypt mcrypt_a = new MCrypt();
		
		//Proceso de encriptaciÛn  de parametros a enviar por la URL
		try { //algunas localidades no tienen vecindario 
			//if(!DataHandler.localidad.isEmpty())
			if(!url[1].isEmpty())
				xVecindario = MCrypt.bytesToHex(mcrypt_a.encrypt(sin_acentos(url[1])));
			else
				xVecindario = MCrypt.bytesToHex(mcrypt_a.encrypt("Dalvik"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{ //Valida entrada vacia
			//if(!DataHandler.vecindario.isEmpty())
			if(!url[0].isEmpty())
				xLocalidad = MCrypt.bytesToHex(mcrypt_a.encrypt(sin_acentos(url[0])));
			else
				xLocalidad = MCrypt.bytesToHex(mcrypt_a.encrypt("Dalvik"));
		} catch(Exception e){
			e.printStackTrace();
		}
		/*
		 * Formamos la url y la procesamos en una peticion HTTPURLConnection*/
		req = _HOST + "/" + _ROOT + "/" + _SCRIPT + "?";
		req +="localidad="+xLocalidad+"&vecindario="+xVecindario;
		//Log.e("Datos Peticion",req);
		
		try { //Procesamos la peticion
			data = getHTTPJSON(req);
		} catch (IOException e) {
			e.printStackTrace();
			//Log.d("Error de peticion", e.toString());
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
	    return output;
	}
	
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