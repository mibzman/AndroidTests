package com.mundotricolin.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends Activity {
	/** Called when the activity is first created. */
	EditText Usuario, Clave, ClaveConf, Nombre, Email, Edad, CentroEstudio;
	int TIMEOUT_MILLISEC = 10000; // = 10 seconds
	
	public static final String PREFS_NAME = "MyPrefsFile";
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
    }
    
    public void cerrar(View view) {
    	finish();
    }
    
    public void abrirPersonalizar(View view) {
        Intent i = new Intent(this, GameActivityPersonalizar.class );
        startActivity(i);
    }
    
    public void clickbuttonInsertar(View v) {
    	try {
			Usuario =  (EditText)findViewById(R.id.usuario);
			Nombre =  (EditText)findViewById(R.id.nombre);
			Email =  (EditText)findViewById(R.id.email);
			Edad =  (EditText)findViewById(R.id.edad);
			CentroEstudio =  (EditText)findViewById(R.id.institucion);
			Clave = (EditText)findViewById(R.id.password);
			ClaveConf = (EditText)findViewById(R.id.matchPassword);
			
			String strUsuario, strClave, strClaveConf, strNombre, strEmail, strEdad, strCentroEstudio, strIdUsuario;
			strUsuario = Usuario.getText().toString();
			strNombre = Nombre.getText().toString();
			strEmail = Email.getText().toString();
			strEdad = Edad.getText().toString();
			strCentroEstudio = CentroEstudio.getText().toString();
			strClave = Clave.getText().toString();
			strClaveConf = ClaveConf.getText().toString();
			
			if (strUsuario.length() > 0 && strNombre.length() > 0 && strClave.length() > 0 &&
					strEmail.length() > 0 && strEdad.length() > 0 && strCentroEstudio.length() > 0 &&
					strClave.equals(strClaveConf))
				{
			JSONObject json = new JSONObject();
			json.put("Usuario", strUsuario);
			json.put("Clave", strClave);
			json.put("Nombre", strNombre);
			json.put("Correo", strEmail);
			json.put("Edad", strEdad);
			json.put("CentroEstudio", strCentroEstudio);
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			//
			//String url = "http://10.0.2.2:8080/sample1/webservice2.php?json={\"UserName\":1,\"FullName\":2}";
			String url = "http://dcsoftcr.com/MundoTricolin/insertarusuario.php";

			HttpPost request = new HttpPost(url);
			request.setEntity(new ByteArrayEntity(json.toString().getBytes("UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			// If the response does not enclose an entity, there is no need
			if (entity != null) {
				InputStream instream = entity.getContent();

				jsonconnection Obj = new jsonconnection();
				String result = Obj.convertStreamToString(instream);
				Log.i("Read from server", result);
				Toast.makeText(this,  result,
						Toast.LENGTH_LONG).show();
				
				if (result.contains("Insertado"))
				{
					strIdUsuario = ConsultarUsuarioInsertado(v);
					
					// We need an Editor object to make preference changes.
			        // All objects are from android.context.Context
			        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			        SharedPreferences.Editor editor = settings.edit();
					editor.putString("IdUsuario", strIdUsuario);
			        // Commit the edits!
			        editor.commit();
			        
			        abrirPersonalizar(v);
				}
			}
				}
			else if (strClave.equals(strClaveConf))
				Toast.makeText(this, "Todos Los Campos Son Obligatorios",
						Toast.LENGTH_LONG).show();
			else 
				Toast.makeText(this, "La confirmacion de contraseña no concuerda",
						Toast.LENGTH_LONG).show();
		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
			
		}
    
    public String ConsultarUsuarioInsertado(View v) {
    	String usuario = "";
    	try {
			String strUsuario, strClave;
			strUsuario = Usuario.getText().toString();
			strClave = Clave.getText().toString();
			
			// http://androidarabia.net/quran4android/phpserver/connecttoserver.php

			// Log.i(getClass().getSimpleName(), "send  task - start");
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			//
			HttpParams p = new BasicHttpParams();
			// p.setParameter("name", pvo.getName());
			p.setParameter("user", "1");

			// Instantiate an HttpClient
			HttpClient httpclient = new DefaultHttpClient(p);
			String url = "http://dcsoftcr.com/MundoTricolin/consultarusuario.php?user=1&format=json&&Usuario=" + strUsuario + "&Clave=" + strClave;
			HttpPost httppost = new HttpPost(url);

			// Instantiate a GET HTTP method
			try {
				Log.i(getClass().getSimpleName(), "send  task - start");
				//
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("Usuario", "1"));
				nameValuePairs.add(new BasicNameValuePair("Clave", "1"));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				String responseBody = httpclient.execute(httppost,
						responseHandler);
				// Parse
				JSONObject json = new JSONObject(responseBody);
				JSONArray jArray = json.getJSONArray("posts");

				for (int i = 0; i < jArray.length(); i++) {
					JSONObject e = jArray.getJSONObject(i);
					String s = e.getString("post");
					JSONObject jObject = new JSONObject(s);
					
					usuario =  jObject.getString("iduserstricolin");
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Log.i(getClass().getSimpleName(), "send  task - end");
		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
		return usuario;
	}
}
