package com.example.fragment_changer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class myFragment extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        LinearLayout linLayout=
                new LinearLayout(getActivity());
        Button b = new Button(getActivity());
        b.setText("Hello Button");
        linLayout.addView(b);

        return linLayout;
    }
}
