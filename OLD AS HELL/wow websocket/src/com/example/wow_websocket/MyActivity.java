package com.example.wow_websocket;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button pull = (Button)findViewById(R.id.pulling_button);
        if(PullingService.hasAlarm(this)){
            pull.setText("Stop Service");
        }
        else {
            pull.setText("Start Service");
        }
        pull.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(PullingService.hasAlarm(MyActivity.this)){
                    AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                    PendingIntent pi = PullingService.createIntent(MyActivity.this);
                    am.cancel(pi);
                    pi.cancel();
                    pull.setText("Start Service");
                }
                else {
                    Intent i = new Intent(MyActivity.this, PullingService.class);
                    startService(i);
                    pull.setText("Stop Service");
                }
            }
        });
    }

}
