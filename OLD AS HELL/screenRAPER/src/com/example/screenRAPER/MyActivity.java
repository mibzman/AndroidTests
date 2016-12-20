package com.example.screenRAPER;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    private SensorManager mSensorManager;
    private PowerManager mPowerManager;
    private WindowManager mWindowManager;
    private PowerManager.WakeLock mWakeLock;
    private Button button;
    private TextView textView;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //derp();
            }
        });
    }
      public void derp() {
          AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                  context);
          alertDialogBuilder.setTitle("Network Not Available");
          alertDialogBuilder
                  .setCancelable(false)
                  .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int id) {
                          dialog.cancel();
                      }
                  })
                  .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int id) {
                          dialog.cancel();
                      }
                  });
          AlertDialog alertDialog = alertDialogBuilder.create();
          alertDialog.show();
      }

    @Override
    protected void onPause() {
        super.onPause();

        // and release our wake-lock
    }
}