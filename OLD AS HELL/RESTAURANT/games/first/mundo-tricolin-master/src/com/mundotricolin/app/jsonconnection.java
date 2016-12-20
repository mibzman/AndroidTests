package com.mundotricolin.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class jsonconnection extends Activity {
	/** Called when the activity is first created. */
	public int iLanguage = 0;
	TextView lbl;
	EditText editText;
	EditText Usuario, Nombre, Email, Edad, CentroEstudio;
	Typeface arabicFont = null;
	int TIMEOUT_MILLISEC = 10000; // = 10 seconds

	
	/*
	public void onCreate(Bundle savedInstanceState) {
		try {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			getWindow().setLayout(android.view.ViewGroup.LayoutParams.FILL_PARENT,
					android.view.ViewGroup.LayoutParams.FILL_PARENT);
			// ////
			arabicFont = Typeface.createFromAsset(getAssets(),
					"fonts/DroidSansArabic.ttf");

			lbl = (TextView) findViewById(R.id.lbl);
			editText = (EditText)findViewById(R.id.editText1);
			Usuario =  (EditText)findViewById(R.id.txtUsuario);
			Mensaje = (EditText)findViewById(R.id.txtMensaje);
			//

		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
	}
*/
	public void InsertarRegistro(View v) {
		try {
			Usuario =  (EditText)findViewById(R.id.usuario);
			Nombre =  (EditText)findViewById(R.id.nombre);
			Email =  (EditText)findViewById(R.id.email);
			Edad =  (EditText)findViewById(R.id.edad);
			CentroEstudio =  (EditText)findViewById(R.id.institucion);
			
			
			String strUsuario, strNombre, strEmail, strEdad, strCentroEstudio;
			strUsuario = Usuario.getText().toString();
			strNombre = Nombre.getText().toString();
			strEmail = Email.getText().toString();
			strEdad = Edad.getText().toString();
			strCentroEstudio = CentroEstudio.getText().toString();
			if (strUsuario.length() > 0 && strNombre.length() > 0)
				{
			JSONObject json = new JSONObject();
			json.put("Usuario", strUsuario);
			json.put("Clave", "AA");
			json.put("Nombre", strNombre);
			json.put("Correo", strEmail);
			json.put("Edad", strEdad);
			json.put("CentroEstudio", strCentroEstudio);
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			//
			//String url = "http://10.0.2.2:8080/sample1/webservice2.php?json={\"UserName\":1,\"FullName\":2}";
			String url = "http://dcsoftcr.com/MundoTricolin/insertarusuario.php";

			HttpPost request = new HttpPost(url);
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			// If the response does not enclose an entity, there is no need
			if (entity != null) {
				InputStream instream = entity.getContent();

				String result = convertStreamToString(instream);
				Log.i("Read from server", result);
				Toast.makeText(this,  result,
						Toast.LENGTH_LONG).show();
			}
				}
			else
				Toast.makeText(this, "Los Campos Usuario/Mensaje son Obligatorios",
						Toast.LENGTH_LONG).show();
		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
	}
	
	public String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}
	
	public void clickbutton(View v) {
		try {
			String strMensaje, strUsuario, strAux, strTotal;
			// http://androidarabia.net/quran4android/phpserver/connecttoserver.php

			// Log.i(getClass().getSimpleName(), "send  task - start");
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			//
			HttpParams p = new BasicHttpParams();
			// p.setParameter("name", pvo.getName());
			p.setParameter("user", "1");

			// Instantiate an HttpClient
			HttpClient httpclient = new DefaultHttpClient(p);
			String url = "http://dcsoftcr.com/PrograAndroid/webservice1.php?user=1&format=json";
			HttpPost httppost = new HttpPost(url);

			// Instantiate a GET HTTP method
			try {
				strTotal = "";
				Log.i(getClass().getSimpleName(), "send  task - start");
				//
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
						2);
				nameValuePairs.add(new BasicNameValuePair("user", "1"));
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
					
					strUsuario = jObject.getString("Usuario");
					strMensaje = jObject.getString("Mensaje");
					strAux = "[" + strUsuario + "] " + strMensaje + "\n\r";
					strTotal = strTotal + strAux;
					
				}
				//Toast.makeText(this, responseBody, Toast.LENGTH_LONG).show();
				

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
	}
}

