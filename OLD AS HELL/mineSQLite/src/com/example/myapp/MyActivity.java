package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private database mySQLiteAdapter;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button put = (Button) findViewById(R.id.button);
        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText get = (EditText) findViewById(R.id.editText);
                String data1 = get.getText().toString();
                mySQLiteAdapter = new database(context);
                mySQLiteAdapter.openToWrite();
                mySQLiteAdapter.insert(data1);
            }
        });
        Button get = (Button) findViewById(R.id.button2);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
