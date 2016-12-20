package com.example.repeating_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Sam on 7/22/2014.
 */
public class MyReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Intent service1 = new Intent(context, MyAlarmService.class);
        context.startService(service1);

    }
}
