package com.digepo.localidades;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Clase RegionActivity. Pantalla de regiones del estado.
 */
public class RegionActivity extends Activity {

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_region);
		
		Button region1 = (Button) findViewById(R.id.region1);
		Button region2 = (Button) findViewById(R.id.region2);
		Button region3 = (Button) findViewById(R.id.region3);
		Button region4 = (Button) findViewById(R.id.region4);
		Button region5 = (Button) findViewById(R.id.region5);
		Button region6 = (Button) findViewById(R.id.region6);
		Button region7 = (Button) findViewById(R.id.region7);
		Button region8 = (Button) findViewById(R.id.region8);
		
		region1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion1(arg0);
			}
		});
		
		region2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion2(arg0);
			}
		});
		
		region3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion3(arg0);
			}
		});
		
		region4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion4(arg0);
			}
		});
		
		region5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion5(arg0);
			}
		});
		
		region6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion6(arg0);
			}
		});
		
		region7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion7(arg0);
			}
		});
		
		region8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showRegion8(arg0);
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.region, menu);
		return false;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
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
	
	/**
	 * Muestra menu para rubros de region Cañada.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion1(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 1); 
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu para rubros de region Costa.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion2(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 2);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu para rubros de region Istmo.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion3(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 3);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu para rubros de region Mixteca.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion4(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 4);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu para rubros de region Papaloapam.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion5(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 5);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu para rubros de region Sierra Norte.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion6(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 6);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu para rubros de region Sierra Sur.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion7(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 7);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu para rubros de region Valles Centrales.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showRegion8(View v) {
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 8);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}

}
