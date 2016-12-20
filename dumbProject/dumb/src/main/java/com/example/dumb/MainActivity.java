package com.example.dumb;

import android.os.Bundle;
import android.app.Activity;
import com.google.ads.*;

import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private AdView adView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adView
        adView = new AdView(this, (AttributeSet) AdSize.BANNER, 4);

        // Lookup your LinearLayout assuming it's been given
        // the attribute android:id="@+id/mainLayout"
       // LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);

        // Add the adView to it
        //layout.addView(adView);

        // Initiate a generic request to load it with an ad
        adView.loadAd(new AdRequest());
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}