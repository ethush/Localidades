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
 * Clase MenuActivity. Clase para la pantalla de detalles del municipio adquirido.
 */
public class MenuActivity extends Activity {
	
	int origen = 0;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu);
		
		/* 
		 * Obtiene el origen de datos, si es por busqueda o localizacion GPS
		 * 1. Ubicacion por GPS
		 * 2. Municipio por localidad
		 * 
		 */
		
		Bundle bundle = getIntent().getExtras();
		this.origen = bundle.getInt("origen");
		
		
		Button boton1 = (Button) findViewById(R.id.graf1);
		Button boton2 = (Button) findViewById(R.id.graf2);
		Button boton3 = (Button) findViewById(R.id.graf3);
		Button boton4 = (Button) findViewById(R.id.graf4);
		Button boton5 = (Button) findViewById(R.id.graf5);
		Button boton6 = (Button) findViewById(R.id.graf6);
		Button boton7 = (Button) findViewById(R.id.graf7);
		Button boton8 = (Button) findViewById(R.id.graf8);
		Button boton9 = (Button) findViewById(R.id.graf9);
		Button boton10 = (Button) findViewById(R.id.graf10);
		Button boton11 = (Button) findViewById(R.id.graf11);
		
		boton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 showGraf1(arg0);
			}
		});
		
		boton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf2(arg0);
			}
		});
		
		boton3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf3(arg0);
			}
		});
		
		boton4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf4(arg0);
			}
		});
		
		boton5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf5(arg0);
			}
		});
		
		boton6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf6(arg0);
			}
		});
		
		boton7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf7(arg0);
			}
		});
		
		boton8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf8(arg0);
			}
		});
		
		boton9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf9(arg0);
			}
		});
		
		boton10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf10(arg0);
			}
		});
		
		boton11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showGraf11(arg0);
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc1);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc1);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc2);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc2);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
		intent.putExtra("rubro", 2);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra rubro Fecundidad y mortalidad.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void showGraf3 (View v) {
		Intent intent = new Intent(this,DataActivity.class);
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc3);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc3);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
		intent.putExtra("rubro", 5);
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc4);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc4);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc5);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc5);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
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
		Intent intent = new Intent(this,DataActivity.class);
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc6);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc6);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
		intent.putExtra("rubro",11);
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc7);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc7);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc8);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc8);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc9);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc9);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc10);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc10);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
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
		
		if(origen == 1) {
			intent.putExtra("url", DataHandler.doc11);
			intent.putExtra("id", DataHandler.id);
		}
		else if(origen == 2) {
			intent.putExtra("url", DataHandlerFinder.doc11);
			intent.putExtra("id", DataHandlerFinder.id);
			
		}
		
		intent.putExtra("rubro", 10);
		startActivity(intent);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
}
