package com.example.thingtester;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    int i = 0;
    Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textview = (TextView) findViewById(R.id.textView);
        textview.setText("here we go");
        repeatr();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                derp();
            }
        });



    }
    public void derp() {
        Intent intent = new Intent(this, Dialog.class);
        startActivity(intent);
    }
    public void repeatr() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textr();
            }
        }, 1/10000 );
    }
    public void textr(){
        final TextView textview = (TextView) findViewById(R.id.textView);
        i=i+1;
        textview.setText(""+i+"");
        repeatr();

    }
}