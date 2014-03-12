package com.digepo.localidades;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class PoliticalMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_political_menu);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.political_menu, menu);
		return false;
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(0, R.anim.efecto_salida_1);
	}
	
	public void PDFViewer_State(View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.url_state);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void RegionActivity(View v){
		Intent intent = new Intent(this,RegionActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}
	
	public void PoliticActivity(View v){
		Toast.makeText(this, "Funcion no implementada", Toast.LENGTH_LONG).show();
	}
	
	public void MunicipiosActivity(View v){
		Intent intent = new Intent(this,MenuActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}

}
