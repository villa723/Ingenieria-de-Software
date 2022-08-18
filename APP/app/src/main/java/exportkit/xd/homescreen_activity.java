
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		scooby_attendance
	 *	@date 		1628645649981
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package exportkit.xd;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;

public class homescreen_activity extends Activity {

	
	private View _bg__homescreen_ek2;
	private View _ellipse_15;
	private TextView cargando;
	private View ellipse_16;
	private TextView scooby_attendance;
	private ImageView logodog_4_ek1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);

		
		_bg__homescreen_ek2 = (View) findViewById(R.id._bg__homescreen_ek2);
		_ellipse_15 = (View) findViewById(R.id._ellipse_15);
		cargando = (TextView) findViewById(R.id.cargando);
		ellipse_16 = (View) findViewById(R.id.ellipse_16);
		scooby_attendance = (TextView) findViewById(R.id.scooby_attendance);
		logodog_4_ek1 = (ImageView) findViewById(R.id.logodog_4_ek1);
	
		
		_ellipse_15.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___24_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	