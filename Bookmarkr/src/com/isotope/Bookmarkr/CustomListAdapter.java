package com.isotope.Bookmarkr;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.isotope.Bookmarkr.R;

/**
 * Created by Sam on 7/20/2015.
 */
public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity activity;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter(Activity activity, String[] itemname, Integer[] imgid){
        super(activity, R.layout.mylist, itemname);
        this.activity = activity;
        this.itemname = itemname;
        this.imgid = imgid;

    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflator = activity.getLayoutInflater();
        View rowView = inflator.inflate(R.layout.mylist, null, true);

        Button imageView = (Button) rowView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.second);

        txtTitle.setText(itemname[position]);
        imageView.setText("butt");
        extratxt.setText("Description: "+itemname[position]);
        return rowView;
    }
}

