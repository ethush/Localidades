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
 * Clase RegionMenuActivity. Menu de rubros por region.
 */
public class RegionMenuActivity extends Activity {

	/** Variable para obtener la region que se ha seleccionado. */
	static int my_region = 0;
	
	/**
	 * Botones graf* son usados para controlar la animacion de 
	 * forma individual y lanzar las pantallas de información showGraf*() . 
	 * */
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
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_region_menu);

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
				Flip3dAnimation animador = new Flip3dAnimation(0, 180, centerX, centerY);
				
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
			
		/* Obtiene la region del menu RegionActivity. */	
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			my_region = extras.getInt("region");
		}
		//Log.d("Region", String.valueOf(my_region));
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.region_menu, menu);
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
		if(boton!=null) {
			float centerX = boton.getWidth() / 2.0f;
			float centerY = boton.getHeight() / 2.0f;
			
			final Flip3dAnimation back_animador = new Flip3dAnimation(180, 0, centerX, centerY);
			
			
			back_animador.setDuration(0);
			back_animador.setFillAfter(true);
							
			back_animador.setInterpolator(new AccelerateInterpolator());
			
			boton.startAnimation(back_animador);
		}
	}
	
	/**
	 * Obtiene la URL de la region que se ha seleccionado de la clase DataHandler. 
	 * Las rutas estan definidas por region y rubro, la variable obtiene 
	 * el numero de region y el rubro se asigna de acuerdo al boton seleccionado
	 * @see DataHandler
	 * 
	 * @param region Integer. Numero de region enviado desde RegionActivity
	 * @param grafico Integer. Numero de rubro que se ha seleccionado.
	 * @return URL String. Ruta de datos.
	 */
	public String get_url(int region, int grafico){
		
		/* Se obtiene el numero de region y se parsea a String. */
		String _region = String.valueOf(region);
		
		/* Se obtiene el numero de documento y se parsea a String. */
		String _grafico = String.valueOf(grafico);
		
		/* Variable para almacenar la URL que se obtiene de la clase DataHandler. */
		String url = "";
		
		/* 
		 * Variable que concatena los valores de region y grafico para que se compare 
		 * en el selector de casos. 
		 * */
		int valor = Integer.parseInt(_region + _grafico);
		
		switch (valor) {
		case 11:
			url = DataHandler.canada_doc1;
			break;
		case 12:
			url = DataHandler.canada_doc2;
			break;
		case 13:
			url = DataHandler.canada_doc3;
			break;
		case 14:
			url = DataHandler.canada_doc4;
			break;
		case 15:
			url = DataHandler.canada_doc5;
			break;
		case 16:
			url = DataHandler.canada_doc6;
			break;
		case 17:
			url = DataHandler.canada_doc7;
			break;
		case 18:
			url = DataHandler.canada_doc8;
			break;
		case 19:
			url = DataHandler.canada_doc9;
			break;
		case 110:
			url = DataHandler.canada_doc10;
			break;
		case 111:
			url = DataHandler.canada_doc11;
			break;
		case 21:
			url = DataHandler.costa_doc1;
			break;
		case 22:
			url = DataHandler.costa_doc2;
			break;
		case 23:
			url = DataHandler.costa_doc3;
			break;
		case 24:
			url = DataHandler.costa_doc4;
			break;
		case 25:
			url = DataHandler.costa_doc5;
			break;
		case 26:
			url = DataHandler.costa_doc6;
			break;
		case 27:
			url = DataHandler.costa_doc7;
			break;
		case 28:
			url = DataHandler.costa_doc8;
			break;
		case 29:
			url = DataHandler.costa_doc9;
			break;
		case 210:
			url = DataHandler.costa_doc10;
			break;
		case 211:
			url = DataHandler.costa_doc11;
			break;
		case 31:
			url = DataHandler.istmo_doc1;
			break;
		case 32:
			url = DataHandler.istmo_doc2;
			break;
		case 33:
			url = DataHandler.istmo_doc3;
			break;
		case 34:
			url = DataHandler.istmo_doc4;
			break;
		case 35:
			url = DataHandler.istmo_doc5;
			break;
		case 36:
			url = DataHandler.istmo_doc6;
			break;
		case 37:
			url = DataHandler.istmo_doc7;
			break;
		case 38:
			url = DataHandler.istmo_doc8;
			break;
		case 39:
			url = DataHandler.istmo_doc9;
			break;
		case 310:
			url = DataHandler.istmo_doc10;
			break;
		case 311:
			url = DataHandler.istmo_doc11;
			break;
		case 41:
			url = DataHandler.mixteca_doc1;
			break;
		case 42:
			url = DataHandler.mixteca_doc2;
			break;
		case 43:
			url = DataHandler.mixteca_doc3;
			break;
		case 44:
			url = DataHandler.mixteca_doc4;
			break;
		case 45:
			url = DataHandler.mixteca_doc5;
			break;
		case 46:
			url = DataHandler.mixteca_doc6;
			break;
		case 47:
			url = DataHandler.mixteca_doc7;
			break;
		case 48:
			url = DataHandler.mixteca_doc8;
			break;
		case 49:
			url = DataHandler.mixteca_doc9;
			break;
		case 410:
			url = DataHandler.mixteca_doc10;
			break;
		case 411:
			url = DataHandler.mixteca_doc11;
			break;
		case 51:
			url = DataHandler.papaloapam_doc1;
			break;
		case 52:
			url = DataHandler.papaloapam_doc2;
			break;
		case 53:
			url = DataHandler.papaloapam_doc3;
			break;
		case 54:
			url = DataHandler.papaloapam_doc4;
			break;
		case 55:
			url = DataHandler.papaloapam_doc5;
			break;
		case 56:
			url = DataHandler.papaloapam_doc6;
			break;
		case 57:
			url = DataHandler.papaloapam_doc7;
			break;
		case 58:
			url = DataHandler.papaloapam_doc8;
			break;
		case 59:
			url = DataHandler.papaloapam_doc9;
			break;
		case 510:
			url = DataHandler.papaloapam_doc10;
			break;
		case 511:
			url = DataHandler.papaloapam_doc11;
			break;
		case 61:
			url = DataHandler.sierra_norte_doc1;
			break;
		case 62:
			url = DataHandler.sierra_norte_doc2;
			break;
		case 63:
			url = DataHandler.sierra_norte_doc3;
			break;
		case 64:
			url = DataHandler.sierra_norte_doc4;
			break;
		case 65:
			url = DataHandler.sierra_norte_doc5;
			break;
		case 66:
			url = DataHandler.sierra_norte_doc6;
			break;
		case 67:
			url = DataHandler.sierra_norte_doc7;
			break;
		case 68:
			url = DataHandler.sierra_norte_doc8;
			break;
		case 69:
			url = DataHandler.sierra_norte_doc9;
			break;
		case 610:
			url = DataHandler.sierra_norte_doc10;
			break;
		case 611:
			url = DataHandler.sierra_norte_doc11;
			break;
		case 71:
			url = DataHandler.sierra_sur_doc1;
			break;
		case 72:
			url = DataHandler.sierra_sur_doc2;
			break;
		case 73:
			url = DataHandler.sierra_sur_doc3;
			break;
		case 74:
			url = DataHandler.sierra_sur_doc4;
			break;
		case 75:
			url = DataHandler.sierra_sur_doc5;
			break;
		case 76:
			url = DataHandler.sierra_sur_doc6;
			break;
		case 77:
			url = DataHandler.sierra_sur_doc7;
			break;
		case 78:
			url = DataHandler.sierra_sur_doc8;
			break;
		case 79:
			url = DataHandler.sierra_sur_doc9;
			break;
		case 710:
			url = DataHandler.sierra_sur_doc10;
			break;
		case 711:
			url = DataHandler.sierra_sur_doc11;
			break;
		case 81:
			url = DataHandler.valles_centrales_doc1;
			break;
		case 82:
			url = DataHandler.valles_centrales_doc2;
			break;
		case 83:
			url = DataHandler.valles_centrales_doc3;
			break;
		case 84:
			url = DataHandler.valles_centrales_doc4;
			break;
		case 85:
			url = DataHandler.valles_centrales_doc5;
			break;
		case 86:
			url = DataHandler.valles_centrales_doc6;
			break;
		case 87:
			url = DataHandler.valles_centrales_doc7;
			break;
		case 88:
			url = DataHandler.valles_centrales_doc8;
			break;
		case 89:
			url = DataHandler.valles_centrales_doc9;
			break;
		case 810:
			url = DataHandler.valles_centrales_doc10;
			break;
		case 811:
			url = DataHandler.valles_centrales_doc11;
			break;
		default:
			break;
		}
		
		return url;
	}

	/**
	 * Muestra rubro Población.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf1 (View v) {
		startMyActivity(get_url(my_region,1));
	}
	
	/**
	 * Muestra rubro Vivienda.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf2 (View v) {
		startMyActivity(get_url(my_region,2));
	}
	
	/**
	 * Muestra rubro Fecundidad y mortalidad.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf3 (View v) {
		startMyActivity(get_url(my_region,3));
	}
	
	/**
	 * Muestra rubro Educación.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf4 (View v) {
		startMyActivity(get_url(my_region,4));
	}
	
	/**
	 * Muestra rubro Economía.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf5 (View v) {
		startMyActivity(get_url(my_region,5));
	}
	
	/**
	 * Muestra rubro Situación Conyugal.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf6 (View v) {
		startMyActivity(get_url(my_region,6));
	}
	
	/**
	 * Muestra rubro Limitaciones físicas o mentales.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf7 (View v) {
		startMyActivity(get_url(my_region,7));
	}
	
	/**
	 * Muestra rubro Salud.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf8 (View v) {
		startMyActivity(get_url(my_region,8));
	}
	
	/**
	 * Muestra rubro Religión.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf9 (View v) {
		startMyActivity(get_url(my_region,9));
	}
	
	/**
	 * Muestra rubro Lengua indigena.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf10 (View v) {
		startMyActivity(get_url(my_region,10));
	}
	
	/**
	 * Muestra rubro Migración.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf11 (View v) {
		startMyActivity(get_url(my_region,11));
	}
	
	/**
	 * Inicia la pantalla PDFViewer con la url del rubro.
	 *
	 * @param url String. URL de datos adquirida de get_url()
	 */
	public void startMyActivity(String url) {
		
		Intent intent = new Intent(this,PDFViewerActivity.class);
		intent.putExtra("url", url);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
}
