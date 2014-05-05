package com.digepo.localidades;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

public class PoliticalMenuActivity extends Activity {

	Bundle savedBundle;
	Button pais, estado, region, municipio, boton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_political_menu);
		savedBundle = savedInstanceState;
		
		pais =(Button)findViewById(R.id.political);
		estado =(Button)findViewById(R.id.estatal);
		region =(Button)findViewById(R.id.region);
		municipio =(Button)findViewById(R.id.locality);
		
		pais.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = pais.getWidth() / 2.0f;
				float centerY = pais.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = pais;
						PoliticActivity(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		estado.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = estado.getWidth() / 2.0f;
				float centerY = estado.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = estado;
						EstadoActivity(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region.getWidth() / 2.0f;
				float centerY = region.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region;
						RegionActivity(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});

		municipio.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = municipio.getWidth() / 2.0f;
				float centerY = municipio.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = municipio;
						MunicipiosActivity(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
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
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(boton!=null){ //Retorna el boton a su estado inicial con un efecto inverso
			float centerX = boton.getWidth() / 2.0f;
			float centerY = boton.getHeight() / 2.0f;
			
			final Flip3dAnimation back_animador = new Flip3dAnimation(180, 0, centerX, centerY);
			
			
			back_animador.setDuration(0);
			back_animador.setFillAfter(true);
							
			back_animador.setInterpolator(new AccelerateInterpolator());
			
			boton.startAnimation(back_animador);
		}
	}
	/*
	 * Actividad para mostrar la información o menus correspondientes al municipio, region o estado
	 * 
	 * */
	public void EstadoActivity(View v){
		Intent intent = new Intent(this,EstadoActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void RegionActivity(View v){
		Intent intent = new Intent(this,RegionActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}
	
	public void PoliticActivity(View v){
		Intent intent = new Intent(this,PaisActivity.class);
		startActivity(intent);
		//overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void MunicipiosActivity(View v){
		Intent intent = new Intent(this,FinderActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}

}
