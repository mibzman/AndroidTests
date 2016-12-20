package com.example.PARSE_test;

import android.app.Activity;
import android.os.Bundle;
import com.parse.Parse;
import com.parse.ParseObject;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "WtPLFX0KdCuvbojtfUWyH6fimCBphi1QdUelcuNo", "IRELPDxZNpZJTkK6swJkK8uTyI9dMC1GNyiKT3Bp");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
