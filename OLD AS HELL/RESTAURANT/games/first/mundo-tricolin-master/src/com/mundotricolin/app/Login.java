package com.mundotricolin.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
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

public class Login extends Activity {
	/** Called when the activity is first created. */
	EditText Usuario, Clave;
	int TIMEOUT_MILLISEC = 10000; // = 10 seconds
	
	public static final String PREFS_NAME = "MyPrefsFile";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    
    public void cerrar(View view) {
    	finish();
    }
    
    public void abrirMundo(View view) {
        Intent i = new Intent(this, GameActivity.class );
        startActivity(i);
    }
    
    public void clickbuttonConsultar(View v) {
		try {
			String idUsuario = "";
			Usuario =  (EditText)findViewById(R.id.nick);
			Clave =  (EditText)findViewById(R.id.pass);

			String strUsuario, strClave;
			strUsuario = Usuario.getText().toString();
			strClave = Clave.getText().toString();
			
			
			if (strUsuario.length() >0 && strClave.length() > 0 )
			{
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
					
					idUsuario =  jObject.getString("iduserstricolin");
				}
				
				if (!"".equals(idUsuario))
				{
					abrirMundo(v);
					// We need an Editor object to make preference changes.
			        // All objects are from android.context.Context
			        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			        SharedPreferences.Editor editor = settings.edit();
					editor.putString("IdUsuario", idUsuario);
			        // Commit the edits!
			        editor.commit();
				}
				else
					Toast.makeText(this, "No se encontro el usuario/contraseña", Toast.LENGTH_LONG).show();

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Log.i(getClass().getSimpleName(), "send  task - end");
			}
			else
			{
				Toast.makeText(this, "Debe llenar todos los campos",
						Toast.LENGTH_LONG).show();				
			}
		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
	}
}
