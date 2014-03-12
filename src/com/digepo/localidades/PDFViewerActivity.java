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

	ProgressDialog progress;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pdfviewer);
		
		String myurl = null;
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			myurl = extras.getString("url");
		}
		
		progress = ProgressDialog.show(this, "Cargando...", "Por favor, espere.");
		
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
                 	progress.dismiss();
                 }
            }
            
		});
		
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
