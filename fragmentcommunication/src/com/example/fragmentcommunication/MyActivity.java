package com.example.fragmentcommunication;


import com.example.fragmentcommunication.ListFragment.ListItemSelectedListener;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;

import android.util.Log;

public class MyActivity extends FragmentActivity implements ListItemSelectedListener{

    public static final String TAG = "MainActiviyt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            setContentView(R.layout.main);
        }
        catch(Exception e)
        {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void listItemSelectedListener(String name)
    {
        DetailsFragment detailsFragment = new DetailsFragment();

        detailsFragment.getItemValue(name, this);
    }

}
