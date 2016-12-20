package com.example.datasaver;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
String FILENAME = "hello_file";
String string = "hello world!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInput();
    }

    public void getInput() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
                String dataMessage = editText.getText().toString();
                SharedPreferences data = getSharedPreferences(FILENAME, 0);
                String derp = getSharedPreferences(FILENAME,);
            }
        });
    }
    public void saveData() {
        SharedPreferences data = getSharedPreferences(FILENAME, 0);
        String dataMessage
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
