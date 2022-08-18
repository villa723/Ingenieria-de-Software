
	 
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import data.Info;

	public class iphone_11_pro_max___28_activity extends Activity {

	
	private View _bg__iphone_11_pro_max___28_ek2;
	private TextView mi_perfil;
	private View rectangle_2_ek1;
	private TextView salir_de_la_sesi_n;
	private ImageView vector_ek5;
	private TextView informaci_n_personal;
	private View rectangle_10_ek2;
	private TextView alumno_apellido_ek1;
	private TextView alumno_unsa_edu_pe_ek1;
	private TextView estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios_ek1;
	private TextView __234_9011039271;
	private View rectangle_10_ek3;
	private TextView agenda;
	private ImageView vector_ek6;
	private View rectangle_10_ek4;
	private TextView editar_perfil;
	private ImageView vector_ek7;
	private View rectangle_10_ek5;
	private TextView asesoria;
	private ImageView vector_ek8;
	private View rectangle_10_ek6;
	private TextView soporte;
	private ImageView vector_ek9;
	private View rectangle_15_ek1;
	private TextView _cambiar_contrase_a;
	private String idUser = "";
	private RequestQueue mQueue;
	private Info api = new Info();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.iphone_11_pro_max___28);

		
		_bg__iphone_11_pro_max___28_ek2 = (View) findViewById(R.id._bg__iphone_11_pro_max___28_ek2);
		mi_perfil = (TextView) findViewById(R.id.mi_perfil);
		rectangle_2_ek1 = (View) findViewById(R.id.rectangle_2_ek1);
		salir_de_la_sesi_n = (TextView) findViewById(R.id.salir_de_la_sesi_n);
		vector_ek5 = (ImageView) findViewById(R.id.vector_ek5);
		informaci_n_personal = (TextView) findViewById(R.id.informaci_n_personal);
		rectangle_10_ek2 = (View) findViewById(R.id.rectangle_10_ek2);
		alumno_apellido_ek1 = (TextView) findViewById(R.id.alumno_apellido_ek1);
		alumno_unsa_edu_pe_ek1 = (TextView) findViewById(R.id.alumno_unsa_edu_pe_ek1);
		estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios_ek1 = (TextView) findViewById(R.id.estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios_ek1);
		__234_9011039271 = (TextView) findViewById(R.id.__234_9011039271);
		rectangle_10_ek3 = (View) findViewById(R.id.rectangle_10_ek3);
		agenda = (TextView) findViewById(R.id.agenda);
		vector_ek6 = (ImageView) findViewById(R.id.vector_ek6);

		rectangle_10_ek5 = (View) findViewById(R.id.rectangle_10_ek5);
		asesoria = (TextView) findViewById(R.id.asesoria);
		vector_ek8 = (ImageView) findViewById(R.id.vector_ek8);
		rectangle_10_ek6 = (View) findViewById(R.id.rectangle_10_ek6);
		soporte = (TextView) findViewById(R.id.soporte);
		vector_ek9 = (ImageView) findViewById(R.id.vector_ek9);
		rectangle_15_ek1 = (View) findViewById(R.id.rectangle_15_ek1);


		try
		{
			BufferedReader fin =
					new BufferedReader(
							new InputStreamReader(
									openFileInput("id.txt")));
			idUser = fin.readLine();
			fin.close();

		}
		catch (Exception ex)
		{
			Toast.makeText(getApplicationContext(), "Sin datos de sesión", Toast.LENGTH_LONG).show();
		}
		mQueue = Volley.newRequestQueue(iphone_11_pro_max___28_activity.this);
		Log.d("idUser",idUser);
		GetData();

		_cambiar_contrase_a.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				//cambiar contraseña
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___36_activity.class);
				startActivity(nextScreen);
			}
		});

		rectangle_10_ek3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//agenda
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___29_activity.class);
				startActivity(nextScreen);
			}
		});

		rectangle_10_ek6.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//soporte
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___39_activity.class);
				startActivity(nextScreen);
			}
		});
		rectangle_10_ek5.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//Asesoria
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___54_activity.class);
				startActivity(nextScreen);
			}
		});
		
		
		//custom code goes here
	
	}

		public void GetData(){
			JsonObjectRequest pedirtipomarcas = new JsonObjectRequest(Request.Method.GET,api.info+"/"+idUser,  null,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							try {//reading JSON
								if(response!=null){
									alumno_apellido_ek1.setText(response.getJSONObject("Alumno").getString("First_Name")+" "+response.getJSONObject("Alumno").getString("Last_Name"));
									alumno_unsa_edu_pe_ek1.setText(response.getJSONObject("Alumno").getString("Email"));
									estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios_ek1.setText(response.getJSONObject("Alumno").getString("Career")+ " " +response.getJSONObject("Alumno").getString("Faculty"));
									__234_9011039271.setText(response.getJSONObject("Alumno").getString("Mobile_Phone"));
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
	
	