package com.digepo.sego;

import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Class FinderActivity. Pantalla para busqueda de municipios.
 */
public class FinderActivity extends Activity {
	
	/** Control de texto para filtrar la lista de municipios. */
	TextView searchText;
	
	/** Lista con los municipios del estado. */
	ListView lista;
	
	/** Arreglo de datos, contiene los municipios del estado. */
	ArrayAdapter<String> adapter;
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_finder);
		
		/*
		 * TextInput de busqueda
		 * */
		searchText = (EditText)findViewById(R.id.editText1);
		
		/*
		 * ListView para listar los municipios
		 * */
		lista = (ListView)findViewById(R.id.lista);
		
		/*
		 * Se hace la inclusion de <string-array> en el adaptador de datos 
		 */
		adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.product_name,getResources().getStringArray(R.array.municipios));
		/* Se rellena el listview */
		lista.setAdapter(adapter);
		/*
		 * Declaración de eventos para obtener el municipio seleccionado y lanzar la pantalla de información
		 * */ 
		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				/* Obtenemos el objeto que contiene el texto del item seleccionado y se asigna a DataHandler */ 
				Object item = lista.getItemAtPosition(arg2);
				String municipio = item.toString();
				//Log.e("valor",item.toString());
				
				DataHandler.localidad = municipio;
				DataHandler.vecindario = "Centro";
				
				/* Ejecutamos la petición al servidor */
				getDetallesMunicipio detallesMunicipio = new getDetallesMunicipio();
				detallesMunicipio.execute(municipio,"");
				String detalles = null;
				
				/* Y obtenemos los datos */
				try { 
					detalles = detallesMunicipio.get();
					//Log.e("JSON original",detalles);
				} catch (InterruptedException e) {		
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
				
				/* Con los datos los transformamos a json local y se reescribe la clase DataHandler */
				MyUtils utils = new MyUtils();
				utils.parseJSONFinder(getApplicationContext(), detalles);
				
				/* Lanzamos el menu para detalles de Municipio */
				Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
				intent.putExtra("origen", 2); //variable definida para MainActivity reconozca que clase de datos usar.
				startActivity(intent);
			}
			
		});
		
		/* 
		 * esta funcion detecta los cambios de texto y aplica un filtro en el adaptador
		 * para actualizar la lista
		 * */
		searchText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				/* Realiza el filtro en el Listview desde el primer caracter escrito en el cuadro de texto. */
				adapter.getFilter().filter(s); 
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			
			@Override
			public void afterTextChanged(Editable s) {}
		});
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.finder, menu);
		return false;
	}
	
}
