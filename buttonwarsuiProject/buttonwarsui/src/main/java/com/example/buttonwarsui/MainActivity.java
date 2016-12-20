package com.example.buttonwarsui;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.adventure);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi  ew) {
                final Intent intent = new Intent(this, MainGame.class);
                EditText points = (EditText) findViewById(R.id.editText);
                String message = points.getText().toString();
                // intent.putExtra(EXTRA_MESSAGE, message);
                CheckBox inf = (CheckBox) findViewById(R.id.checkBox);
                inf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()){
                            int message2 = 1;
                            // intent.putExtra(EXTRA_MESSAGE2, message2);
                        }

                startActivity(intent);
            }
        });
        CheckBox inf = (CheckBox) findViewById(R.id.checkBox);
        inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()){
                    EditText editText = (EditText) findViewById(R.id.editText);
                    editText.setEnabled(false);
                }else {
                    EditText editText = (EditText) findViewById(R.id.editText);
                    editText.setEnabled(true);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void sendValues() {

    }
}
