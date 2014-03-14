package com.digepo.localidades;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PDFViewerActivity extends Activity {
	/*
	 * Actividad que se ocupa de simular un navegador web simple.
	 * */
	ProgressDialog progress;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pdfviewer);
		
		String myurl = null;
		// Obtenemos la url que es manejada por la clase estatica DataHandler
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			myurl = extras.getString("url");
		}
		//Iniciamos un popup de carga
		progress = ProgressDialog.show(this, "Cargando PDF.", "Por favor, espere.");
		//Instanciamos el visor web y se habilita javascript, es requerido por el visor de google docs
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
            	 if(progress.isShowing()){
                 	progress.dismiss(); //si ha terminado la carga, deshabilitamos el popup de información
                 }
            }
            
		});
		//y cargamos la url
		web.loadUrl(myurl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pdfviewer, menu);
		return false;
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		overridePendingTransition(R.anim.left_in, R.anim.right_out);
	}

}
