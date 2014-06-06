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

// TODO: Auto-generated Javadoc
/**
 * Clase PoliticalMenuActivity. Menu para mostrar información de pais, estado, region y busqueda 
 * de municipios.
 */
public class PoliticalMenuActivity extends Activity {

	/** Boton para mostrar el menu PaisActivity. */
	Button pais;
	
	/** Boton para mostrar el menu EstadoActivity */
	Button estado;
	
	/** Boton para mostrar el menu RegionActivity. */
	Button region;
	
	/** Boton para mostrar el menu FinderActivity . */
	Button municipio;
	
	/** Boton para controlar efectos. */
	Button boton = null;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_political_menu);

		/* Se obtienen los botones asignados en el diseño XML. */
		pais =(Button)findViewById(R.id.political);
		estado =(Button)findViewById(R.id.estatal);
		region =(Button)findViewById(R.id.region);
		municipio =(Button)findViewById(R.id.locality);

		/*
		 * Se declara el evento setOnClickListener para cada boton,
		 * de esta forma se agrega el efecto de giro 3D proporcionado 
		 * por la clase Flip3dAnimation y lanzar las pantallas de los
		 * indicadores al finalizar la animación.
		 * */
		pais.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(final View arg0) {
				
				/* Se obtiene el alto y ancho del control. */
				float centerX = pais.getWidth() / 2.0f;
				float centerY = pais.getHeight() / 2.0f;
				
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
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra menu de regiones del estado.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void RegionActivity(View v) {
		Intent intent = new Intent(this,RegionActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
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
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
	}
	
	/**
	 * Muestra la pantalla de busqueda de municipios.
	 *
	 * @param v View. Contexto de la aplicación, requerido para poder declarar el evento.
	 */
	public void MunicipiosActivity(View v) {
		Intent intent = new Intent(this,FinderActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.efecto_1, R.anim.noeffect);
	}

}
