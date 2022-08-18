
	 
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Adapters.CursosAdapter;
import Adapters.HorarioAdapter;
import Models.Curso;
import data.Info;

	public class iphone_11_pro_max___27_activity extends Activity {

	
	private View _bg__iphone_11_pro_max___27_ek2;
	private TextView horario_ek1;
	private ImageView vector_ek10;
	private TextView mi_rcoles;
	private View rectangle_11_ek1;
	private TextView calculo_en_varias_variables_7_00_am___8_40_am;
	private View line_3_ek2;
	private TextView desarrollo_basado_en_plataformas_8_50_am___10_30_am;
	private View rectangle_11_ek2;
	private TextView calculo_en_varias_variables_7_00_am___8_40_am_ek1;
	private View line_3_ek3;
	private TextView desarrollo_basado_en_plataformas_8_50_am___10_30_am_ek1;
	private View rectangle_10_ek7;
	private TextView lunes;
	private View rectangle_11_ek3;
	private TextView calculo_en_varias_variables_7_00_am___8_40_am_ek2;
	private View line_3_ek4;
	private TextView ingles_t_cnico_3_3_00_pm___4_00_pm;
	private View rectangle_10_ek8;
	private TextView martes;
	private View rectangle_10_ek9;
	private TextView mi_rcoles_ek1;
	private ListView horarios;
		private String idUser = "";
		private RequestQueue mQueue;
		private Info api = new Info();
		Context contextapp = this;
		HorarioAdapter adapter;
		public ArrayList<Curso> cursos = new ArrayList<>();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.iphone_11_pro_max___27);

		
		_bg__iphone_11_pro_max___27_ek2 = (View) findViewById(R.id._bg__iphone_11_pro_max___27_ek2);
		horario_ek1 = (TextView) findViewById(R.id.horario_ek1);
		vector_ek10 = (ImageView) findViewById(R.id.vector_ek10);
		mi_rcoles = (TextView) findViewById(R.id.mi_rcoles);
		horarios = findViewById(R.id.horario);
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
		mQueue = Volley.newRequestQueue(iphone_11_pro_max___27_activity.this);
		Log.d("idUser",idUser);
		GetData();


	}

		public void GetData(){
			JsonObjectRequest pedirtipomarcas = new JsonObjectRequest(Request.Method.GET,api.info+"/"+idUser,  null,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							try {//reading JSON
								if(response!=null){

									JSONArray cursosresponse = response.getJSONArray("Cursos");
									for(int i=0;i<cursosresponse.length();i++){
										Curso newcurso = new Curso(cursosresponse.getJSONObject(i).getInt("CourseID"),cursosresponse.getJSONObject(i).getString("Course_Name"),cursosresponse.getJSONObject(i).getString("Section_Name"),cursosresponse.getJSONObject(i).getString("Type_Name"),cursosresponse.getJSONObject(i).getString("Day"),cursosresponse.getJSONObject(i).getString("Start"),cursosresponse.getJSONObject(i).getString("Finish"));
										cursos.add(newcurso);
									}
									setData();
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
		public void setData(){
			adapter = new HorarioAdapter(this,cursos);
			horarios.setAdapter(adapter);
		}
}
	
	