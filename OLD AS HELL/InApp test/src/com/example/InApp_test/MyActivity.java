package com.example.InApp_test;

import android.app.Activity;
import android.os.Bundle;
import com.startapp.android.publish.StartAppSDK;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "107171153", "207061844", true);
        setContentView(R.layout.main);
    }
}
