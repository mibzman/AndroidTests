package com.example.sam.clous9test;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 6/25/2016.
 */

public class NewEntry extends Fragment {

    String selectedFood = null;
    List<String> foodList = new ArrayList<>();
    Context context = getActivity().getApplicationContext();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.new_entry, container, false);
        addFoods();
        Spinner spinner = (Spinner) getView().findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        String arraySpinner[] = new String[] {
                "1", "2", "3", "4", "5"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, arraySpinner);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        return view;
    }

    public void addFoods(){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://crowd-diet-mcat12.c9users.io/users";

        boolean oops = false;
// Request a string response from the provided URL.
        JsonArrayRequest jsObjRequest =new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int n= 0; n < response.length(); n++){
                    try{
                        String name = response.getJSONObject(n).get("name").toString();
                        foodList.add(name);

                    }catch (Exception ex){
                        //TODO: handle this exception
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        selectedFood = parent.getItemAtPosition(pos).toString();
    }
}
