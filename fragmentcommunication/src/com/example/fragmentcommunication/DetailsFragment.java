package com.example.fragmentcommunication;

/**
 * Created by Sam on 5/27/2015.
 */



import android.content.Context;

import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.TextView;

public class DetailsFragment extends Fragment
{
    private static TextView tvOne;

    private View v;

    Context context;

    private static final String TAG = "DetailsFragment";

    public void getItemValue(String itemName, Context context)
    {
        this.context = context;

        tvOne.setText("Welcome to : "+itemName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        inflater = (LayoutInflater)getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.fragment_details_fragment, null, false);

        tvOne = (TextView)v.findViewById(R.id.detailsView);

        onCreate(savedInstanceState);

        return v;
    }
}



