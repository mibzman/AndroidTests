package com.example.pedometerfragment;

import android.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sam on 3/2/2015.
 */
public class Mapscreen extends Fragment {
    //location at paul's seat: Lat:41.4846039, Long:-81.7835846
   // LocationManager locationManager;
    //LocationListener locationListener;

    float oldX = 0;
    float oldY = 0;
    LocationManager locationManager;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        final View view = inflater.inflate(R.layout.mapscreen, container, false);
        Button button = (Button) view.findViewById(R.id.Start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstAnimation(view);

            }
        });

        return view;


    }
    void firstAnimation(final View view){
        View animatedView = view.findViewById(R.id.wizard);
        final float x = -50;
        final float y =0;
        TranslateAnimation animation = new TranslateAnimation(
                oldX, (x + oldX), oldY, (y +oldY)
        );
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animatedView.startAnimation(animation);
        oldX = (x+oldX);
        oldY = (x+oldY);
        //secondAnimation(view);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                secondAnimation(view);
            }
        }, 1000);
    }
    void secondAnimation(View view){
        View animatedView = view.findViewById(R.id.wizard);
        final float x = 0;
        final float y =-100;
        TranslateAnimation animation = new TranslateAnimation(
                oldX, (x + oldX), oldY, (y +oldY)
        );
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animatedView.startAnimation(animation);
        oldX = (x+oldX);
        oldY = (x+oldY);
    }
}
