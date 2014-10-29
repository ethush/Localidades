package com.digepo.localidades;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;


/**
 * Class MyUtils. Asigna y trata la información recuperada del servidor de datos a la clase DataHandler.
 */
public class MyUtils {

	/**
	 * Parsea  y asigna los datos a la clase DataHandler.
	 *
	 * @param context Context. usese getApplicationContext()
	 * @param detalles String. JSON plano proveniente de la consulta al servidor.
	 * @exception Exception. Ocasionado por valores vacios dentro de un valor o jObjDet esta mal formado.
	 */
	public void parseJSON(Context context,String detalles) {
		
		try {
			/** JSONOBJECT jObjDet: Variable para traducir el formado plano a un JSONObject. */
			JSONObject jObjDet = new JSONObject(detalles);
			
			/** MCrypt mcrypt: Clase para descrifrar el contenido de valores. */
			MCrypt mcrypt = new MCrypt();
			//Log.d("ParseJSON", jObjDet.toString());
			
			
			String result = jObjDet.getString("result").toString();
			if(result.equals("OK")){ //validation result OK
				
				try {//los primeros 11 son los documentos para el municipio detectado
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
					DataHandler.doc11 = new String(mcrypt.decrypt(jObjDet.getString("doc11").toString()));
				
					DataHandler.id= new String(mcrypt.decrypt(jObjDet.getString("id_municipio").toString()));
					DataHandler.municipio= new String(mcrypt.decrypt(jObjDet.getString("municipio").toString()));
					DataHandler.region = new String(mcrypt.decrypt(jObjDet.getString("region")));
					
				} catch (Exception e) {
					e.printStackTrace();
					//Log.e("Error decrypt",e.getMessage());
				}
			}
			else if(result.equals("ERROR")) {
				Toast.makeText(context, jObjDet.getString("msg_error"), Toast.LENGTH_SHORT).show();
			}	
		}
		catch(JSONException ex){
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Parsea  y asigna los datos a la clase DataHandler.
	 *
	 * @param context Context. usese getApplicationContext()
	 * @param detalles String. JSON plano proveniente de la consulta al servidor.
	 * @exception Exception. Ocasionado por valores vacios dentro de un valor o jObjDet esta mal formado.
	 */
	public void parseJSONFinder(Context context,String detalles) {
		
		try {
			/** JSONOBJECT jObjDet: Variable para traducir el formado plano a un JSONObject. */
			JSONObject jObjDet = new JSONObject(detalles);
			
			/** MCrypt mcrypt: Clase para descrifrar el contenido de valores. */
			MCrypt mcrypt = new MCrypt();
			//Log.d("ParseJSON", jObjDet.toString());
			
			
			String result = jObjDet.getString("result").toString();
			if(result.equals("OK")){ //validation result OK
				
				try {//los primeros 11 son los documentos para el municipio detectado
					DataHandlerFinder.doc1 = new String(mcrypt.decrypt(jObjDet.getString("doc1").toString()));
					DataHandlerFinder.doc2 = new String(mcrypt.decrypt(jObjDet.getString("doc2").toString()));
					DataHandlerFinder.doc3 = new String(mcrypt.decrypt(jObjDet.getString("doc3").toString()));
					DataHandlerFinder.doc4 = new String(mcrypt.decrypt(jObjDet.getString("doc4").toString()));
					DataHandlerFinder.doc5 = new String(mcrypt.decrypt(jObjDet.getString("doc5").toString()));
					DataHandlerFinder.doc6 = new String(mcrypt.decrypt(jObjDet.getString("doc6").toString()));
					DataHandlerFinder.doc7 = new String(mcrypt.decrypt(jObjDet.getString("doc7").toString()));
					DataHandlerFinder.doc8 = new String(mcrypt.decrypt(jObjDet.getString("doc8").toString()));
					DataHandlerFinder.doc9 = new String(mcrypt.decrypt(jObjDet.getString("doc9").toString()));
					DataHandlerFinder.doc10 = new String(mcrypt.decrypt(jObjDet.getString("doc10").toString()));
					DataHandlerFinder.doc11 = new String(mcrypt.decrypt(jObjDet.getString("doc11").toString()));
				
					DataHandlerFinder.id= new String(mcrypt.decrypt(jObjDet.getString("id_municipio").toString()));
					DataHandlerFinder.municipio= new String(mcrypt.decrypt(jObjDet.getString("municipio").toString()));
					DataHandlerFinder.region = new String(mcrypt.decrypt(jObjDet.getString("region")));
					
				} catch (Exception e) {
					e.printStackTrace();
					//Log.e("Error decrypt",e.getMessage());
				}
			}
			else if(result.equals("ERROR")) {
				Toast.makeText(context, jObjDet.getString("msg_error"), Toast.LENGTH_SHORT).show();
			}	
		}
		catch(JSONException ex){
			ex.printStackTrace();
		}
	}
}
