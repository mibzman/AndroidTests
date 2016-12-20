package com.example.fragmentvogella;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sam on 2/2/2015.
 */
public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rssitem_detail,
                container, false);
        return view;
    }

    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.detail);
        view.setText(item);
    }
}
