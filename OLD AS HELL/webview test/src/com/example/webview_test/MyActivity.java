package com.example.webview_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
            WebView webView = (WebView) findViewById(R.id.webView);
            Document doc = Jsoup.connect("http://megatokyo.com/").get();
            Elements spans = doc.select("span#strip-bl");
            Element mySpan = spans.first();
            Element image = mySpan.child(0);
        }catch(Exception e){
            Log.e("Image", "Failed to load image", e);
        }
    }
}
