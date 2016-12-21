package com.isotope.Bookmarkr;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sam on 7/19/2015.
 */
public class Settings extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        final View view = inflater.inflate(R.layout.settings, container, false);
        return view;


    }
}