package com.mundotricolin.app;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class Actualizar extends Activity {
	public static final String PREFS_NAME = "MyPrefsFile";
	
	EditText Usuario, Clave;
	int TIMEOUT_MILLISEC = 10000; // = 10 seconds
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
            
    }
    
    
    public boolean clickbuttonModificar(int personaje, int color) {
    	boolean Bandera = false;
    	try {
  		
    		
    		// Leer datos
            //SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            //String IdUsuario = settings.getString("IdUsuario", "0");
    		String IdUsuario = "2";
    		
			JSONObject json = new JSONObject();
			json.put("Iduserstricolin", IdUsuario);
			json.put("Personaje", personaje);
			json.put("Color", color);
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			//
			//String url = "http://10.0.2.2:8080/sample1/webservice2.php?json={\"UserName\":1,\"FullName\":2}";
			String url = "http://dcsoftcr.com/MundoTricolin/modificarusuario.php";

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
				
				if (result.contains("Modificado"))
				{
					Toast.makeText(this, "Si se Modifico",
							Toast.LENGTH_LONG).show();
					Bandera = true;
				}
			}
				
		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
    	
    	return Bandera;
			
		}

    
}
