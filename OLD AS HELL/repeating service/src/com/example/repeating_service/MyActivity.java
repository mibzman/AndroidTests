package com.example.repeating_service;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Calendar;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private PendingIntent pendingIntent;
    int counter = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // startService();
        thing();


       /* Intent intent = new Intent(this, MyAlarmService.class);
        // add infos for the service which file to download and where to store

        startService(intent);     */
    }
    public void repeatr() {
         if (true) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    thing();
                }
            }, 200);
        }
    }
    public void thing() {
        TextView textView1 = (TextView) findViewById(R.id.textView);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        if (check()){
           textView1.setText("the service is running");
        } else {
            textView1.setText("the service is not running");
        }
        textView2.setText(" " + counter + " ");
        counter++;
        if (counter == 20){
            startService();
        } else {
            //cry about it
        }
        repeatr();
    }
    public boolean check(){
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE))
        {
            if ("com.example.repeating_service.MyAlarmService"
                    .equals(service.service.getClassName()))
            {
                return true;
            }
        }
        return false;
    }
    public void startService() {
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(this, MyAlarmService.class);
        PendingIntent pintent = PendingIntent.getService(this, 0, intent, 0);
        AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
// Start every 30 seconds
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 60 * 1000, pintent);
    }
}
