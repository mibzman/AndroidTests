package com.example.Spooky_scary_Skeletons;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by Sam on 8/3/2015.
 */
public class AlarmReciever extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO Auto-generated method stub


        // here you can start an activity or service depending on your need
        // for ex you can start an activity to vibrate phone or to ring the phone

        String phoneNumberReciver="2169701157";// phone number to which SMS to be send
        String message="Hi I will be there later, See You soon";// message to send
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumberReciver, null, message, null, null);
        // Show the toast  like in above screen shot
        Toast.makeText(context, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();
    }

}
