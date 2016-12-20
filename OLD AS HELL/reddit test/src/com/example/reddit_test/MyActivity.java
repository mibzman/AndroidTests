package com.example.reddit_test;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://www.reddit.com/r/thebutton");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
