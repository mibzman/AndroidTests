package com.isotope.Bookmarkr;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    String[] menu;
    DrawerLayout dLayout;
    ListView dList;
    ArrayAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        navdrawergarbage();
        dList.setItemChecked(0, true);
        dList.setSelection(0);

    }
    void navdrawergarbage() {
        menu = new String[]{"Bookmarks","Settings", "About"};
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        dList = (ListView) findViewById(R.id.left_drawer);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        dList.setAdapter(adapter);
        dList.setSelector(android.R.color.holo_blue_dark);
        Fragment Map = new Main();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, Map).commit();
       // dList.setItemChecked(0, true);
       // dList.setSelection(0);
        dList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                dLayout.closeDrawers();
                if(position == 0) {
                    Fragment Map = new Main();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Map).commit();

                }else if (position== 1){
                    Fragment Tips = new Settings();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Tips).commit();
                }else if (position== 2){
                    Fragment Settings = new About();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Settings).commit();
                }else{
                    Fragment Map = new Main();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Map).commit();
                    dList.setItemChecked(0, true);
                    dList.setSelection(0);
                }
            }

        });
    }

}


