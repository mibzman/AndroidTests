package com.example.Service_do;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Sam on 7/21/14.
 */
public class MyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        //TODO for communication return IBinder implementation
        return null;
    }
}
