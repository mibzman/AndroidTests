package com.example.adjust_margin;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView dot = (ImageView) findViewById(R.id.imageView);
                ViewGroup.LayoutParams params = dot.getLayoutParams();
                int marginBottom = ((RelativeLayout.LayoutParams) params).bottomMargin;
                ViewGroup.MarginLayoutParams lpimgFooter = (ViewGroup.MarginLayoutParams) dot.getLayoutParams();
                lpimgFooter.bottomMargin = marginBottom +20;
                lpimgFooter.leftMargin = 1;
                dot.setLayoutParams(lpimgFooter);
            }
        });
    }
}
