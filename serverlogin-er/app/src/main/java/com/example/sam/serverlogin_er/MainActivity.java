package com.example.sam.serverlogin_er;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://crowd-diet-mcat12.c9users.io/users";
// Request a string response from the provided URL.
        StringRequest my_req = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TextView mTextView = (TextView) findViewById(R.id.textBox);
                mTextView.setText("Login success");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextView mTextView = (TextView) findViewById(R.id.textBox);
                mTextView.setText("Login failure: " + error.toString());
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", "android");
                params.put("password", "stupidpassword");
                params.put("name", "Ann Droid");
                return params;
            }
        };

// Add the request to the RequestQueue.
        queue.add(my_req);
    }
}
