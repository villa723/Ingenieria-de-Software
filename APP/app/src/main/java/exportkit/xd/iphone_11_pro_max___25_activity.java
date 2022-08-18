
	 
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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

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
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import Adapters.CursosAdapter;
import Models.Curso;
import data.Info;

	public class iphone_11_pro_max___25_activity extends AppCompatActivity {

	private View _bg__iphone_11_pro_max___25_ek2;
	private TextView cursos_hoy;
	private TextView bienvenido_estudiante;
	private View _rectangle_10;
	private View rectangle_11;
	private TextView ciencia_de_la_computaci_n;
	private TextView alumno_apellido;
	private TextView estudiante_unsa_edu_pe;
	private TextView estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios;
	private TextView _7_00_am___8_40_am;
	private TextView _3_00_pm___4_40_pm;
	private TextView _8_50_am___10_30_am;
	private View rectangle_2;
	private TextView marcar_asistencia;
	private ImageView vector;
	private TextView c_lculo_en_varias_variables;
	private View rectangle_12_ek1;
	private View line_3;
	private View ellipse_7;
	private View ellipse_8;
	private TextView trabajo_intedisciplinar;
	private TextView ingl_s_t_cnico_3;
	private View rectangle_12_ek2;
	private View line_3_ek1;
	private View ellipse_7_ek1;
	private View rectangle_12_ek3;
	private View ellipse_7_ek2;
	private ImageView vector_ek1;
	private ImageView vector_ek2;
	private ImageView vector_ek3;
	private View image_14;
	private View _rectangle_3_ek1;
	private TextView horario;
	private View rectangle_10_ek1;
	private TextView ir_a_reportes;
	private ImageView vector_ek4;
	private View rectangle_15;
	private Executor executor;
	private BiometricPrompt biometricPrompt;
	private BiometricPrompt.PromptInfo promptInfo;
	private String idUser = "";
	private RequestQueue mQueue;
	private Info api = new Info();
	private ListView lvcursos;
	public ArrayList<Curso> cursos = new ArrayList<>();
	Context contextapp = this;
	CursosAdapter adapter;
	private Integer idcurso=0;
	private Curso cursoseleccionado;

        private ArrayList<String> names;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.iphone_11_pro_max___25);

		
		_bg__iphone_11_pro_max___25_ek2 = (View) findViewById(R.id._bg__iphone_11_pro_max___25_ek2);
		cursos_hoy = (TextView) findViewById(R.id.cursos_hoy);
		bienvenido_estudiante = (TextView) findViewById(R.id.bienvenido_estudiante);
		_rectangle_10 = (View) findViewById(R.id._rectangle_10);
		ciencia_de_la_computaci_n = (TextView) findViewById(R.id.ciencia_de_la_computaci_n);
		alumno_apellido = (TextView) findViewById(R.id.alumno_apellido);
		estudiante_unsa_edu_pe = (TextView) findViewById(R.id.estudiante_unsa_edu_pe);
		estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios = (TextView) findViewById(R.id.estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios);
		rectangle_2 = (View) findViewById(R.id.rectangle_2);
		marcar_asistencia = (TextView) findViewById(R.id.marcar_asistencia);
		vector = (ImageView) findViewById(R.id.vector);
		//image_14 = (View) findViewById(R.id.image_14);
		_rectangle_3_ek1 = (View) findViewById(R.id._rectangle_3_ek1);
		horario = (TextView) findViewById(R.id.horario);
		rectangle_15 = (View) findViewById(R.id.rectangle_15);
		lvcursos = findViewById(R.id.lvcursos);
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
		mQueue = Volley.newRequestQueue(iphone_11_pro_max___25_activity.this);
		Log.d("idUser",idUser);
		GetData();
		//huella digital
		executor = ContextCompat.getMainExecutor(this);
		biometricPrompt = new BiometricPrompt(iphone_11_pro_max___25_activity.this,
				executor, new BiometricPrompt.AuthenticationCallback() {
			@Override
			public void onAuthenticationError(int errorCode,
											  @NonNull CharSequence errString) {
				super.onAuthenticationError(errorCode, errString);
				Toast.makeText(getApplicationContext(),
						"Authentication error: " + errString, Toast.LENGTH_SHORT)
						.show();
			}
			@Override
			public void onAuthenticationSucceeded(
					@NonNull BiometricPrompt.AuthenticationResult result) {
				super.onAuthenticationSucceeded(result);
				Toast.makeText(getApplicationContext(),
						"Authentication succeeded!", Toast.LENGTH_SHORT).show();
				Asistencia(cursoseleccionado);
				Log.d("Click","autenticación correcta");
				//tv_auth.setText("Autenticación correcta");
			}
			@Override
			public void onAuthenticationFailed() {
				super.onAuthenticationFailed();
				Toast.makeText(getApplicationContext(), "Authentication failed",
						Toast.LENGTH_SHORT)
						.show();
			}
		});
		promptInfo = new BiometricPrompt.PromptInfo.Builder()
				.setTitle("Autenticación biometrica")
				.setSubtitle("Es necesario comprobar su huella digital para continuar")
				.setNegativeButtonText("Use account password")
				.build();
		_rectangle_10.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___28_activity.class);
				startActivity(nextScreen);
			}
		});
		//Horarios
		_rectangle_3_ek1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___27_activity.class);
				startActivity(nextScreen);
			}
		});
		//reportes
		rectangle_10_ek1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), iphone_11_pro_max___44_activity.class);
				startActivity(nextScreen);
			}
		});
		//Marcar Asistencia
		rectangle_2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				biometricPrompt.authenticate(promptInfo);
			}
		});
        lvcursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Curso curso = (Curso) adapter.getItem(position);
                Log.d("listview","tocado "+curso.getId());
                idcurso = curso.getId();
                cursoseleccionado = curso;
                Toast.makeText(getApplicationContext(), curso.getCourse_name()+" SELECCIONADO", Toast.LENGTH_LONG).show();

            }
        });
	}
		public void GetData(){
			JsonObjectRequest pedirtipomarcas = new JsonObjectRequest(Request.Method.GET,api.info+"/"+idUser,  null,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							try {//reading JSON
								if(response!=null){
									alumno_apellido.setText(response.getJSONObject("Alumno").getString("First_Name")+" "+response.getJSONObject("Alumno").getString("Last_Name"));
									estudiante_unsa_edu_pe.setText(response.getJSONObject("Alumno").getString("Email"));
									estudiante_de_la_escuela_ciencia_de_la_computaci_n_de_produccion_y_servicios.setText(response.getJSONObject("Alumno").getString("Career")+ " " +response.getJSONObject("Alumno").getString("Faculty"));
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
        public void Asistencia(Curso curso){
            Map<String, String> params = new HashMap();
            if(curso==null) Log.d("curso","esta null");
            else Log.d("curso",String.valueOf(curso.getId()));
            params.put("studentid", idUser);
            params.put("professorid","1");
            params.put("curseid",String.valueOf(curso.getId()));
            final JSONObject parameters = new JSONObject(params);
            JsonObjectRequest pedirtipomarcas = new JsonObjectRequest(Request.Method.POST,api.asistencia,  parameters,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {//reading JSON
                                if(response.getString("asistencia").equals("ok")){
                                    Toast.makeText(getApplicationContext(), "Asistencia Registrada", Toast.LENGTH_LONG).show();

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
            adapter = new CursosAdapter(this,cursos);
            lvcursos.setAdapter(adapter);
        }
}
	
	