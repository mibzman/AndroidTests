package com.isotope.Bookmarkr;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Sam on 7/19/2015.
 */
public class Main extends ListFragment{

    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };

    Integer[] imgid={
            R .drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,

    };

        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
            final View view = inflater.inflate(R.layout.bookmarks, container, false);
            com.isotope.Bookmarkr.CustomListAdapter adapter = new com.isotope.Bookmarkr.CustomListAdapter(this, itemname, imgid);
            setListAdapter(adapter);
            return view;


        }
}
