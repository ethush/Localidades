package com.digepo.localidades;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Clase PDFViewerActivity. Pantalla para visualizar documentos PDF mediante el visor de Google
 */
public class PDFViewerActivity extends Activity {
	/*
	 * Actividad que se ocupa de simular un navegador web simple.
	 * Y renderizar documentos PDF
	 * */
	/** Dialogo de progreso mientras se carga el documento PDF. */
	ProgressDialog progress;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pdfviewer);
		
		/* Variable para almacenar la URL enviada */
		String myurl = null;
		
		/* Obtenemos la url que es manejada por la clase estatica DataHandler. */
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			myurl = extras.getString("url");
		}
		
		/* Antes de iniciar la petición al servidor mostramos un popup de progreso. */
		progress = ProgressDialog.show(this, "Cargando PDF.", "Por favor, espere.");
		
		/* Instanciamos el visor web y se habilita javascript, es requerido por el visor de google docs. */
		WebView web = (WebView) findViewById(R.id.webView);
		web.getSettings().setJavaScriptEnabled(true); 
		web.getSettings().setUseWideViewPort(true);
		web.setWebViewClient(new WebViewClient(){
			
			@Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
				
				view.loadUrl(url);
								
                return true;              
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
            	
            	/* Terminada la carga del documento, deshabilitamos el popup de información. */
            	if(progress.isShowing()){
                 	progress.dismiss(); 
                 }
            }
            
		});
		
		/* Seteamos la URL que se va a mostrar, en caso contrario mostramos un mensaje de error.*/
		if(!myurl.isEmpty()){
			web.loadUrl(myurl);
		}
		else{
			web.stopLoading();
			progress.dismiss();
			
			Toast.makeText(getApplicationContext(), R.string.on_load_url_error, Toast.LENGTH_SHORT).show();
		}
			
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pdfviewer, menu);
		return false;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		overridePendingTransition(R.anim.left_in, R.anim.right_out);
	}

}
