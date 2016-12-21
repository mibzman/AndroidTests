package com.example.Goddamned_ListView;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

public class MyActivity extends ListActivity {
    /**
     * Called when the activity is first created.
     */

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        CustomListAdapter adapter = new CustomListAdapter(MyActivity.this, itemname, imgid);
        setListAdapter(adapter);
    }

}
