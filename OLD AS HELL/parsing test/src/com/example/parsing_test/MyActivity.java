package com.example.parsing_test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try{
        Document doc = Jsoup.connect("http://megatokyo.com").get();
                Elements titleDivs = doc.select("div#comic");
            Element mySpan = titleDivs.first();
            Element myDiv = mySpan.child(0);;
                Element theDiv = myDiv.child(1);
                String title = theDiv.ownText();
                TextView view = (TextView) findViewById(R.id.textView);
                view.setText(title);
        }catch (IOException k){
            // LOG mabye?
        }
    }
}
