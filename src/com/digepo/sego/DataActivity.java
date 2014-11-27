package com.digepo.sego;

import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;


public class DataActivity extends Activity {

	String id_municipio, url_pdf;
	int rubro;
	
	ProgressDialog progress = null;
	
	WebView datos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_data);
		
		Bundle extras = getIntent().getExtras();
		
		if (extras != null) {
			id_municipio = extras.getString("id");
			url_pdf = extras.getString("url");
			rubro = extras.getInt("rubro");
		}
		
		datos = (WebView) findViewById(R.id.datos);
		
		
		//datos.setText("Municipio id:" +id_municipio + "\tURL:" + url_pdf + "\tRubro:" + rubro );
		progress = ProgressDialog.show(this, "Cargando datos.", "Por favor, espere.");
		solicitaDatos();
		progress.dismiss();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data, menu);
		return false;
	}

	
	public void showPDF(View v) {
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.doc10);
		startActivity(intent);
	}
	
	/**
	 *  Función para solicitar los datos en JSON formateado para incrustar en el visor de texto
	 */
	private void solicitaDatos() {
		String datos_demograficos = null;
		
		/* Clase asincrona para peticion de datos */
		getUrlDatos urlDatos = new getUrlDatos();
		urlDatos.execute(this.id_municipio, String.valueOf(this.rubro));
		
		/* Intento de peticion http y asignación de JSON*/
		try {
			datos_demograficos = urlDatos.get();
			//Log.e("Datos Demograficos", datos_demograficos);
			/* Conversion a objeto JSON y asignación al textview */
			JSONObject jsonDatos = new JSONObject(datos_demograficos);
			//datos.setText(Html.fromHtml(jsonDatos.getString("poblacion").toString()));
			datos.loadData(jsonDatos.getString("datos").toString(),"text/html","UTF-8");
		} catch (InterruptedException e) {		
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
}
