package com.digepo.localidades;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyUtils {

	public void parseJSON(Context context,String detalles){
		try{/*Get and assing to Static Class DataHandler*/
			JSONObject jObjDet = new JSONObject(detalles);
			MCrypt mcrypt = new MCrypt();
			//Log.d("ParseJSON", jObjDet.toString());
			String result = jObjDet.getString("result").toString();
			if(result.equals("OK")){ //validation result OK
				//String doc1 = null;
				try {//los primeros 10 son los documentos para el municipio detectado
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
					
					DataHandler.pais_doc1 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc1").toString()));
					DataHandler.pais_doc2 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc2").toString()));
					DataHandler.pais_doc3 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc3").toString()));
					DataHandler.pais_doc4 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc4").toString()));
					DataHandler.pais_doc5 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc5").toString()));
					DataHandler.pais_doc6 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc6").toString()));
					DataHandler.pais_doc7 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc7").toString()));
					DataHandler.pais_doc8 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc8").toString()));
					DataHandler.pais_doc9 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc9").toString()));
					DataHandler.pais_doc10 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc10").toString()));
					DataHandler.pais_doc11 = new String(mcrypt.decrypt(jObjDet.getString("pais_doc11").toString()));
					
					DataHandler.estado_doc1 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc1").toString()));
					DataHandler.estado_doc2 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc2").toString()));
					DataHandler.estado_doc3 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc3").toString()));
					DataHandler.estado_doc4 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc4").toString()));
					DataHandler.estado_doc5 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc5").toString()));
					DataHandler.estado_doc6 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc6").toString()));
					DataHandler.estado_doc7 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc7").toString()));
					DataHandler.estado_doc8 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc8").toString()));
					DataHandler.estado_doc9 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc9").toString()));
					DataHandler.estado_doc10 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc10").toString()));
					DataHandler.estado_doc11 = new String(mcrypt.decrypt(jObjDet.getString("estado_doc11").toString()));
					
					DataHandler.canada_doc1 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc1").toString()));
					DataHandler.canada_doc2 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc2").toString()));
					DataHandler.canada_doc3 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc3").toString()));
					DataHandler.canada_doc4 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc4").toString()));
					DataHandler.canada_doc5 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc5").toString()));
					DataHandler.canada_doc6 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc6").toString()));
					DataHandler.canada_doc7 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc7").toString()));
					DataHandler.canada_doc8 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc8").toString()));
					DataHandler.canada_doc9 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc9").toString()));
					DataHandler.canada_doc10 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc10").toString()));
					DataHandler.canada_doc11 = new String(mcrypt.decrypt(jObjDet.getString("canada_doc11").toString()));
					
					DataHandler.costa_doc1 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc1").toString()));
					DataHandler.costa_doc2 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc2").toString()));
					DataHandler.costa_doc3 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc3").toString()));
					DataHandler.costa_doc4 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc4").toString()));
					DataHandler.costa_doc5 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc5").toString()));
					DataHandler.costa_doc6 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc6").toString()));
					DataHandler.costa_doc7 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc7").toString()));
					DataHandler.costa_doc8 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc8").toString()));
					DataHandler.costa_doc9 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc9").toString()));
					DataHandler.costa_doc10 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc10").toString()));
					DataHandler.costa_doc11 = new String(mcrypt.decrypt(jObjDet.getString("costa_doc11").toString()));
					
					DataHandler.istmo_doc1 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc1").toString()));
					DataHandler.istmo_doc2 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc2").toString()));
					DataHandler.istmo_doc3 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc3").toString()));
					DataHandler.istmo_doc4 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc4").toString()));
					DataHandler.istmo_doc5 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc5").toString()));
					DataHandler.istmo_doc6 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc6").toString()));
					DataHandler.istmo_doc7 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc7").toString()));
					DataHandler.istmo_doc8 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc8").toString()));
					DataHandler.istmo_doc9 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc9").toString()));
					DataHandler.istmo_doc10 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc10").toString()));
					DataHandler.istmo_doc11 = new String(mcrypt.decrypt(jObjDet.getString("istmo_doc11").toString()));
					
					DataHandler.mixteca_doc1 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc1").toString()));
					DataHandler.mixteca_doc2 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc2").toString()));
					DataHandler.mixteca_doc3 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc3").toString()));
					DataHandler.mixteca_doc4 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc4").toString()));
					DataHandler.mixteca_doc5 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc5").toString()));
					DataHandler.mixteca_doc6 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc6").toString()));
					DataHandler.mixteca_doc7 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc7").toString()));
					DataHandler.mixteca_doc8 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc8").toString()));
					DataHandler.mixteca_doc9 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc9").toString()));
					DataHandler.mixteca_doc10 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc10").toString()));
					DataHandler.mixteca_doc11 = new String(mcrypt.decrypt(jObjDet.getString("mixteca_doc11").toString()));
					
					DataHandler.papaloapam_doc1 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc1").toString()));
					DataHandler.papaloapam_doc2 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc2").toString()));
					DataHandler.papaloapam_doc3 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc3").toString()));
					DataHandler.papaloapam_doc4 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc4").toString()));
					DataHandler.papaloapam_doc5 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc5").toString()));
					DataHandler.papaloapam_doc6 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc6").toString()));
					DataHandler.papaloapam_doc7 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc7").toString()));
					DataHandler.papaloapam_doc8 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc8").toString()));
					DataHandler.papaloapam_doc9 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc9").toString()));
					DataHandler.papaloapam_doc10 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc10").toString()));
					DataHandler.papaloapam_doc11 = new String(mcrypt.decrypt(jObjDet.getString("papaloapam_doc11").toString()));
					
					DataHandler.sierra_norte_doc1 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc1").toString()));
					DataHandler.sierra_norte_doc2 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc2").toString()));
					DataHandler.sierra_norte_doc3 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc3").toString()));
					DataHandler.sierra_norte_doc4 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc4").toString()));
					DataHandler.sierra_norte_doc5 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc5").toString()));
					DataHandler.sierra_norte_doc6 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc6").toString()));
					DataHandler.sierra_norte_doc7 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc7").toString()));
					DataHandler.sierra_norte_doc8 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc8").toString()));
					DataHandler.sierra_norte_doc9 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc9").toString()));
					DataHandler.sierra_norte_doc10 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc10").toString()));
					DataHandler.sierra_norte_doc11 = new String(mcrypt.decrypt(jObjDet.getString("sierra_norte_doc11").toString()));
					
					DataHandler.sierra_sur_doc1 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc1").toString()));
					DataHandler.sierra_sur_doc2 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc2").toString()));
					DataHandler.sierra_sur_doc3 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc3").toString()));
					DataHandler.sierra_sur_doc4 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc4").toString()));
					DataHandler.sierra_sur_doc5 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc5").toString()));
					DataHandler.sierra_sur_doc6 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc6").toString()));
					DataHandler.sierra_sur_doc7 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc7").toString()));
					DataHandler.sierra_sur_doc8 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc8").toString()));
					DataHandler.sierra_sur_doc9 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc9").toString()));
					DataHandler.sierra_sur_doc10 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc10").toString()));
					DataHandler.sierra_sur_doc11 = new String(mcrypt.decrypt(jObjDet.getString("sierra_sur_doc11").toString()));
					
					DataHandler.valles_centrales_doc1 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc1").toString()));
					DataHandler.valles_centrales_doc2 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc2").toString()));
					DataHandler.valles_centrales_doc3 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc3").toString()));
					DataHandler.valles_centrales_doc4 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc4").toString()));
					DataHandler.valles_centrales_doc5 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc5").toString()));
					DataHandler.valles_centrales_doc6 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc6").toString()));
					DataHandler.valles_centrales_doc7 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc7").toString()));
					DataHandler.valles_centrales_doc8 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc8").toString()));
					DataHandler.valles_centrales_doc9 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc9").toString()));
					DataHandler.valles_centrales_doc10 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc10").toString()));
					DataHandler.valles_centrales_doc11 = new String(mcrypt.decrypt(jObjDet.getString("valles_centrales_doc11").toString()));
					//DataHandler.url_state = new String(mcrypt.decrypt(jObjDet.getString("url_state").toString()));
					
					//DataHandler.municipio= new String(mcrypt.decrypt(jObjDet.getString("municipio").toString()));
					DataHandler.region = new String(mcrypt.decrypt(jObjDet.getString("region")));
					//this.setTitle(this.getTitle()+" - "+DataHandler.region);
				} catch (Exception e) {
					e.printStackTrace();
					//Log.e("Error decrypt",e.getMessage());
				}
				//Log.e("IN DATAhANDLER",DataHandler.doc1);
			}
			else if(result.equals("ERROR")){
				Toast.makeText(context, jObjDet.getString("msg_error"), Toast.LENGTH_SHORT).show();
			}
			else{ 
				Toast.makeText(context, R.string.no_location, Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context.getApplicationContext(),FinderActivity.class);
				context.startActivity(intent);
			}
				
		}
		catch(JSONException ex){
			ex.printStackTrace();
			//Log.d("JSON Exception Municipio", ex.toString());
		}
	}
}
