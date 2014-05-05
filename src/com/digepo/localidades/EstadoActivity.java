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

public class EstadoActivity extends Activity {

	Button graf1, graf2, graf3, graf4, graf5, graf6, graf7, graf8, graf9, graf10, graf11, boton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_estado);
		
		graf1 = (Button)findViewById(R.id.graf1);
		graf2 = (Button)findViewById(R.id.graf2);
		graf3 = (Button)findViewById(R.id.graf3);
		graf4 = (Button)findViewById(R.id.graf4);
		graf5 = (Button)findViewById(R.id.graf5);
		graf6 = (Button)findViewById(R.id.graf6);
		graf7 = (Button)findViewById(R.id.graf7);
		graf8 = (Button)findViewById(R.id.graf8);
		graf9 = (Button)findViewById(R.id.graf9);
		graf10 = (Button)findViewById(R.id.graf10);
		graf11 = (Button)findViewById(R.id.graf11);
		
		graf1.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = graf1.getWidth() / 2.0f;
				float centerY = graf1.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = graf1;
						showGraf1(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		graf2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = graf2.getWidth() / 2.0f;
				float centerY = graf2.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = graf2;
						showGraf2(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		graf3.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = graf3.getWidth() / 2.0f;
				float centerY = graf3.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = graf3;
						showGraf3(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
		graf4.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = graf4.getWidth() / 2.0f;
				float centerY = graf4.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = graf4;
						showGraf4(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});

			graf5.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				float centerX = graf5.getWidth() / 2.0f;
				float centerY = graf5.getHeight() / 2.0f;
				
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				arg0.startAnimation(animador);
				Timer t = new Timer();
				TimerTask tTask = new TimerTask() {
					
					@Override
					public void run() {
						boton = graf5;
						showGraf5(arg0);					
					}
				};
				
				t.schedule(tTask,250);
				
			}
		});
		
			graf6.setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(final View arg0) {
					
					float centerX = graf6.getWidth() / 2.0f;
					float centerY = graf6.getHeight() / 2.0f;
					
					Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
					
					animador.setDuration(500);
					animador.setFillAfter(true);
									
					animador.setInterpolator(new AccelerateInterpolator());
					
					arg0.startAnimation(animador);
					Timer t = new Timer();
					TimerTask tTask = new TimerTask() {
						
						@Override
						public void run() {
							boton = graf6;
							showGraf6(arg0);					
						}
					};
					
					t.schedule(tTask,250);
					
				}
			});
			
			graf7.setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(final View arg0) {
					
					float centerX = graf7.getWidth() / 2.0f;
					float centerY = graf7.getHeight() / 2.0f;
					
					Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
					
					animador.setDuration(500);
					animador.setFillAfter(true);
									
					animador.setInterpolator(new AccelerateInterpolator());
					
					arg0.startAnimation(animador);
					Timer t = new Timer();
					TimerTask tTask = new TimerTask() {
						
						@Override
						public void run() {
							boton = graf7;
							showGraf7(arg0);					
						}
					};
					
					t.schedule(tTask,250);
					
				}
			});
			
			graf8.setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(final View arg0) {
					
					float centerX = graf8.getWidth() / 2.0f;
					float centerY = graf8.getHeight() / 2.0f;
					
					Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
					
					animador.setDuration(500);
					animador.setFillAfter(true);
									
					animador.setInterpolator(new AccelerateInterpolator());
					
					arg0.startAnimation(animador);
					Timer t = new Timer();
					TimerTask tTask = new TimerTask() {
						
						@Override
						public void run() {
							boton = graf8;
							showGraf8(arg0);					
						}
					};
					
					t.schedule(tTask,250);
					
				}
			});
			
			graf9.setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(final View arg0) {
					
					float centerX = graf9.getWidth() / 2.0f;
					float centerY = graf9.getHeight() / 2.0f;
					
					Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
					
					animador.setDuration(500);
					animador.setFillAfter(true);
									
					animador.setInterpolator(new AccelerateInterpolator());
					
					arg0.startAnimation(animador);
					Timer t = new Timer();
					TimerTask tTask = new TimerTask() {
						
						@Override
						public void run() {
							boton = graf9;
							showGraf9(arg0);					
						}
					};
					
					t.schedule(tTask,250);
					
				}
			});
			
			graf10.setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(final View arg0) {
					
					float centerX = graf10.getWidth() / 2.0f;
					float centerY = graf10.getHeight() / 2.0f;
					
					Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
					
					animador.setDuration(500);
					animador.setFillAfter(true);
									
					animador.setInterpolator(new AccelerateInterpolator());
					
					arg0.startAnimation(animador);
					Timer t = new Timer();
					TimerTask tTask = new TimerTask() {
						
						@Override
						public void run() {
							boton = graf10;
							showGraf10(arg0);					
						}
					};
					
					t.schedule(tTask,250);
					
				}
			});
			graf11.setOnClickListener(new Button.OnClickListener() {
				
				@Override
				public void onClick(final View arg0) {
					
					float centerX = graf11.getWidth() / 2.0f;
					float centerY = graf11.getHeight() / 2.0f;
					
					Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
					
					animador.setDuration(500);
					animador.setFillAfter(true);
									
					animador.setInterpolator(new AccelerateInterpolator());
					
					arg0.startAnimation(animador);
					Timer t = new Timer();
					TimerTask tTask = new TimerTask() {
						
						@Override
						public void run() {
							boton = graf11;
							showGraf11(arg0);					
						}
					};
					
					t.schedule(tTask,250);
					
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.estado, menu);
		return false;
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		
		overridePendingTransition(0, R.anim.efecto_salida_1);
	}
	
	@Override
	protected void onResume() {
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
	
	public void showGraf1 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc1);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf2 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc2);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf3 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc3);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf4 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc4);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf5 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc5);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf6 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc6);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf7 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc7);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf8 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc8);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf9 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc9);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf10 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc10);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	public void showGraf11 (View v){
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.estado_doc11);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}

}
