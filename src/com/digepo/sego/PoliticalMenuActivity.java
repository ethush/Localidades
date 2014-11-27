package com.digepo.sego;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

// TODO: Auto-generated Javadoc
/**
 * Clase PoliticalMenuActivity. Menu para mostrar información de pais, estado, region y busqueda 
 * de municipios.
 */
public class PoliticalMenuActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_political_menu);
		
		Button pais = (Button) findViewById(R.id.political);
		Button estado = (Button) findViewById(R.id.estatal);
		Button region = (Button) findViewById(R.id.region);
		Button municipio = (Button) findViewById(R.id.locality);
		
		pais.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PoliticActivity(v);
			}
		});
		
		estado.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EstadoActivity(v);
			}
		});
		
		region.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RegionActivity(v);
			}
		});
		
		municipio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MunicipiosActivity(v);
			}
		});
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.political_menu, menu);
		return false;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, R.anim.efecto_salida_1);
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
	}
	/*
	 * Actividad para mostrar la información o menus correspondientes al municipio, region o estado
	 * 
	 * */
	/**
	 * Muestra menu de información por rubros para el Estado.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void EstadoActivity(View v) {
		Intent intent = new Intent(this,EstadoActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu de regiones del estado.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void RegionActivity(View v) {
		Intent intent = new Intent(this,RegionActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}
	
	/**
	 * Muestra menu de información por rubros para el pais.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void PoliticActivity(View v) {
		Intent intent = new Intent(this,PaisActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
		//overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra la pantalla de busqueda de municipios.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void MunicipiosActivity(View v) {
		Intent intent = new Intent(this,FinderActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}

}
