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

/**
 * Clase MenuActivity. Clase para la pantalla de detalles del municipio adquirido.
 */
public class MenuActivity extends Activity {
	
	/**   Botones graf* son usados para controlar la animacion de forma individual y lanzar las pantallas de información showGraf*() . */
	
	Button graf1;
	Button graf2; 
	Button graf3;
	Button graf4;
	Button graf5;
	Button graf6; 
	Button graf7; 
	Button graf8; 
	Button graf9;
	Button graf10; 
	Button graf11; 
	Button boton = null;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu);
		
		/* Botones Graf* Se obtienen las instancias de botones declaradas en la interfaz XML. */
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
		
		
		/*
		 * Se declara el evento setOnClickListener para cada boton,
		 * de esta forma se agrega el efecto de giro 3D proporcionado 
		 * por la clase Flip3dAnimation y lanzar las pantallas de los
		 * indicadores al finalizar la animación.
		 * */
		
		graf1.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				/* Se obtiene el alto y ancho del control. */
				float centerX = graf1.getWidth() / 2.0f;
				float centerY = graf1.getHeight() / 2.0f;
				
				/* Crea una instancia de tipo Flip3dAnimation, se declara el tipo de movimiento y duración. */
				final Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
				
				animador.setDuration(500);
				animador.setFillAfter(true);
								
				animador.setInterpolator(new AccelerateInterpolator());
				
				/* Inicia la animación. */
				arg0.startAnimation(animador);
				
				/* 
				 * Se inicia un timer calculado en el mismo tiempo para iniciar la aplicación,
				 * si no esta presente el efecto no sera visualizado. En el metodo run()
				 * se asigna el boton que fue presionado, al momento de que se presione "back"
				 * se realice la animación contraria y restaurarlo a su posición inicial.
				 * */
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

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
		/**
		 * Cuando se inicia una actividad de indicadores se guarda el estado
		 * del boton, cuando el usuario presiona "back" se hace el efecto inverso 
		 * para restaurar el boton a su posicion original.
		 * */
		if(boton!=null){
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
	 * Actividad usada para mostrar la información correspondiente al municipio que se obtuvo mediante GPS
	 * se usa la clase estatica DataHandler para proporcionar la url de la cual se obtendrá 
	 * la información que mostrara la actividad PDFViewer_Activity
	 * 
	 * */
	/**
	 * Muestra rubro Población.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf1 (View v) {
		//Intent intent = new Intent(this,PDFViewerActivity.class);
		//intent.putExtra("url", DataHandler.doc1);
		
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc1);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 1);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Vivienda.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf2 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc2);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 2);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Fecundidad y mortalidad. --pendiente para el final *****************************
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf3 (View v) {
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.doc3);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Educación.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf4 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc4);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 3);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Economía.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf5 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc5);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 4);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Situación Conyugal. --- pendiente
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf6 (View v) {
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", DataHandler.doc6);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Limitaciones físicas o mentales.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf7 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc7);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 6);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Salud.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf8 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc8);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 7);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Religión.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf9 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc9);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 8);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Lengua indigena.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf10 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc10);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 9);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Migración.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf11 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		intent.putExtra("url", DataHandler.doc10);
		intent.putExtra("id", DataHandler.id);
		intent.putExtra("rubro", 10);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
}
