package com.digepo.localidades;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImgViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img_view);
		
		Bundle extras  = getIntent().getExtras();
		TouchImageView imagen = (TouchImageView) findViewById(R.id.remoteImg);
		
		if(extras != null){
			int grafico = extras.getInt("grafico");
			imagen.setImageDrawable(DataHandler.graph1);
			switch (grafico) {
			case 1:
				
				
				break;

			default:
				break;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.img_view, menu);
		return true;
	}

}
