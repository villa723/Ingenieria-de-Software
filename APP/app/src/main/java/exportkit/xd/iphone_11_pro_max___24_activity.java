
	 
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
import android.content.Context;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import data.Info;

	public class iphone_11_pro_max___24_activity extends Activity {

	
	private View _bg__iphone_11_pro_max___24_ek2;
	private View rectangle_3;
	private TextView ingresar;
	private TextView _registrarse;
	private ImageView rectangle_1;
	private TextView correo_institucional;
	private View line_1;
	private TextView contrase_a;
	private EditText password;
	private View line_1_ek1;
	private EditText alumno_unsa_edu_pe;
	private TextView __olvidaste_tu_contrase_a_;
	private ImageView logodog_2;
	private View _rectangle_12;
	private TextView ingresar_ek1;
	private RequestQueue mQueue;
		private Info api = new Info();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.iphone_11_pro_max___24);

		
		_bg__iphone_11_pro_max___24_ek2 = (View) findViewById(R.id._bg__iphone_11_pro_max___24_ek2);
		rectangle_3 = (View) findViewById(R.id.rectangle_3);
		ingresar = (TextView) findViewById(R.id.ingresar);
		_registrarse = (TextView) findViewById(R.id._registrarse);
		rectangle_1 = (ImageView) findViewById(R.id.rectangle_1);
		correo_institucional = (TextView) findViewById(R.id.correo_institucional);
		line_1 = (View) findViewById(R.id.line_1);
		contrase_a = (TextView) findViewById(R.id.contrase_a);
		password = findViewById(R.id.password);
		line_1_ek1 = (View) findViewById(R.id.line_1_ek1);
		alumno_unsa_edu_pe = findViewById(R.id.alumno_unsa_edu_pe);
		__olvidaste_tu_contrase_a_ = (TextView) findViewById(R.id.__olvidaste_tu_contrase_a_);
		logodog_2 = (ImageView) findViewById(R.id.logodog_2);
		_rectangle_12 = (View) findViewById(R.id._rectangle_12);
		ingresar_ek1 = (TextView) findViewById(R.id.ingresar_ek1);

		mQueue = Volley.newRequestQueue(iphone_11_pro_max___24_activity.this);
	
		
		_registrarse.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___34_activity.class);
				startActivity(nextScreen);
			}
		});
		
		//login
		_rectangle_12.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				login();
			}
		});

	}
		public void login(){
			Map<String, String> params = new HashMap();
			params.put("email", alumno_unsa_edu_pe.getText().toString());
			params.put("password", password.getText().toString());
			final JSONObject parameters = new JSONObject(params);
			JsonObjectRequest pedirtipomarcas = new JsonObjectRequest(Request.Method.POST,api.login,  parameters,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							try {//reading JSON
								if(response.getString("status").equals("ok")){
									Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
									String filename = "id.txt";
									String string= String.valueOf(response.getInt("id"));
									FileOutputStream outputStream;
									try{
										outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
										outputStream.write(string.getBytes());

										outputStream.close();
									}catch (Exception e){
										e.printStackTrace();
									}

									Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___25_activity.class);
									startActivity(nextScreen);
								}
								else{
									Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
								}
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
					}
					, new Response.ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					error.printStackTrace();
				}
			});
			mQueue.add(pedirtipomarcas);
		}
}
	
	