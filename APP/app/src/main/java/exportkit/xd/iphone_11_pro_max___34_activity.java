
	 
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


import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import data.Info;

	public class iphone_11_pro_max___34_activity extends Activity {

	
	private View _bg__iphone_11_pro_max___34_ek2;
	private TextView registrarse_ek1;
	private TextView login_ek1;
	private ImageView _rectangle_12_ek7;
	private TextView registrarse_ek2;
	private ImageView vector_ek21;
	private ImageView line_1_ek8;
	private ImageView line_1_ek9;
	private TextView nombres;
	private ImageView line_1_ek10;
	private ImageView image_19;
	private TextView celular_ek1;
	private TextView etcelular;
	private TextView cui;
	private TextView dni;
	private TextView etdni;
	private ImageView line_1_ek11;
	private TextView correo_electr_nico_institucional_ek1;
	private TextView etemail;
	private ImageView line_1_ek12;
	private ImageView line_1_ek13;
	private TextView contrase_a_ek2;
	private TextView ciudad_ek1;
	private TextView arequipa_ek1;
	private ImageView vector_ek22;
	private TextView etpassword;
	private ImageView line_1_ek15;
	private TextView etcui;
	private TextView apellidos;
	private TextView etapellidos;
	private TextView etnombres;
	private ImageView line_1_ek16;
	private RequestQueue mQueue;
	private Info api = new Info();
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.iphone_11_pro_max___34);

		
		_bg__iphone_11_pro_max___34_ek2 = (View) findViewById(R.id._bg__iphone_11_pro_max___34_ek2);
		registrarse_ek1 = (TextView) findViewById(R.id.registrarse_ek1);
		login_ek1 = (TextView) findViewById(R.id.login_ek1);
		_rectangle_12_ek7 = (ImageView) findViewById(R.id._rectangle_12_ek7);
		registrarse_ek2 = (TextView) findViewById(R.id.registrarse_ek2);
		vector_ek21 = (ImageView) findViewById(R.id.vector_ek21);
		line_1_ek8 = (ImageView) findViewById(R.id.line_1_ek8);
		line_1_ek9 = (ImageView) findViewById(R.id.line_1_ek9);
		nombres = (TextView) findViewById(R.id.nombres);
		line_1_ek10 = (ImageView) findViewById(R.id.line_1_ek10);
		image_19 = (ImageView) findViewById(R.id.image_19);
		celular_ek1 = (TextView) findViewById(R.id.celular_ek1);
		etcelular = (TextView) findViewById(R.id.etcelular);
		cui = (TextView) findViewById(R.id.cui);
		dni = (TextView) findViewById(R.id.dni);
		etdni = (TextView) findViewById(R.id.etdni);
		line_1_ek11 = (ImageView) findViewById(R.id.line_1_ek11);
		correo_electr_nico_institucional_ek1 = (TextView) findViewById(R.id.correo_electr_nico_institucional_ek1);
		etemail = (TextView) findViewById(R.id.etemail);
		line_1_ek12 = (ImageView) findViewById(R.id.line_1_ek12);
		line_1_ek13 = (ImageView) findViewById(R.id.line_1_ek13);
		contrase_a_ek2 = (TextView) findViewById(R.id.contrase_a_ek2);
		ciudad_ek1 = (TextView) findViewById(R.id.ciudad_ek1);
		arequipa_ek1 = (TextView) findViewById(R.id.arequipa_ek1);
		vector_ek22 = (ImageView) findViewById(R.id.vector_ek22);
		etpassword = (TextView) findViewById(R.id.etpassword);
		line_1_ek15 = (ImageView) findViewById(R.id.line_1_ek15);
		etcui = (TextView) findViewById(R.id.etcui);
		apellidos = (TextView) findViewById(R.id.apellidos);
		etapellidos = (TextView) findViewById(R.id.etapellidos);
		etnombres = (TextView) findViewById(R.id.etnombres);
		line_1_ek16 = (ImageView) findViewById(R.id.line_1_ek16);

		mQueue = Volley.newRequestQueue(iphone_11_pro_max___34_activity.this);


		_rectangle_12_ek7.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				Register();
			}
		});

	}
		public void Register(){
		String password = etpassword.getText().toString();
		Log.d("Password",password);
			Map<String, String> params = new HashMap();
			params.put("First_Name", etnombres.getText().toString());
			params.put("Last_Name", etapellidos.getText().toString());
			params.put("StudentID", etcui.getText().toString());
			params.put("DNI", etdni.getText().toString());
			params.put("Mobile_Phone", etcelular.getText().toString());
			params.put("Home_Phone", "00000000");
			params.put("Email", etemail.getText().toString());
			params.put("Career", "CIENCIA DE LA COMPUTACION");
			params.put("Faculty", "FACULTAD DE SERVICIOS Y PROCESOS");
			params.put("Password", etpassword.getText().toString());
			params.put("CityID", "1");

			final JSONObject parameters = new JSONObject(params);
			Log.d("url",api.login);

			JsonObjectRequest pedirtipomarcas = new JsonObjectRequest(Request.Method.POST,api.register,  parameters,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							try {//reading JSON

								if(response.getInt("insertId")>0){
									Toast.makeText(getApplicationContext(), "Registrado Correctamente", Toast.LENGTH_SHORT).show();
									Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___24_activity.class);
									startActivity(nextScreen);
								}
								else{
									Toast.makeText(getApplicationContext(), "Error al registrarse", Toast.LENGTH_SHORT).show();
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
	
	