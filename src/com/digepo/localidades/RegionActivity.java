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

public class RegionActivity extends Activity {

	Button region1, region2, region3, region4, region5, region6, region7, region8, boton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_region);
		
		region1 = (Button) findViewById(R.id.region1);
		region2 = (Button) findViewById(R.id.region2);
		region3 = (Button) findViewById(R.id.region3);
		region4 = (Button) findViewById(R.id.region4);
		region5 = (Button) findViewById(R.id.region5);
		region6 = (Button) findViewById(R.id.region6);
		region7 = (Button) findViewById(R.id.region7);
		region8 = (Button) findViewById(R.id.region8);
		
		region1.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region1.getWidth() / 2.0f;
				float centerY = region1.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region1;
						showRegion1(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region2.getWidth() / 2.0f;
				float centerY = region2.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region2;
						showRegion2(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region3.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region3.getWidth() / 2.0f;
				float centerY = region3.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region3;
						showRegion3(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region4.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region4.getWidth() / 2.0f;
				float centerY = region4.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region4;
						showRegion4(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region5.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region5.getWidth() / 2.0f;
				float centerY = region5.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region5;
						showRegion5(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region6.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region6.getWidth() / 2.0f;
				float centerY = region6.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region6;
						showRegion6(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region7.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region7.getWidth() / 2.0f;
				float centerY = region7.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region7;
						showRegion7(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		region8.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = region8.getWidth() / 2.0f;
				float centerY = region8.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = region8;
						showRegion8(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.region, menu);
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
		if(boton!=null){//Retorna el boton a su estado inicial con un efecto inverso
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
	 * Actividad usada para mostrar la información correspondiente a las regiones del estado
	 * se usa la clase estatica DataHandler para proporcionar la region de la cual se obtendrá 
	 * la información que mostrara la actividad PDFViewer_Activity
	 * */
	public void showRegion1(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 1); 
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void showRegion2(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 2);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void showRegion3(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 3);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void showRegion4(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 4);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void showRegion5(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 5);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void showRegion6(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 6);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void showRegion7(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 7);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	public void showRegion8(View v){
		Intent intent = new Intent(this,RegionMenuActivity.class);
		intent.putExtra("region", 8);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}

}
