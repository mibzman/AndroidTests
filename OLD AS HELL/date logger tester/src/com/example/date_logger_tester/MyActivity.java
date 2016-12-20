package com.example.date_logger_tester;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    SharedPreferences data;
    public static String filename = "first";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final String name = editText.getText().toString();
        Button save = (Button) findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = editText.getText().toString();
                SharedPreferences.Editor editor = data.edit();
                editor.putString("key", name);
                editor.commit();
            }
        });
        Button post = (Button) findViewById(R.id.button2);
        final TextView textView = (TextView) findViewById(R.id.textView);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String result = data.getString("key", "default");
               textView.setText("" +result + "");
            }
        });

    }
}
